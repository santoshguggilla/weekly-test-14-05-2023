package com.assignment.weeklytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.weeklytest.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

	Post findByPostId(Integer postId);

}
