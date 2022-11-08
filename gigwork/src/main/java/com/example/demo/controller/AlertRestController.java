package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alert;
import com.example.demo.service.AlertService;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("alert")
@RestController
public class AlertRestController {
	
	private final AlertService alertService;

	Gson gson = new Gson();

	@PostMapping("/getList")
	public String getAlertList(@RequestBody Map<String, String> data) {
		List<Alert> alertList = alertService.getAlertList(data.get("mem_nick"));
		return gson.toJson(alertList);
	}
}
