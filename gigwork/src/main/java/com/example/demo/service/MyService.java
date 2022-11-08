package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.MyPostMapper;
import com.example.demo.mapper.PostMapper;
import com.example.demo.model.Member;
import com.example.demo.model.NamePost;
import com.example.demo.model.Post;
import com.example.demo.model.WishList;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class MyService {
	
	private final MyPostMapper mypostMapper;
	
//	public List<Post> searchMyPost(String mem_Id){
//		return mypostMapper.searchMyPost(mem_Id);
//	}

//	public void deleteAllMyPost(String mem_id) {
//		mypostMapper.deleteAllMyPost(mem_id);
//	}
	
//	public List<WishList> searchmyPost(String mem_id) {
//		return mypostMapper.searchmyPost(mem_id);
//	}
	public List<Post> searchmyPost(@RequestBody Map<String,Object> num) {
		return mypostMapper.searchmyPost(num);
	}
//	
//	public void myBookmark(@RequestBody Map<String,Object> data) {
//		
//		if(myBookmark(data).checkExist == null) {
//			return mypostMapper.makeNewBookmark(data);
//		}else if{
//			return mypostMapper.updateBookmark(data);
//			
//		}
//		
//}
	
	public NamePost mynick(@RequestBody Map<String,Object> mem_id) {
		return mypostMapper.mynick(mem_id);
	}
}
