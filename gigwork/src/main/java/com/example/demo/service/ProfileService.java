package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.ProfileMapper;
import com.example.demo.model.Member;
import com.example.demo.model.MyView;
import com.example.demo.model.OtherView;
import com.example.demo.model.ProfileList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfileService {
	
	private final ProfileMapper profileMapper;
	
	public void createProfile(Map<String,Object> pro) {
		profileMapper.createProfile(pro);
	};
	
	public String select() {
		String a = profileMapper.select();
		return a;
	}
	
	public List<ProfileList> prolist() {
		return profileMapper.prolist();
	}
	
	public OtherView otherview(@RequestBody Map<String,Object> name) {
		return profileMapper.otherview(name);
	}
	
	public MyView myview(@RequestBody Map<String,Object> id) {
		return profileMapper.myview(id);
	}
	
	public int hasPro(@RequestBody Map<String,Object> id) {
		return profileMapper.hasPro(id);
	}
	
}
