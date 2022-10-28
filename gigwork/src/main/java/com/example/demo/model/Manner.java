package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Manner {

	private int evl_seq;
	private String mem_id;
	private String partner_id;
	private int evl_point;
	private String evl_content;
	private Date evl_date;
}
