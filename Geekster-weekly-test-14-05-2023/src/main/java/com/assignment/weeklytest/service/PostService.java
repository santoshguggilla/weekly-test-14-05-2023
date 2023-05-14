package com.assignment.weeklytest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.weeklytest.repository.PostRepo;

@Service
public class PostService {

	@Autowired
	private PostRepo postRepo;
}
