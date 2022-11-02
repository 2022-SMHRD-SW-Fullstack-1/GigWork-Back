package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Member;
import com.example.demo.model.OtherView;
import com.example.demo.model.ProfileList;

@Mapper
public interface ProfileMapper {

	public void createProfile(Map<String,Object> pro);

	public String select();
	
	public List<ProfileList> prolist();
	
	public OtherView otherview(@RequestBody Map<String,Object> name);
}
