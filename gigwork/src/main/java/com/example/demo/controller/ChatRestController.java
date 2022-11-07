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
import com.example.demo.service.ChatService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("chat")
@RestController
public class ChatRestController {

	private final ChatService chatService;
	
	Gson gson = new Gson();
	
	@PostMapping("/roomInfo")
	public String sendRoomInfo(@RequestBody Map<String, String> data) {
		List<ChattingRoom> chatRoomList = chatService.enterChatPage(data.get("nick"));
		return gson.toJson(chatRoomList);
	}
	
	@PostMapping("/content")
	public String getChatContent(@RequestBody Map<String, String> data) {
		List<ChattingContent> chatCntList = chatService.getChatContent(data.get("roomNum"));
		return gson.toJson(chatCntList);
	}
	
	@PostMapping("/inputContent")
	public void putChatContent(@RequestBody Map<String, String> data) {
		chatService.putChatContent(data);
	}
	
}
