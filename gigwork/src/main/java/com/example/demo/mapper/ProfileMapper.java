package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Manner;
import com.example.demo.model.Matching;
import com.example.demo.model.Member;
import com.example.demo.model.MyView;
import com.example.demo.model.OtherView;
import com.example.demo.model.Post;
import com.example.demo.model.Privacy;
import com.example.demo.model.ProfileList;

@Mapper
public interface ProfileMapper {

	public void createProfile(Map<String,Object> pro);
	
	public void correctionProfile(Map<String,Object> pro);

	public String select();
	
	public List<ProfileList> prolist();
	
	public OtherView otherview(@RequestBody Map<String,Object> name);
	
	public MyView myview(@RequestBody Map<String,Object> id);
	
	public int hasPro(@RequestBody Map<String,Object> id);
	
	public List<Matching> activeList(@RequestBody Map<String,Object> id);
	
	public List<Manner> evaluation(@RequestBody Map<String,Object> id);
	
	public String nameToId(@RequestBody Map<String,Object> id);

	public void evl(@RequestBody Map<String,Object> info);
	
	public void evl5(@RequestBody Map<String,Object> name);
	
	public void evl4(@RequestBody Map<String,Object> name);
	
	public void evl2(@RequestBody Map<String,Object> name);
	
	public void evl1(@RequestBody Map<String,Object> name);
	
	public Privacy privacy(@RequestBody Map<String,Object> id);

	public List<Post> bringPost(@RequestBody Map<String,Object> id);
}
