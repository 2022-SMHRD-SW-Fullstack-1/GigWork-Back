package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Post;

@Mapper
public interface PostMapper {
	
	public void writePost(Post postdata);

}
