package com.example.demo.model;

import lombok.Data;

@Data
public class ChattingContent {
	private int cc_seq;
	private String talker;
	private String msg;
	private String msg_time;
	private int cr_seq;
}
