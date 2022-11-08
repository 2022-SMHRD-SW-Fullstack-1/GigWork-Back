package com.example.demo.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.demo.service.AlertService;
import com.google.gson.Gson;

public class ReplyEchoHandler extends TextWebSocketHandler {

	// 로그인 중인 개별 유저를 저장
	Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

	Gson gson = new Gson();

	@Autowired
	AlertService alertService;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished:" + session);
		String[] uri = session.getUri().toString().split("/");
		users.put(uri[uri.length - 1], session);
		System.out.println(users.toString());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> data = gson.fromJson(message.getPayload(), Map.class);
		System.out.println("handleTextMessage:" + data.toString());
		
		//alertService.addChatAlert(data);
		
		if(users.containsKey(data.get("sendto"))) {
			users.get(data.get("sendto")).sendMessage(new TextMessage(message.getPayload()));
		}
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed:" + session + ":" + status);
	}
}