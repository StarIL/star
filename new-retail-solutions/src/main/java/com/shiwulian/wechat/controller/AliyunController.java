package com.shiwulian.wechat.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiwulian.wechat.bean.Response;
import com.shiwulian.wechat.util.AliYunOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "附件上传相关")
@Controller
@RequestMapping(value = "/aliyun")
public class AliyunController {
	private static final Logger logger = LoggerFactory.getLogger(AliyunController.class);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ApiOperation(value = "附件上传", httpMethod = "POST", produces = "application/json")
	public @ResponseBody Response<Object> upload(HttpServletRequest request) {
		Response<Object> response = new Response<Object>(false);
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> items = upload.parseRequest(request);
			Triplet<Boolean, Object, String> triplet = AliYunOssUtil.uploadObjectOSS(items);
			if (triplet.getValue0()) {
				response.setData(triplet.getValue1());
			} else {
				response.setMsg(triplet.getValue2());
			}
			response.setSuccess(triplet.getValue0());
		} catch (FileUploadException e) {
			logger.error("upload is error {}", e);
			response.setMsg("上传失败");
		}
		return response;
	}
}
