package com.example.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.PostMapper;
import com.example.demo.mapper.ProfileMapper;
import com.example.demo.model.Post;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
	
	private final PostMapper postMapper;
	
	public void createPost(Map<String,Object> data) {
		postMapper.createPost(data);
	}
	
	public List<Post> searchPost(){
		return postMapper.searchPost();
	}
	
	public List<Post> bookmark(){
		return postMapper.bookmark();
	}
	
	public List<Post> getMainPost(){
		return postMapper.getMainPost();
	}
	

}
