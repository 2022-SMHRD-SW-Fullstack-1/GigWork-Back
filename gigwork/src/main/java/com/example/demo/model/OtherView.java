package com.example.demo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OtherView {
	private String name;
	private int mem_trust;
	private String cate_one;
	private String cate_two;
	private String cate_three;
	private String say;
	private String open_date;
	private String close_date;
}
