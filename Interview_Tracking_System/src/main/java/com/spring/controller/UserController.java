package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_User_Credentials;
import com.spring.service.UserService;

@RestController
@RequestMapping("/user")

	public class UserController {
	
	@Autowired
	private UserService microService;
	
	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestBody ITS_TBL_User_Credentials user) {
		return microService.login(user); 
	}
	@PostMapping(value="/logout", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logoutUser(@RequestHeader(name="auth-token") String authToken) {
		return microService.logout(authToken); 
	}
	@PostMapping(value="/resetpassword", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logoutUser(@RequestBody ITS_TBL_User_Credentials user,@RequestHeader(name="new-password") String newpassword) {
		return microService.resetpassword(user,newpassword); 
	}
	

}
