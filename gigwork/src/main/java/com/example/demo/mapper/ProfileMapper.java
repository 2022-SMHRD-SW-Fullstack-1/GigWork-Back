package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileMapper {

	public void createProfile(Map<String,Object> pro);
}
