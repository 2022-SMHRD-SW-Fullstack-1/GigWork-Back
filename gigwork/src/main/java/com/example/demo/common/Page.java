package com.example.demo.common;

import com.example.demo.common.Criteria;

import lombok.Data;

@Data
public class Page {

	private int startPage;
	private int endPage;
	private boolean prev, next;

	private int total;
	private Criteria cri;

	public Page(Criteria cri, int total) {

		this.cri = cri;
		this.total = total;

		// 여기서 10은 페이지블록을 구성하는 페이지 개수
		this.endPage = (int) Math.ceil(cri.getPageNum() / 10.0) * 5;

		this.startPage = this.endPage - (10 - 1);

		// 실제 끝페이지
		int realEnd = (int) Math.ceil((double) total / cri.getAmount());

		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		this.prev = this.startPage > 1;

		this.next = this.endPage < realEnd;
	}

}
