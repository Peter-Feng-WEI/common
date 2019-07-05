package com.mybatis.plus.valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * SPRING-MVC @Valid 验证;
 * 
 * Created by feng.wei on 20170810.
 *
 */
public class Validetion {

	/**
	 * 
	 * @param bindingResult
	 */
	public static String ValidetionException(BindingResult bindingResult) {
		StringBuffer paramMsg = new StringBuffer();
		for (ObjectError objectError : bindingResult.getAllErrors()) {
			paramMsg.append(((FieldError) objectError).getField() + " : ").append(objectError.getDefaultMessage()).append(";");
		}
		return paramMsg.toString();
	}
}
