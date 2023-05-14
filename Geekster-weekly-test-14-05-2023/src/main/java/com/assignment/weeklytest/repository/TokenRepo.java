package com.assignment.weeklytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.weeklytest.model.AuthenticationToken;
import com.assignment.weeklytest.model.User;

public interface TokenRepo extends JpaRepository<AuthenticationToken, Long>{

	AuthenticationToken findByUser(User user);

}
