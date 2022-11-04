package com.example.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.PostMapper;
import com.example.demo.model.Post;

@Service
public class PostService {
	
	@Autowired
	PostMapper postMapper;
	
	public void writePost(HashMap<String, Object> data) {

		Post postdata = new Post();
		
		postdata.setMem_id((String)(data.get("mem_id")));
		postdata.setPost_cate((String)(data.get("category")));
		postdata.setPost_pay((int)(data.get("pay")));
		postdata.setPost_offer_yn((char)(data.get("offer")));	
		postdata.setWorktime_s((Date)(data.get("starttime")));
		postdata.setWorktime_e((Date)(data.get("endtime")));
		postdata.setLng((Double)(data.get("locX")));
		postdata.setLat((Double)(data.get("locY")));
		postdata.setUrgent((char)(data.get("urgent")));		
		postdata.setTitle((String)(data.get("title")));
		postdata.setContent((String)(data.get("content")));
		
		postMapper.writePost(postdata);
		
		
	}
	
	
	
	
	

}
