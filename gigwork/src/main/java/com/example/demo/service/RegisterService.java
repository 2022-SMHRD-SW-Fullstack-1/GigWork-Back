package com.example.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.ProfileMapper;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.model.Login;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisterService {
	
	private final RegisterMapper registerMapper;
	
	public void createRegister(@RequestBody Map<String,Object> info) {
		registerMapper.createRegister(info);
	}
	
	
	public Login login(@RequestBody Map<String,Object> info) {
		return registerMapper.login(info);
	}

}
