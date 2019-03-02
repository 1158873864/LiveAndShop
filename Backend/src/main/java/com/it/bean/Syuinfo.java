package com.it.bean;

public class Syuinfo {
    private String stu_id;
    private String stu_name;
    private String stu_birth;
    private String stu_pwd;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_birth() {
		return stu_birth;
	}
	public void setStu_birth(String stu_birth) {
		this.stu_birth = stu_birth;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	public Syuinfo(String stu_id, String stu_name, String stu_birth,
			String stu_pwd) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_birth = stu_birth;
		this.stu_pwd = stu_pwd;
	}
	public Syuinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
