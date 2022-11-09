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
	
	public void addChatAlert(Map<String, String> data) {
		Alert alert = new Alert(0, data.get("mem_nick"), data.get("alert_cnt"), data.get("alert_time"), data.get("sendfrom"), data.get("ckecking"));
		alertMapper.addChatAlert(alert);
	}
	
	public List<Alert> getAlertList(String nick) {
		return alertMapper.getAlertList(nick);
	}
	
	public void deleteAlert(String alert_seq) {
		alertMapper.deleteAlert(alert_seq);
	}

}
