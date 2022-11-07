package com.example.demo.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.demo.service.ChatService;
import com.google.gson.Gson;

public class ReplyEchoHandler extends TextWebSocketHandler {

	// 로그인 중인 개별 유저를 저장
	Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
//	List<WebSocketSession> sessions = new ArrayList<>();

	Gson gson = new Gson();

	@Autowired
	ChatService chatService;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished:" + session);
		String[] uri = session.getUri().toString().split("/");
		users.put(uri[uri.length - 1], session);
	}

	// 접속한 유저의 http세션을 조회하여 id를 얻는 함수
	private String getMemberId(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		String mem_nick = (String) httpSession.get("mem_nick"); // 세션에 저장된 mem_id 기준 조회
		return mem_nick;
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> data = gson.fromJson(message.getPayload(), Map.class);
		System.out.println("handleTextMessage:" + data.toString());
		
		
//		for (WebSocketSession sess: sessions) {
//			sess.sendMessage(new TextMessage(senderId + ": " + message.getPayload()));
//		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed:" + session + ":" + status);
	}
}