package com.jeekhan.wxjee.poicard.dto.resp;

import com.jeekhan.wxjee.common.CommonResp;

public class UploadImgResp extends CommonResp{
	private String url;
	
	public UploadImgResp() {
		
	}

	/**
	 * 图片上传成功后微信返回的http url
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
