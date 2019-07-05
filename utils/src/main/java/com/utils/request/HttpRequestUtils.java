package com.utils.request;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * 基于HttpServletRequest对象封装的工具类
 * 
 * Created by feng.wei on 20170711.
 *
 */
public class HttpRequestUtils {

	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志记录

	private static final String UID = "uid";
	private static final String RENTER_ID = "renterId";
	private static final String ORGANIZATION_ID = "organizationId";

	/**
	 * 获取站点绝对路径；
	 * 
	 * @param request
	 * @return 不包含根目录；格式如：http://127.0.0.1:8080
	 */
	public static String getRequestPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	}

	/**
	 * 获取当前登录的UID
	 * 
	 * @param request
	 * @return
	 */
	public static Integer getCurrentLoginUsersByUid(HttpServletRequest request) {

		String uid = request.getAttribute(UID) == null ? "" : request.getAttribute(UID) + "";

		if (StringUtils.isNotEmpty(uid)) {
			return Integer.valueOf(uid);
		}
		return null;
	}

	/**
	 * 设置当前登陆用户的uuid
	 * @param request
	 * @param uid
	 */
	public static void setCurrentLoginUsersUid(HttpServletRequest request, Integer uid) {
		request.setAttribute(UID, uid);
	}

	/**
	 * 设置当前登陆用户的租户uuid
	 * @param request
	 * @param renterId
	 */
	public static void setCurrentLoginUsersRenterId(HttpServletRequest request, Integer renterId) {
		request.setAttribute(RENTER_ID, renterId);
	}

	/**
	 * 获取当前登录的RENTER_ID
	 * 
	 * @param request
	 * @return
	 */
	public static Integer getCurrentLoginUsersRenterId(HttpServletRequest request) {
		Object renterId = request.getAttribute(RENTER_ID);
		if (renterId == null || StringUtils.isEmpty(renterId.toString())) {
			return null;
		}
		return Integer.parseInt(renterId.toString());
	}

	/**
	 * 获取当前登录的ORGANIZATION_ID
	 * 
	 * @param request
	 * @return
	 */
	public static Integer getCurrentLoginUsersOrganizationId(HttpServletRequest request) {
		Object organizationId = request.getAttribute(ORGANIZATION_ID);
		if (organizationId == null || StringUtils.isEmpty(organizationId.toString())) {
			return null;
		}
		return Integer.parseInt(organizationId.toString());
	}

	/**
	 * 设置当前登录的ORGANIZATION_ID
	 * 
	 * @param request
	 * @return
	 */
	public static void setCurrentLoginUsersOrganizationId(HttpServletRequest request, Integer organizationId) {
		request.setAttribute(ORGANIZATION_ID, organizationId);
	}

	/**
	 * Creates {@link CloseableHttpClient} instance with default configuration.
	 */
	public static CloseableHttpClient createDefault() {
		return HttpClientBuilder.create().build();
	}

	/**
	 * httpPost
	 * 
	 * @param url
	 *            路径
	 * @param jsonParam
	 *            参数
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam) {
		return httpPost(url, jsonParam, false);
	}

	/**
	 * post请求
	 * 
	 * @param url
	 *            url地址
	 * @param jsonParam
	 *            参数
	 * @param noNeedResponse
	 *            不需要返回结果
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse) {
		// post请求返回结果
		CloseableHttpClient httpClient = createDefault();
		JSONObject jsonResult = null;
		HttpPost method = new HttpPost(url);
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			HttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity());
					if (noNeedResponse) {
						return null;
					}
					/** 把json字符串转换成json对象 **/
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url, e);
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		}
		return jsonResult;
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            路径
	 * @return
	 */
	public static JSONObject httpGet(String url) {
		// get请求返回结果
		JSONObject jsonResult = null;
		try {
			CloseableHttpClient client = createDefault();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				String strResult = EntityUtils.toString(response.getEntity());
				/** 把json字符串转换成json对象 **/
				jsonResult = JSONObject.fromObject(strResult);
				url = URLDecoder.decode(url, "UTF-8");
			} else {
				logger.error("get请求提交失败:" + url);
			}
		} catch (IOException e) {
			logger.error("get请求提交失败:" + url, e);
		}
		return jsonResult;
	}
}
