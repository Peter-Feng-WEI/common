package com.utils.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON 数据工具的处理类。
 * 
 * Created by feng.wei on 20171111.
 *
 */
public class JSONUtils {

	private static ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		// 反序列化时,遇到未知属性时是否引起结果失败
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 
	 * 构建map对象
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> buildPostMap(HttpServletRequest request) throws Exception {
		Map<String, String[]> map = request.getParameterMap();
		Map<String, Object> params = new HashMap<String, Object>();
		for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();) {
			String name = iter.next();
			String[] values = (String[]) map.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		return params;
	}

	/**
	 * 将Object对象转换成String类型的json字符串
	 * 
	 * @param bean
	 *            Object对象
	 * @return
	 */
	public static String object2Json(Object bean) throws Exception {
		try {
			return objectMapper.writeValueAsString(bean);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将json的String转换成指定的Class<T>
	 * 
	 * @param json
	 *            Object对象
	 * @param clazz
	 *            Class<T>
	 * @return
	 */
	public static <T> T Json2Object(String json, Class<T> clazz) throws Exception {
		try {
			if (StringUtils.isBlank(json)) {
				return null;
			}

			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将一个json字串转为list<T>
	 * 
	 * @param json
	 *            Object对象
	 * @param clazz
	 *            Class<T>
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> Json2ObjectList(String json, Class<T> clazz) throws Exception {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		JavaType javaType = getCollectionType(ArrayList.class, clazz);
		List<T> lst;
		try {
			lst = (List<T>) objectMapper.readValue(json, javaType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lst;
	}

	/**
	 * 将json的String转换成指定的TypeReference<T>
	 * 
	 * @param json
	 *            Object对象
	 * @param tr
	 *            TypeReference<T>
	 * @return
	 */
	public static <T> T Json2Object(String json, TypeReference<T> tr) throws Exception {
		try {

			if (StringUtils.isBlank(json)) {
				return null;
			}

			return objectMapper.readValue(json, tr);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
}
