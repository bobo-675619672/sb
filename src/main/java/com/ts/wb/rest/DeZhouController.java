package com.ts.wb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dz")
public class DeZhouController {

	private static String[] pokerType = {"♠","♥","♣","◆"};
	
	private static String[] pokerNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	@GetMapping("/{msg}")
	public String showSomething(@PathVariable String msg) {
		return "{\"msg\":\"" + msg + "\"}";
	}
	
}
