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

import com.example.demo.model.Manner;
import com.example.demo.model.Matching;
import com.example.demo.model.Member;
import com.example.demo.model.MyView;
import com.example.demo.model.OtherView;
import com.example.demo.model.Post;
import com.example.demo.model.Privacy;
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
	
	@PostMapping("/proCreate")
	public void create(@RequestBody Map<String,Object> pro){
		
		profileService.createProfile(pro);

		
	}
	
	@PostMapping("/proCorrection")
	public void correction(@RequestBody Map<String,Object> pro){
		
		profileService.correctionProfile(pro);
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
		
		for(int i=0;i<list.size();i++) {
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
	public String otherview(@RequestBody Map<String,Object> name) {
		
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
	
	@PostMapping("myview")
	public String myview(@RequestBody Map<String,Object> id) {
		
		MyView view = profileService.myview(id);
		JsonObject obj = new JsonObject();
		obj.addProperty("name", view.getName());
		obj.addProperty("mem_trust", view.getMem_trust());
		obj.addProperty("cate_one", view.getCate_one());
		obj.addProperty("cate_two", view.getCate_two());
		obj.addProperty("cate_three", view.getCate_three());
		obj.addProperty("say", view.getSay());
		obj.addProperty("open_date", view.getOpen_date());
		obj.addProperty("close_date", view.getClose_date());
		obj.addProperty("img_src", view.getImg_src());

		return obj.toString();
		
	}
	
	
	@PostMapping("hasPro")
	public int hasPro(@RequestBody Map<String,Object> id) {
		return profileService.hasPro(id);
	}
	
	
	@PostMapping("activeList")
	public String activeList(@RequestBody Map<String,Object> id) {
		
		JsonArray ja = new JsonArray();
		JsonObject jo = new JsonObject();
		
		List<Matching> list = profileService.activeList(id);
		if(list.size()!=0) {
		for(int i=0;i<list.size();i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("title",list.get(i).getTitle());
			obj.addProperty("post_cate", list.get(i).getPost_cate());
			obj.addProperty("match_date",list.get(i).getMatch_date());
			ja.add(obj);
		}
		}
		jo.add("JsonArray", ja);
		
		return jo.toString();
	}
	
	@PostMapping("evaluation")
	public String evaluation(@RequestBody Map<String,Object> id) {
		JsonArray ja = new JsonArray();
		JsonObject jo = new JsonObject();
		
		List<Manner> list = profileService.evaluation(id);
		if(list.size()!=0) {
		for(int i=0;i<list.size();i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("evl_content",list.get(i).getEvl_content());
			obj.addProperty("evl_point", list.get(i).getEvl_point());
			obj.addProperty("evl_date",list.get(i).getEvl_date());
			ja.add(obj);
		}
		}
		jo.add("JsonArray", ja);
		
		return jo.toString();
	}
	
	@PostMapping("nameToId")
	public String nameToId(@RequestBody Map<String,Object> name) {
		return profileService.nameToId(name);
	}
	
	@PostMapping("evl")
	public void evl(@RequestBody Map<String,Object> info) {
		profileService.evl(info);
		
	}
	
	@PostMapping("evl5")
	public void evl5(@RequestBody Map<String,Object> name) {
		profileService.evl5(name);
	}
	
	@PostMapping("evl4")
	public void evl4(@RequestBody Map<String,Object> name) {
		profileService.evl4(name);
	}
	
	@PostMapping("evl2")
	public void evl2(@RequestBody Map<String,Object> name) {
		profileService.evl2(name);
	}
	
	@PostMapping("evl1")
	public void evl1(@RequestBody Map<String,Object> name) {
		profileService.evl1(name);
	}
	
	@PostMapping("privacy")
	public String privacy(@RequestBody Map<String,Object> id) {
		Privacy view = profileService.privacy(id);

	
		JsonObject obj = new JsonObject();
		obj.addProperty("img_src", view.getImg_src());
		obj.addProperty("name", view.getName());
		obj.addProperty("mem_id", view.getMem_id());
		obj.addProperty("mem_phone", view.getMem_phone());

		return obj.toString();
	}
	
	@PostMapping("bringPost")
	public String bringPost(@RequestBody Map<String,Object> id) {
		
		
		JsonArray ja = new JsonArray();
		JsonObject jo = new JsonObject();

		List<Post> postlist = profileService.bringPost(id);

		for (int i = 0; i < postlist.size(); i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("post_num", postlist.get(i).getPost_num());
			obj.addProperty("mem_id", postlist.get(i).getMem_id());
			obj.addProperty("post_cate", postlist.get(i).getPost_cate());
			obj.addProperty("post_pay", postlist.get(i).getPost_pay());
			obj.addProperty("post_offer_yn", postlist.get(i).getPost_offer_yn());
			obj.addProperty("worktime_s", postlist.get(i).getWorktime_s());
			obj.addProperty("worktime_e", postlist.get(i).getWorktime_e());
			obj.addProperty("lat", postlist.get(i).getLat());
			obj.addProperty("lng", postlist.get(i).getLng());
			obj.addProperty("urgent", postlist.get(i).getUrgent());
			obj.addProperty("title", postlist.get(i).getTitle());
			obj.addProperty("content", postlist.get(i).getContent());
			obj.addProperty("img_src", postlist.get(i).getImg_src());
			obj.addProperty("reg_date", postlist.get(i).getReg_date());
			obj.addProperty("status", postlist.get(i).getStatus());
			ja.add(obj);
		}
		jo.add("JasonArray", ja);

		return jo.toString();
	}
	
}

