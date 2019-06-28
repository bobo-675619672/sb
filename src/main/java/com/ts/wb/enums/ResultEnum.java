package com.ts.wb.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

	BUSS_ERROR(1001, "业务错误:%s"),
	OTHER_ERROR(9999, "其他错误"),
	;
	
	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	private Integer code;

	private String message;
	
}
