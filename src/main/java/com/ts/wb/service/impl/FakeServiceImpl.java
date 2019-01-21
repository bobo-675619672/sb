package com.ts.wb.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ts.wb.service.ShowService;

/**
 * 假接口，用于开发测试用
 * @author Administrator
 *
 */
@Profile("dev")
@Service
public class FakeServiceImpl implements ShowService {

	@Override
	public String show() {
		return "Fake!";
	}

}
