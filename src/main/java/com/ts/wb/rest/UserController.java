package com.ts.wb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ts.wb.model.ResponseMsg;
import com.ts.wb.model.dto.UserVo;
import com.ts.wb.model.entity.User;
import com.ts.wb.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/list")
	public List<User> list() {
		return userService.list();
	}
	
	// 经典 风格
	@GetMapping()
	public ResponseMsg<String> login1(
			@RequestParam(name = "account", required = true) String account, 
			@RequestParam(name = "password", required = true) String password, 
			@RequestParam(name = "type", required = false, defaultValue = "1") String type) {
		User user = userService.login(account, password, type);
		return success("欢迎" + user.getName() + "登录!");
	}
	
	// restful 风格 
	@GetMapping("/{account}/{password}/{type}")
	public ResponseMsg<String> login2(
			@PathVariable(name = "account", required = true) String account, 
			@PathVariable(name = "password", required = true) String password,
			@PathVariable(name = "type", required = false) String type) {
		User user = userService.login(account, password, type);
		return success("欢迎" + user.getName() + "登录!");
	}
	
	// 表单 风格
	@PostMapping()
	public ResponseMsg<String> login(@RequestBody UserVo userVo) {
		log.info("User : {}", userVo);
		User user = userService.login(userVo.getAccount(), userVo.getPassword(), userVo.getType());
		return success("欢迎" + user.getName() + "登录!");
	}
	
}
