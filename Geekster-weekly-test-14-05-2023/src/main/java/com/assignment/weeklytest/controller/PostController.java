package com.assignment.weeklytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.weeklytest.model.Post;
import com.assignment.weeklytest.repository.PostRepo;

@RestController
@RequestMapping("/instapost")
public class PostController {

	@Autowired
	private PostRepo postRepo;
	
	@PostMapping("/savePost")
	public void savePost(@RequestBody Post post) {
		postRepo.save(post);
	}
	
	@GetMapping("/getpost/{postId}")
	public Post getPostById(@PathVariable Integer postId) {
		return postRepo.findByPostId(postId);
	}
}
