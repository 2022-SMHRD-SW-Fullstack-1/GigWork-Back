package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProfileService;
import com.example.demo.service.RegisterService;

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
	
}
