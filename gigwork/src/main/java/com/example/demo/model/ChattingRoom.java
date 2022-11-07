package com.example.demo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ChattingRoom {
	private int cr_seq;
	private String mem_nick;
	private Date cr_date;
	private String partner_nick;
	private char cr_status;
}
