package com.example.demo.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

	public List<ChattingRoom> enterChatPage(String id) {
		return chatMapper.getChattingRoom(id);
	}
	
	public List<ChattingContent> getChatContent(String roomNum) {
		return chatMapper.getChatContent(roomNum);
	}
	
	public void putChatContent(Map<String, String> data) {
		ChattingContent chatContent = new ChattingContent(0, data.get("talker"), data.get("msg"), data.get("msg_time"), Integer.parseInt(data.get("cr_seq")));
		chatMapper.putChatContent(chatContent);
	}
	

	
}
