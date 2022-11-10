package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.ProfileMapper;
import com.example.demo.model.Manner;
import com.example.demo.model.Matching;
import com.example.demo.model.Member;
import com.example.demo.model.MyView;
import com.example.demo.model.OtherView;
import com.example.demo.model.Post;
import com.example.demo.model.Privacy;
import com.example.demo.model.ProfileList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfileService {
	
	private final ProfileMapper profileMapper;
	
	public void createProfile(Map<String,Object> pro) {
		profileMapper.createProfile(pro);
	};
	
	public void correctionProfile(Map<String,Object> pro) {
		profileMapper.correctionProfile(pro);
	}
	
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
	
	public List<Matching> activeList(@RequestBody Map<String,Object> id){
		return profileMapper.activeList(id);
	}
	
	public List<Manner> evaluation(@RequestBody Map<String,Object> id){
		return profileMapper.evaluation(id);
	}
	
	public String nameToId(@RequestBody Map<String,Object> name) {
		return profileMapper.nameToId(name);
	}
	
	public void evl(@RequestBody Map<String,Object> info) {
		profileMapper.evl(info);
	}
	public void evl5(@RequestBody Map<String,Object> name) {
		profileMapper.evl5(name);
	}
	
	public void evl4(@RequestBody Map<String,Object> name) {
		profileMapper.evl4(name);
	}
	
	public void evl2(@RequestBody Map<String,Object> name) {
		profileMapper.evl2(name);
	}
	
	public void evl1(@RequestBody Map<String,Object> name) {
		profileMapper.evl1(name);
	}
	
	public Privacy privacy(@RequestBody Map<String,Object> id) {
		return profileMapper.privacy(id);
	}
	
	public List<Post> bringPost(@RequestBody Map<String,Object> id){
		return profileMapper.bringPost(id);
	}
	
}
