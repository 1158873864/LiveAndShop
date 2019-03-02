package com.it.bean;

public class OrderZZ {
   private String ZZ_id;
   private String od_id;
   private String statm;
   private String time;
public String getZZ_id() {
	return ZZ_id;
}
public void setZZ_id(String zZ_id) {
	ZZ_id = zZ_id;
}
public String getOd_id() {
	return od_id;
}
public void setOd_id(String od_id) {
	this.od_id = od_id;
}
public String getStatm() {
	return statm;
}
public void setStatm(String statm) {
	this.statm = statm;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public OrderZZ() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderZZ(String zZ_id, String od_id, String statm, String time) {
	super();
	ZZ_id = zZ_id;
	this.od_id = od_id;
	this.statm = statm;
	this.time = time;
}
	
	
	
	
	
	
	
	
}
