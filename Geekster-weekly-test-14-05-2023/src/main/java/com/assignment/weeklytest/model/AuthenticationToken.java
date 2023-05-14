package com.assignment.weeklytest.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthenticationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tokenId;
	private String token;
	private LocalDate tokenCreationDate;

	@OneToOne
	private User user;

	public AuthenticationToken(User user) {
		this.user = user;
		this.tokenCreationDate = LocalDate.now();
		this.token = UUID.randomUUID().toString();
	}

}
