package com.assignment.weeklytest.dto;

import com.assignment.weeklytest.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {

	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private String password;
	private String phoneNumber;
	
}
