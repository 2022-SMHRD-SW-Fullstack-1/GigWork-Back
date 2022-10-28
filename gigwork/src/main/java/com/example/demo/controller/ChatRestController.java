package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("chat")
@RestController
public class ChatRestController {

	private final ChatService chatService;
	
	@PostMapping("/test")
	public void test(@RequestBody String chatMessage) {
		System.out.println(chatMessage);
	}
}
