package com.ex.dto;

import java.security.Timestamp;

public class BDto {

	
	int bid;
	String bName;
	String bTitle;
	Timestamp bDate;
	int hit;
	int bGroup;
	int bStep;
	int bIndent;
	
	public BDto() {
		
	}
	
	public BDto(int bid, String bName, String bTitle, Timestamp bDate,int hit, int bGroup, int bStep, int bIndent) {
		this.bid = bid;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bDate = bDate;
		this.hit = hit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
}
