package com.shiwulian.wechat.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

	private static CloseableHttpClient httpclient;
	private static RequestConfig requestConfig;
	static {
		httpclient = HttpClients.createDefault();
		requestConfig = RequestConfig.custom().build();
	}

	public static String doGet(String url) throws IOException {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return null;
	}

	public static <T> T doGet(String url, Class<T> clazz) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				String json = EntityUtils.toString(response.getEntity(), "UTF-8");
				return JsonUtil.parseObject(json, clazz);
			}
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return null;
	}

	public String doGet(String url, Map<String, String> param) throws ClientProtocolException, IOException, URISyntaxException {
		URIBuilder builder = new URIBuilder(url);
		for (Map.Entry<String, String> entry : param.entrySet()) {
			builder.addParameter(entry.getKey(), entry.getValue());
		}
		return doGet(builder.build().toString());
	}

	public <T> T doPost(String url, Map<String, String> param, Class<T> clazz) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		if (null != param) {
			List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
			for (Map.Entry<String, String> entry : param.entrySet()) {
				parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
			httpPost.setEntity(formEntity);
		}
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				String json = EntityUtils.toString(response.getEntity(), "UTF-8");
				return JsonUtil.parseObject(json, clazz);
			}
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return null;
	}

	public <T> T doPost(String url, String json, Class<T> clazz) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		StringEntity stringEntity = new StringEntity(json, "UTF-8");
		stringEntity.setContentType("application/json");
		httpPost.setEntity(stringEntity);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				String jsonObj = EntityUtils.toString(response.getEntity(), "UTF-8");
				return JsonUtil.parseObject(jsonObj, clazz);
			}
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return null;
	}
}
