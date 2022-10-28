package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Post {
	private int post_num;
	private String mem_id;
	private int post_cate;
	private int post_pay;
	private char post_offer_yn;
	private Date worktime_s;
	private Date worktime_e;
	private int lat;
	private int lng;
	private char urgent;
	private String title;
	private String content;
	private String img_src;
	private Date reg_date;
}
