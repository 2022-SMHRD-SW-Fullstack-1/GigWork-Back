package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface RegisterMapper {
	public void createRegister(@RequestBody Map<String,Object> info);

	public String login(@RequestBody Map<String,Object> info);
}
