package com.assignment.weeklytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.weeklytest.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findFirstByUserEmail(String email);

	User findByUserId(Integer userId);
}
