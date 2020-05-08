package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.ITS_TBL_User_Credentials;
import com.spring.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService microService;

	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestParam(required=true) String userId,@RequestParam(required=true) String password,@RequestParam(required=true) String userType) {
		return microService.login(userId,password,userType); 
	}

	@PostMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logoutUser(@RequestHeader(name = "auth-token") String authToken) {
		return microService.logout(authToken);
	}

	@PostMapping(value = "/resetpassword", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String resetpassword(@RequestBody ITS_TBL_User_Credentials user,
			@RequestParam("newpassword") String newpassword) {
		return microService.resetpassword(user, newpassword);
	}

	@GetMapping(value = "/sessionId", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object shareDetails(@RequestParam(required = true) String userId) {
		return microService.getSessionId(userId);
	}
}
