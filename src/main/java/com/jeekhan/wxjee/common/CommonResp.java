package com.jeekhan.wxjee.common;

import com.alibaba.fastjson.JSONObject;

public class CommonResp {
	private int errcode;
	private String errmsg;
	private boolean isSuccess;
	/**
	 * 错误代码：0-表示成功,-1:系统异常
	 * @return
	 */
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	/**
	 * 错误信息
	 * @return
	 */
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	/**
	 * 是否成功
	 * @return
	 */
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	/**
	 * 使用json格式的参数生成解析对象，不包含对success逻辑的判断
	 * @param clazz	目标对象类
	 * @param strRet
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static <T extends CommonResp> T parse(Class<T> clazz, String strRet) throws InstantiationException, IllegalAccessException {
		T resp = clazz.newInstance();
		JSONObject jsonRet = JSONObject.parseObject(strRet);
		if(strRet == null || jsonRet == null) {
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，微信接口调用失败，无应答！");
			return resp;
		}else {
			resp = JSONObject.toJavaObject(jsonRet, clazz);
		}
		if(resp == null) {
			resp = clazz.newInstance();
			resp.setErrcode(-1);
			resp.setErrmsg("系统异常，微信接口调用失败，无应答！");
			return resp;
		}
		return resp;
	}

}
