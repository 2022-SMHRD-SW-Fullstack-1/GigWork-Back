package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Post;

@Mapper
public interface PostMapper {
	


	public void createPost(Map<String,Object> data);
	
	public List<Post> searchPost();
	
	public List<Post> bookmark();
	
}
