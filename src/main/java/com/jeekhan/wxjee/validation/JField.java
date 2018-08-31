package com.jeekhan.wxjee.validation;

public @interface JField {
	/**
	 * 字段的名称
	 * @return
	 */
	public String value();
	

	/**
	 * 校验结果消息
	 * @return
	 */
	public String message() default "";

}
