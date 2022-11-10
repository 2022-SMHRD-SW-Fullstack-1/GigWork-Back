package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ChattingContent;
import com.example.demo.model.ChattingRoom;
import com.example.demo.model.Post;
import com.example.demo.service.AlertService;
import com.example.demo.service.ChatService;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("chat")
@RestController
public class ChatRestController {

	private final ChatService chatService;
	private final AlertService alertService;
	
	Gson gson = new Gson();
	
	@PostMapping("/roomInfo")
	public String sendRoomInfo(@RequestBody Map<String, String> data) {
		List<ChattingRoom> chatRoomList = chatService.enterChatPage(data.get("nick"));
		return gson.toJson(chatRoomList);
	}
	
	@PostMapping("/content")
	public String getChatContent(@RequestBody Map<String, String> data) {
		List<ChattingContent> chatCntList = chatService.getChatContent(data.get("roomnum"));
		return gson.toJson(chatCntList);
	}
	
	@PostMapping("/inputContent")
	public void putChatContent(@RequestBody Map<String, String> data) {
		chatService.putChatContent(data);
	}
	
	@PostMapping("/createCR")
	public void createChatRoom(@RequestBody Map<String, String> data) {
		chatService.createChatRoom(data);
	}
	
	@PostMapping("getPostInfo")
	public Post getPostInfo(@RequestBody Map<String, String> data) {
		return chatService.getPostInfo(data);
	}
	
	@PostMapping("updateCR")
	public Post updateCR(@RequestBody Map<String, String> data) {
		chatService.updateCR(data.get("roomnum"));
		chatService.updatePost(data.get("post_num"));
		return chatService.getPostInfo(data);
	}
	
	@PostMapping("updateCR2")
	public Post updateCR2(@RequestBody Map<String, String> data) {
		chatService.addMatching(data);
		chatService.updatePost2(data.get("post_num"));
		return chatService.getPostInfo(data);
	}
	
	@PostMapping("makeOffer")
	public void makeOffer(@RequestBody Map<String, String> data) {
		chatService.makeOffer(data);
	}
}