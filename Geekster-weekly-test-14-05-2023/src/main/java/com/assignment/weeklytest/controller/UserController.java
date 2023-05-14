package com.assignment.weeklytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.weeklytest.dto.Sign;
import com.assignment.weeklytest.dto.SignIn;
import com.assignment.weeklytest.dto.SignUp;
import com.assignment.weeklytest.model.User;
import com.assignment.weeklytest.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public Sign signUp(@RequestBody SignUp signUp) {
		return userService.save(signUp);
	}
	
	@PostMapping("/signin")
	public Sign signIn(@RequestBody SignIn signIn) {
		return userService.userSignIn(signIn);
	}
	
	@PutMapping("/update/{userId}")
	public String updateUserById(@PathVariable Integer userId,@RequestBody User user) {
		if(userService.updateUserById(userId,user)) {
			return "Updated successfully";
		}
		return "Invaild UserId"+userId;
	}
}
