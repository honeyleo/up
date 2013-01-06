package com.hl.up.web;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.up.pojo.User;
import com.hl.up.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "save",method = RequestMethod.GET) @ResponseBody
	public Object save(User user) {
		userService.save(user);
		return user;
	}
	
	@RequestMapping(value = "get", method = RequestMethod.GET) @ResponseBody
	public Object save(int id) {
		User user = userService.get(id);
		return user;
	}
}
