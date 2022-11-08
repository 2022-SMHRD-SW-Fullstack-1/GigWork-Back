package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.AlertMapper;
import com.example.demo.model.Alert;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AlertService {
	
	private final AlertMapper alertMapper;
	
	public void addChatAlert(Map<String, Object> data) {
		Alert alert = new Alert(0, 
				(String)data.get("sendto"), 
				(String)data.get("msg"), 
				(Date)data.get("msg_time"), 
				(String)data.get("talker"), 
				"t");
		alertMapper.addChatAlert(alert);
	}
	
	public List<Alert> getAlertList(String nick) {
		return alertMapper.getAlertList(nick);
	}

}
