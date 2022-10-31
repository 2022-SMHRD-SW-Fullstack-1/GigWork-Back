package com.example.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.ProfileMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfileService {
	
	private final ProfileMapper profileMapper;
	
	public void createProfile(Map<String,Object> pro) {
		profileMapper.createProfile(pro);
	};
}
