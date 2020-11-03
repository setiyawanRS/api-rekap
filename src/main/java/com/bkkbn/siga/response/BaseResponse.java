package com.bkkbn.siga.response;

public class BaseResponse {
	protected String message;
	protected Object data;
		
	public BaseResponse() {
		super();
	}

	public BaseResponse(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
