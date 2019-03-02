package com.it.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Shangpininfo implements Serializable{
   private String sp_id;
   private String sp_name;
   private String sp_price;
   private String tp_id;
   private String sp_jieshao;
public String getSp_id() {
	return sp_id;
}
public void setSp_id(String sp_id) {
	this.sp_id = sp_id;
}
public String getSp_name() {
	return sp_name;
}
public void setSp_name(String sp_name) {
	this.sp_name = sp_name;
}
public String getSp_price() {
	return sp_price;
}
public void setSp_price(String sp_price) {
	this.sp_price = sp_price;
}
public String gettp_id() {
	return tp_id;
}
public void settp_id(String tp_id) {
	this.tp_id = tp_id;
}
public String getSp_jieshao() {
	return sp_jieshao;
}
public void setSp_jieshao(String sp_jieshao) {
	this.sp_jieshao = sp_jieshao;
}
public Shangpininfo(String sp_id, String sp_name, String sp_price,
		String tp_id, String sp_jieshao) {
	super();
	this.sp_id = sp_id;
	this.sp_name = sp_name;
	this.sp_price = sp_price;
	this.tp_id = tp_id;
	this.sp_jieshao = sp_jieshao;
}
public Shangpininfo() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
   
   
}
