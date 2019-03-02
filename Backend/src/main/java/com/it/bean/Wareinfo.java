package com.it.bean;

public class Wareinfo {
    private String ware_id;
    private String ware_name;
    private String ware_price;
    private String ware_photo;
	public String getWare_id() {
		return ware_id;
	}
	public void setWare_id(String ware_id) {
		this.ware_id = ware_id;
	}
	public String getWare_name() {
		return ware_name;
	}
	public void setWare_name(String ware_name) {
		this.ware_name = ware_name;
	}
	public String getWare_price() {
		return ware_price;
	}
	public void setWare_price(String ware_price) {
		this.ware_price = ware_price;
	}
	public String getWare_photo() {
		return ware_photo;
	}
	public void setWare_photo(String ware_photo) {
		this.ware_photo = ware_photo;
	}
	public Wareinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wareinfo(String ware_id, String ware_name, String ware_price,
			String ware_photo) {
		super();
		this.ware_id = ware_id;
		this.ware_name = ware_name;
		this.ware_price = ware_price;
		this.ware_photo = ware_photo;
	}
	
	
	
}
