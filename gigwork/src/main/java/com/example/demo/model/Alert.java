package com.example.demo.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Alert {
	private int alert_seq;
	private String mem_nick;
	private String alert_cnt;
	private Date alert_time;
	private String sendfrom;
	private String ckecking;
}
