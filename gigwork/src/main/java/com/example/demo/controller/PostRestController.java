package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ChatService;
import com.example.demo.service.PostService;


import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("post")
@RestController
public class PostRestController {
	
	private final PostService postService;
	
	@PostMapping("/JOcreate")
	public void writePost(@RequestBody HashMap<String, Object> data) {
		System.out.println("넘어오는 값"+data);
		
		postService.writePost(data);
		
		System.out.println(data);
		
}	


}
