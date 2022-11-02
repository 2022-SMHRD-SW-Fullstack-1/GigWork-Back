package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProfileList {
	private String mem_id;
	private String name;
	private String gender;
	private int age;
	private String say;
	private String img_src;
	private String sido;
	private String gungu;
	private String cate_one;
	private String cate_two;
	private String cate_three;
}

