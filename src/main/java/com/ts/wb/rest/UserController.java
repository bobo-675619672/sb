package com.ts.wb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ts.wb.model.ResponseMsg;
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
	
	@PostMapping()
	public void login(@RequestBody User user) {
		log.info("User : {}", user);
	}
	
	@GetMapping("/list")
	public List<User> list() {
		return userService.list();
	}
	
	@GetMapping()
	public ResponseMsg<String> login(@RequestParam String account, @RequestParam String password) {
		User user = userService.queryUser(account, password);
		if (null != user) {
			return success("欢迎" + user.getName() + "登录!");
		}
		return fail("用户不存在!");
	}
	
}
