package com.shiwulian.wechat.context;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.shiwulian.wechat.util.SysConfig;

public class ContextGlobalEvent implements ApplicationListener<ContextRefreshedEvent> {

	protected final static Logger log = LoggerFactory.getLogger(ContextGlobalEvent.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			try {
				Properties properties = PropertiesLoaderUtils.loadAllProperties("aliyun.properties");
				if (properties != null) {
					if (properties.containsKey("aliyun.endpoint")) {
						SysConfig.aliyun_endpoint = properties.getProperty("aliyun.endpoint");
					}
					if (properties.containsKey("aliyun.accessKeyId")) {
						SysConfig.aliyun_accessKeyId = properties.getProperty("aliyun.accessKeyId");
					}
					if (properties.containsKey("aliyun.accessKeySecret")) {
						SysConfig.aliyun_accessKeySecret = properties.getProperty("aliyun.accessKeySecret");
					}
					if (properties.containsKey("aliyun.bucketName")) {
						SysConfig.aliyun_bucketName = properties.getProperty("aliyun.bucketName");
					}
					if (properties.containsKey("aliyun.bucketHost")) {
						SysConfig.aliyun_bucketHost = properties.getProperty("aliyun.bucketHost");
					}
				}
			} catch (Exception e) {
				log.error("ContextGlobalEvent error {}", e);
			}
		}
	}
}
