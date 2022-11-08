package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.model.NamePost;
import com.example.demo.model.OtherView;
import com.example.demo.model.Post;
import com.example.demo.model.WishList;
import com.example.demo.service.MyService;
import com.example.demo.service.PostService;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("my")
@RestController
public class MyPostBookmarkController {
	
	
	
	private final MyService myService;
	
//@PostMapping("/mypost")
//public List<WishList> searchmyPost(@PathVariable("mem_id") String mem_id) {
//	return myService.searchmyPost(mem_id);
//}
//	
	
// /mypost/post_num#{post_num}	
//@PostMapping("/mypost")
//public List<Post> searchmyPost(@RequestBody Map<String,Object> num) {
//	return myService.searchmyPost(num);
//}

//@PostMapping("/mybookmark")
//public void myBookmark(@RequestBody Map<String,Object> data) {
//
//	return myService.myBookmark(data);
//}

@PostMapping("/mypost")
public String mynick(@RequestBody Map<String,Object> mem_id) {
	
	NamePost view = myService.mynick(mem_id);
	JsonObject obj = new JsonObject();
	obj.addProperty("name", view.getName());
	obj.addProperty("post_num", view.getPost_num());
	obj.addProperty("mem_id", view.getMem_id());
	obj.addProperty("post_cate", view.getPost_cate());
	obj.addProperty("post_pay", view.getPost_pay());
	obj.addProperty("post_offer_yn", view.getPost_offer_yn());
	obj.addProperty("worktime_s", view.getWorktime_s());
	obj.addProperty("worktime_e", view.getWorktime_e());
	obj.addProperty("lat", view.getLat());
	obj.addProperty("lng", view.getLng());
	obj.addProperty("urgent", view.getUrgent());
	obj.addProperty("title", view.getTitle());
	obj.addProperty("content", view.getContent());
	obj.addProperty("img_src", view.getImg_src());
	obj.addProperty("reg_date", view.getReg_date());
	

	
	return obj.toString();
	
	
	
}
	
}
