package com.shiwulian.wechat.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.StringUtils;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class AliYunOssUtil {

	public final static Logger logger = LoggerFactory.getLogger(AliYunOssUtil.class);
	private final static AtomicReference<OSSClient> configureRef = new AtomicReference<OSSClient>();

	private final static long aliyun_maxBuffLength = 10485760;// 10MB
	private final static String regex = ".*";

	private static OSSClient ossClient;
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				shutdown();
			}
		}));
		ossClient = build(SysConfig.aliyun_endpoint, SysConfig.aliyun_accessKeyId, SysConfig.aliyun_accessKeySecret);
	}

	public static OSSClient build(final String endpoint, final String accessKeyId, final String accessKeySecret) {
		logger.debug("OSSClient is initing!");
		if (configureRef.get() != null) {
			return configureRef.get();
		}

		OSSClient ossClient = null;
		try {
			synchronized (AliYunOssUtil.class) {
				ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
				logger.debug("OSSClient initilization successful!");
				configureRef.set(ossClient);
			}
		} catch (Exception e) {
			logger.error("initilization faild!");
		}
		return ossClient;
	}

	/**
	 * 向阿里云的OSS存储中存储文件
	 * 
	 * @param items 上传文件集合
	 * @return Triplet Triplet<是否成功,附件路径/错误提示信息/唯一MD5数字签名,错误信息>
	 */
	public static final Triplet<Boolean, Object, String> uploadObjectOSS(List<FileItem> items) {
		return uploadObjectOSS(items, SysConfig.aliyun_bucketName);
	}

	/**
	 * 向阿里云的OSS存储中存储文件
	 * 
	 * @param items 上传文件集合
	 * @param bucketName bucketName名称
	 * @return Triplet Triplet<是否成功,附件路径/错误提示信息/唯一MD5数字签名,错误信息>
	 */
	public static final Triplet<Boolean, Object, String> uploadObjectOSS(List<FileItem> items,String bucketName) {
		return uploadObjectOSS(items, SysConfig.aliyun_bucketName, "upload");
	}

	/**
	 * 向阿里云的OSS存储中存储文件
	 * 
	 * @param items 上传文件集合
	 * @param bucketName bucketName名称
	 * @param folderName 文件上传存储文件夹
	 * @return Triplet Triplet<是否成功,附件路径/错误提示信息/唯一MD5数字签名,错误信息>
	 */
	public static final Triplet<Boolean, Object, String> uploadObjectOSS(List<FileItem> items, String bucketName, String folderName) {
		try {
			List<Map<String, String>> result = new ArrayList<>();
			for (FileItem fileItem : items) {
				String fileName = fileItem.getName();
				InputStream stream = fileItem.getInputStream();
				if (stream.available() > aliyun_maxBuffLength) {
					return Triplet.with(false, null, "上传附件超出大小限制,最大为10MB");
				}
				if (fileName != null && fileName.toString().lastIndexOf("\\") > -1) { // 兼容IE
					fileName = fileName.toString().substring(fileName.toString().lastIndexOf("\\") + 1);
				}
				String prefix = fileName.substring(fileName.lastIndexOf("."));
				Pattern pattern = Pattern.compile(regex);
				Matcher match = pattern.matcher(prefix.toUpperCase());
				if (!match.matches()) {
					return Triplet.with(false, null, "上传文件格式不正确");
				}
				String realFileName = (StringUtils.isNotBlank(folderName) && folderName.endsWith("/") ? folderName : folderName + "/") + UUID.randomUUID().toString() + prefix;
				ObjectMetadata metadata = new ObjectMetadata();
				metadata.setContentLength(stream.available());

				PutObjectResult putResult = ossClient.putObject(bucketName, realFileName, stream, metadata);
				Map<String, String> map = new HashMap<String, String>();
				map.put("filePath", SysConfig.aliyun_bucketHost + realFileName);
				map.put("fileName", fileName);
				map.put("ETag", putResult.getETag());
				result.add(map);
			}
			return Triplet.with(true, result, null);
		} catch (Exception e) {
			logger.error("uploadObjectOSS error {}", e);
			return Triplet.with(false, null, "上传失败,请重新上传");
		}
	}

	/**
	 * 据key删除OSS服务器上的文件
	 * 
	 * @param diskName
	 *            文件路径
	 * @param key
	 *            Bucket下的文件的路径名+文件名
	 */
	public static final void deleteFile(String diskName, String key) {
		deleteFile(SysConfig.aliyun_bucketName, diskName, key);
	}

	public static final void deleteFile(String bucketName, String diskName, String key) {
		ossClient.deleteObject(bucketName, diskName + key);
	}

	private static void shutdown() {
		if (configureRef.get() == null)
			return;

		synchronized (AliYunOssUtil.class) {
			try {
				if (ossClient != null)
					ossClient.shutdown();
				logger.debug("OSSClient shutdown successful!");
			} catch (Exception e) {
				logger.debug("OSSClient shutdown faild!");
			}
			configureRef.set(null);
		}
	}
}