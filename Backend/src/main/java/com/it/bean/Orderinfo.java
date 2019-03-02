package com.it.bean;

public class Orderinfo {
    private String od_id;
    private String Userid;
    private String total;
	public String getOd_id() {
		return od_id;
	}
	public void setOd_id(String od_id) {
		this.od_id = od_id;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Orderinfo(String od_id, String userid, String total) {
		super();
		this.od_id = od_id;
		Userid = userid;
		this.total = total;
	}
	public Orderinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
	
	
	
	
}
