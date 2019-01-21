package com.ts.wb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.wb.annotation.Food;
import com.ts.wb.service.ShowService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Food
	private String name;
	
	@Profile("dev")
	private String devBean() {
		return "dev";
	}
	
	@Profile("prod")
	private String prodBean() {
		return "prod";
	}
	
	@Autowired
	private ShowService showService;
	
	@GetMapping("/show")
	public String show() {
		return showService.show();
	}
	
}
