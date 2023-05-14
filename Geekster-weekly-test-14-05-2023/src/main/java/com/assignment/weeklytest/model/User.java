package com.assignment.weeklytest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private Integer userAge;
	private String userEmail;
	private String userPassword;
	private String userPhoneNumber;

	public User(String userFirstName, String userLastName, Integer userAge, String userEmail, String userPassword,
			String userPhoneNumber) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
	}

}
