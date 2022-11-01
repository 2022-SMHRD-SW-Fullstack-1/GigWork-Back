package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("profile")
@RestController
public class ProfileRestController {

	private final ProfileService profileService;
	
//	@PostMapping("/test")
//	public void test(@RequestBody Map<String,Object> cate) {
//		System.out.println(cate.get("cate"));
//	}
	@PostMapping("/create")
	public void create(@RequestBody Map<String,Object> pro){
		
		profileService.createProfile(pro);
		
	}
	
	@PostMapping("/upload")
	public void upload(@RequestBody Map<String,Object> a) {
		System.out.println(a);
	}
}









