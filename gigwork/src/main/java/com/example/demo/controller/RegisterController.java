package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.model.OtherView;
import com.example.demo.service.ProfileService;
import com.example.demo.service.RegisterService;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("register")
@RestController
public class RegisterController {
	private final RegisterService registerService;
	
	@PostMapping("/create")
	public void create(@RequestBody Map<String,Object> info) {
		registerService.createRegister(info);
	}
	
//	@PostMapping("/login")
//	public String login(@RequestBody Map<String,Object> info) {
//		return registerService.login(info);
//	}
	
	@PostMapping("/login")
	public String login(@RequestBody Map<String,Object> info) {
		
		Login view = registerService.login(info);;
		JsonObject obj = new JsonObject();
		obj.addProperty("mem_id", view.getMem_id());
		obj.addProperty("name", view.getName());

		return obj.toString();
	}
}
