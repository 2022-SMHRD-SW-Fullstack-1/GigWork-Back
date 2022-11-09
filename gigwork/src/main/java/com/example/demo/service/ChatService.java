package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.ChatMapper;
import com.example.demo.model.ChattingContent;
import com.example.demo.model.ChattingRoom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatService {
	
	private final ChatMapper chatMapper;

	public List<ChattingRoom> enterChatPage(String nick) {
		return chatMapper.getChattingRoom(nick);
	}
	
	public List<ChattingContent> getChatContent(String roomNum) {
		return chatMapper.getChatContent(roomNum);
	}
	
	public void putChatContent(Map<String, String> data) {
		ChattingContent chatContent = new ChattingContent(0, data.get("talker"), data.get("msg"), data.get("msg_time"), Integer.parseInt(data.get("cr_seq")));
		chatMapper.putChatContent(chatContent);
	}
	
	public void createChatRoom(@RequestBody Map<String, String> data) {
		ChattingRoom chatroom = new ChattingRoom();
		chatroom.setMem_nick(data.get("mem_nick"));
		chatroom.setPartner_nick(data.get("partner_nick"));
		chatroom.setPost_num(Integer.parseInt(data.get("post_num")));
		chatMapper.createChatRoom(chatroom);
	}
	

	
}