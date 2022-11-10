package com.example.demo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class MatchingInsert {
	private int match_seq;
	private int post_num;
	private String match_id;
	private Date match_date;
}
