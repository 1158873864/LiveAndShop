package com.it.bean;


/**
 * 
 * @author 22271
 *
 */

public class UserMassege {
   private String Userid;
	
   private String Username;
 
   private String Usersex;
   
   private String Phonenumble;
   
   private String Signature;
   
   private String Concern;
  
   private String Fans;

public String getUserid() {
	return Userid;
}

public void setUserid(String userid) {
	Userid = userid;
}

public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}

public String getUsersex() {
	return Usersex;
}

public void setUsersex(String usersex) {
	Usersex = usersex;
}

public String getPhonenumble() {
	return Phonenumble;
}

public void setPhonenumble(String phonenumble) {
	Phonenumble = phonenumble;
}

public String getSignature() {
	return Signature;
}

public void setSignature(String signature) {
	Signature = signature;
}

public String getConcern() {
	return Concern;
}

public void setConcern(String concern) {
	Concern = concern;
}

public String getFans() {
	return Fans;
}

public void setFans(String fans) {
	Fans = fans;
}

public UserMassege(String userid, String username, String usersex,
		String phonenumble, String signature, String concern, String fans) {
	super();
	Userid = userid;
	Username = username;
	Usersex = usersex;
	Phonenumble = phonenumble;
	Signature = signature;
	Concern = concern;
	Fans = fans;
}

public UserMassege() {
	super();
	// TODO Auto-generated constructor stub
}

  
   
   
}
