package com.jeekhan.wxjee.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 字段验证处理：基于注解
 * @author jeekhan
 *
 */
public class Validator {
	
	private Class<?>[] annots = new Class<?>[]{
		NotNull.class,Size.class,Min.class,Max.class
	};
	
	/**
	 * 根据注解信息完成对对象的验证
	 * @param obj
	 * @param clazz
	 * @return
	 */
	public <T> Map<String,String> valid(T obj,Class<T> clazz) throws Exception{
		if(obj == null) {
			throw new Exception("this param 'obj' is null ");
		}
		if(clazz == null) {
			throw new Exception("this param 'clazz' is null ");
		}
		if(!(clazz.isInstance(obj))) {
			throw new Exception("illegal object,this param 'obj' is not a instance of the param 'clazz' ");
		}
		Map<String,String> results = new HashMap<String,String>();
		Field[] fields = clazz.getDeclaredFields(); //获取所有声明字段
		for(Field field:fields) {
			Annotation[] annos = field.getDeclaredAnnotations(); //获取所有注解
			Class<?> ftype = field.getType(); //字段类型
			String getter = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			if(ftype.equals(Boolean.class)) {
				getter = "is" + getter;
			}else {
				getter = "get" + getter;
			}
			Method method = clazz.getDeclaredMethod(getter); //获取getter方法
			Object value = method.invoke(obj); //获取字段的值
			if(annos == null || annos.length < 1) {
				continue;
			}
			
			for(Annotation ant:annos) {
				String result = null;
				for(Class<?> antclz:this.annots) {
					if(antclz.isInstance(ant)) {
						if(antclz.equals(NotNull.class)) {
							result = this.valNotNull(value, field);
							break;
						}else if(antclz.equals(Size.class)) {
							result = this.valSize(value, field, (Size)ant);
							break;
						}else if(antclz.equals(Min.class)) {
							result = this.valMin(value, field, (Min)ant);
							break;
						}else if(antclz.equals(Max.class)) {
							result = this.valMax(value, field, (Max)ant);
							break;
						}else {
							break;
						}
					}
				}
				if(result != null) {
					results.put(field.getName(), result);
				}
			}
		}
		return results;
	}
	
	protected String valNotNull(Object value,Field field) throws Exception{
		if(value == null) {
			return field.getName() + " must not be null ";
		}
		return null;
	}
	
	/**
	 * 数组与字符串的长度处理
	 * @param value
	 * @param field
	 * @param size
	 * @return
	 */
	protected String valSize(Object value,Field field,Size size) {
		Class<?> ftype = field.getType(); //字段类型
		if(value == null) {
			return null;
		}
		int len;
		if(ftype.equals(String.class)) { //字符串处理
			String val = (String)value;
			len = val.length();
		}else if(ftype.isArray()) { //数组处理
			len = Array.getLength(value);
		}else {
			return null;
		}
		Integer min = size.min();
		Integer max = size.max();
		if(min != null && len < min) {
			return field.getName() + " min length is " + min;
		}
		if(max != null && len > max) {
			return field.getName() + " max length is " + min;
		}
		return null;
	}

	/**
	 * 整数、否点数的最小值验证
	 * @param value
	 * @param field
	 * @param min
	 * @return
	 */
	protected String valMin(Object value,Field field,Min min) {
		Class<?> ftype = field.getType(); //字段类型
		if(ftype.equals(Integer.class) || ftype.equals(Byte.class) ||
				ftype.equals(Short.class) || ftype.equals(Long.class)) { //整数处理
			Long val = (Long)value;
			if(val == null) {
				return null;
			}
			if(min != null && val < min.value()) {
				return field.getName() + " min value is " + min.value();
			}
		}else if(ftype.equals(Float.class) || ftype.equals(Double.class)) {
			Double val = (Double)value;
			if(val == null) {
				return null;
			}
			if(min != null && val < min.value()) {
				return field.getName() + " min value is " + min.value();
			}
		}
		return null;
	}
	
	/**
	 * 整数、否点数的最大值验证
	 * @param value
	 * @param field
	 * @param max
	 * @return
	 */
	protected String valMax(Object value,Field field,Max max) {
		Class<?> ftype = field.getType(); //字段类型
		if(ftype.equals(Integer.class) || ftype.equals(Byte.class) ||
				ftype.equals(Short.class) || ftype.equals(Long.class)) { //整数处理
			Long val = (Long)value;
			if(val == null) {
				return null;
			}
			if(max != null && val > max.value()) {
				return field.getName() + " max value is " + max.value();
			}
		}else if(ftype.equals(Float.class) || ftype.equals(Double.class)) {
			Double val = (Double)value;
			if(val == null) {
				return null;
			}
			if(max != null && val > max.value()) {
				return field.getName() + " max value is " + max.value();
			}
		}
		return null;
	}
	
	
}


