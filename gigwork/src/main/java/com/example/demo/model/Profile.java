package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Profile {
	private String mem_id;
	private String say;
	private Date open_date;
	private Date close_date;
}
