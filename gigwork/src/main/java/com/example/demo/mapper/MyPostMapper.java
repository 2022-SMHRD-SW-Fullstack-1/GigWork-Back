package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Member;
import com.example.demo.model.NamePost;
import com.example.demo.model.Post;
import com.example.demo.model.WishList;

@Mapper
public interface MyPostMapper {

//	@Select("select from t_post where memid=#{mem_Id}")
//	public List<Post> searchMyPost(String mem_Id);
//	
//	@Delete("delete from  )
//	public void deleteAllMyPost(String mem_id);
	
//	public List<WishList> searchmyPost(String mem_id);
	
	public List<Post> searchmyPost(@RequestBody Map<String,Object> num);
	
	public NamePost mynick(int post_num);
	
	public int searchBookmark(@RequestBody Map<String,Object> data);
	
	public void makeNewBookmark(@RequestBody Map<String,Object> data);
	
	public void updateBookmark(@RequestBody Map<String,Object> data);
	
	public List<Map<String,Object>> getmybookmark(@RequestBody Map<String,Object> mem_id);
	
	
}
