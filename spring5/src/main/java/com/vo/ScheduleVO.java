package com.vo;

public class ScheduleVO {
	private int yyyy           = 0;
	private int mm             = 0;
	private int dd             = 0;
	private int sc_seq         = 0;
	private String mem_id      = "";
	private String content     = "";
	private String attendance  = "";
	private String closing     = "";
	public int getYyyy() {
		return yyyy;
	}
	public void setYyyy(int yyyy) {
		this.yyyy = yyyy;
	}
	public int getMm() {
		return mm;
	}
	public void setMm(int mm) {
		this.mm = mm;
	}
	public int getDd() {
		return dd;
	}
	public void setDd(int dd) {
		this.dd = dd;
	}
	public int getSc_seq() {
		return sc_seq;
	}
	public void setSc_seq(int sc_seq) {
		this.sc_seq = sc_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getClosing() {
		return closing;
	}
	public void setClosing(String closing) {
		this.closing = closing;
	}
}
