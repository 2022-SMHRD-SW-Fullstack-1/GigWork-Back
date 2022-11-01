package com.example.demo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
	private String mem_id;
	private String mem_pw;
	private String mem_phone;
	private int mem_trust;
	private Date mem_joindate;
	private Double lat;
	private Double lng;
	private char mem_type;
	private int age;
	private char gender;
}
