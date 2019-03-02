package com.it.bean;

/**
 * ·ÛË¿ºÍ¹Ø×¢µÃBean
 * @author 22271
 *
 */
public class FansAndconcern {
	private String Userid;
	private String Fansid;
	private String Consernid;
	private String State;
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getFansid() {
		return Fansid;
	}
	public void setFansid(String fansid) {
		Fansid = fansid;
	}
	public String getConsernid() {
		return Consernid;
	}
	public void setConsernid(String consernid) {
		Consernid = consernid;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public FansAndconcern(String userid, String fansid, String consernid,
			String state) {
		super();
		Userid = userid;
		Fansid = fansid;
		Consernid = consernid;
		State = state;
	}
	public FansAndconcern() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
