package com.assignment.weeklytest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.weeklytest.model.AuthenticationToken;
import com.assignment.weeklytest.model.User;
import com.assignment.weeklytest.repository.TokenRepo;
import java.time.LocalDate;
import java.util.UUID;
@Service
public class TokenService {

	@Autowired
	private TokenRepo tokenRepo;

	public void saveToken(AuthenticationToken token,User user) {
		// TODO Auto-generated method stub
		token.setToken(UUID.randomUUID().toString());
		token.setTokenCreationDate(LocalDate.now());
		token.setUser(user);
		tokenRepo.save(token);
	}

	public AuthenticationToken getToken(User user) {
		// TODO Auto-generated method stub
		return tokenRepo.findByUser(user);
	}
}
