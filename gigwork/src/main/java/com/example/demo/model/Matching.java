package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Matching {
	private int match_seq;
	private int post_num;
	private String match_id;
	private Date match_date;
}
