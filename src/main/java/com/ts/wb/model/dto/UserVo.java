package com.ts.wb.model.dto;

import com.ts.wb.model.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo extends User {

	private String type;
	
}
