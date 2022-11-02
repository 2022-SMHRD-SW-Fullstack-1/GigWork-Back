package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.model.OtherView;
import com.example.demo.model.ProfileList;
import com.example.demo.service.ProfileService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
	
	
	Gson gson1 = new Gson();
	JsonObject jsonObject = new JsonObject();
	
	@PostMapping("/prolist")
	public String prolist() {
		JsonArray ja = new JsonArray();
		JsonObject jo = new JsonObject();
		
		List<ProfileList> list = profileService.prolist();
		
	
		for(int i=0;i<2;i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("mem_id",list.get(i).getMem_id());
			obj.addProperty("name",list.get(i).getName());
			obj.addProperty("gender",list.get(i).getGender());
			obj.addProperty("age",list.get(i).getAge());
			obj.addProperty("say",list.get(i).getSay());
			obj.addProperty("img_src",list.get(i).getImg_src());
			obj.addProperty("sido",list.get(i).getSido());
			obj.addProperty("gungu",list.get(i).getGungu());
			obj.addProperty("cate_one",list.get(i).getCate_one());
			obj.addProperty("cate_two",list.get(i).getCate_two());
			obj.addProperty("cate_three",list.get(i).getCate_three());
			ja.add(obj);
		}
		jo.add("JsonArray", ja);
		
		return jo.toString();
	}
	
	
	
	@PostMapping("/select")
	public String select() {
		String a = profileService.select();
		return a;
	}
	
	@PostMapping("otherview")
	public String select(@RequestBody Map<String,Object> name) {
		
		OtherView view = profileService.otherview(name);
		JsonObject obj = new JsonObject();
		obj.addProperty("name", view.getName());
		obj.addProperty("mem_trust", view.getMem_trust());
		obj.addProperty("cate_one", view.getCate_one());
		obj.addProperty("cate_two", view.getCate_two());
		obj.addProperty("cate_three", view.getCate_three());
		obj.addProperty("say", view.getSay());
		obj.addProperty("open_date", view.getOpen_date());
		obj.addProperty("close_date", view.getClose_date());

		
		return obj.toString();

	}
	
	
}









