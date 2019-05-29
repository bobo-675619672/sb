package com.ts.wb.exception;

import com.ts.wb.enums.ResultEnum;

public class CoolException extends RuntimeException {

	private Integer code;
	
	public CoolException(ResultEnum result, String... params) {
		super(String.format(result.getMessage(), params));
		this.code = result.getCode();
	}
	
	public CoolException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
