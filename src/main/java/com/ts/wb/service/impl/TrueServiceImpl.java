package com.ts.wb.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ts.wb.service.ShowService;

/**
 * 真接口，用于生产环境
 * @author Administrator
 *
 */
@Profile("prod")
@Service
public class TrueServiceImpl implements ShowService {

	@Override
	public String show() {
		return "True!";
	}
	
}
