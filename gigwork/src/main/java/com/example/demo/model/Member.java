package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	private String mem_id;
	private String mem_pw;
	private String mem_phone;
	private int mem_trust;
	private Date mem_joindate;
	private char mem_type;
}
