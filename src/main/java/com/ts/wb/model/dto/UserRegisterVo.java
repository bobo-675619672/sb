package com.ts.wb.model.dto;

import java.util.Date;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterVo {
	
	private String name;
	
	private String password;
	
	private String account;
	
	private String sex;
	
	@Min(value = 18, message = "禁止未成年人注册")
	private Integer age;
	
	private Date createDate;
	
}
