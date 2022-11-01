package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProfileList {
	private String mem_id;
	private String name;
	private int age;
	private String say;
	private String img_src;
	private Double lat;
	private Double lng;
	private String cate_one;
	private String cate_two;
	private String cate_three;
}

