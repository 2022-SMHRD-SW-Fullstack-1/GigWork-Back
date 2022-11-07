package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("post")
@RestController
public class PostRestController {
	
	private final PostService postService;
	
	@PostMapping("/create")
	public void createPost(@RequestBody Map<String,Object> data) {
		
		postService.createPost(data);

}	

	@PostMapping("/search")
	public void searchPost() {
		System.out.println(postService.searchPost());
		postService.searchPost();
	}
	
	Gson polistgson = new Gson();
	JsonObject jsonObject = new JsonObject();
	
	@PostMapping("/postlist")
	public List<Post> postlist() {
//		JsonArray jArray = new JsonArray();
//		JsonObject jObject = new JsonObject();
//		
//		List<Post> postlist = postService.searchPost();
//		
//		for(int i=0; i<1; i++) {
//			JsonObject jObjects = new JsonObject();
//			jObjects.addProperty("urgent", postlist.get(i).getUrgent());
//			jObjects.addProperty("startDate", postlist.get(i).getWorktime_s());
//			jObjects.addProperty("endDate", postlist.get(i).getWorktime_e());
//			jObjects.addProperty("jobCategory", postlist.get(i).getPost_cate());
//			jObjects.addProperty("offer", postlist.get(i).getPost_offer_yn());
//			jObjects.addProperty("pay", postlist.get(i).getPost_pay());
//		}
//		jObject.add("JasonArray", jArray);
		
//		return jObject.toString();
		return postService.searchPost();
	}
	
//	@PostMapping("/pagenation")
//	public String pagenation(Map<String,Object> data, Criteria cri ) {
//		List<Post> postList = postService.selectPostListPaging(data,cri);
//		
//		int total = postService.
//		Page page = new Page(cri, total);
//		
	
	
//	}
	
	//로그인하는 Id 같이 넣기.
	@PostMapping("/bookmark")
	public List<Post> bookmark(int post_num, String mem_id) {
		return postService.bookmark();
	}
	
	
}
