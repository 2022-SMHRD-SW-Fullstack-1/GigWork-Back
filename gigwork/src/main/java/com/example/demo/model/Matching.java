package com.example.demo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Matching {
	private int match_seq;
	private String post_num;
	private String match_id;
	private java.sql.Date match_date;
}
