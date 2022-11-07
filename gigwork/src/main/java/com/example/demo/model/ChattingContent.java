package com.example.demo.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ChattingContent {
	private int cc_seq;
	private String talker;
	private String msg;
	private String msg_time;
	private int cr_seq;
}
