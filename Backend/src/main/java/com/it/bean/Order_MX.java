package com.it.bean;

public class Order_MX {
    private String mx_id;
    private String od_id;
    private String sp_id;
    private String shuliang;
	public String getMx_id() {
		return mx_id;
	}
	public void setMx_id(String mx_id) {
		this.mx_id = mx_id;
	}
	public String getOd_id() {
		return od_id;
	}
	public void setOd_id(String od_id) {
		this.od_id = od_id;
	}
	public String getSp_id() {
		return sp_id;
	}
	public void setSp_id(String sp_id) {
		this.sp_id = sp_id;
	}
	public String getShuliang() {
		return shuliang;
	}
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	public Order_MX(String mx_id, String od_id, String sp_id, String shuliang) {
		super();
		this.mx_id = mx_id;
		this.od_id = od_id;
		this.sp_id = sp_id;
		this.shuliang = shuliang;
	}
	public Order_MX() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
    
}
