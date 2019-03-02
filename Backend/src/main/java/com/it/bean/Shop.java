package com.it.bean;

/**
 * µÍ∆Ãµ√ Ù–‘≤„
 * @author 22271
 *
 */
public class Shop {
	
   private String Dp_id;
   
   private String Dp_name;
   
   private String Dp_introduce;
   
   private String Dp_propert;
   
   private String Dp_fans;
   
   private String volume;

public String getDp_id() {
	return Dp_id;
}

public void setDp_id(String dp_id) {
	Dp_id = dp_id;
}

public String getDp_name() {
	return Dp_name;
}

public void setDp_name(String dp_name) {
	Dp_name = dp_name;
}

public String getDp_introduce() {
	return Dp_introduce;
}

public void setDp_introduce(String dp_introduce) {
	Dp_introduce = dp_introduce;
}

public String getDp_propert() {
	return Dp_propert;
}

public void setDp_propert(String dp_propert) {
	Dp_propert = dp_propert;
}

public String getDp_fans() {
	return Dp_fans;
}

public void setDp_fans(String dp_fans) {
	Dp_fans = dp_fans;
}

public String getVolume() {
	return volume;
}

public void setVolume(String volume) {
	this.volume = volume;
}

public Shop(String dp_id, String dp_name, String dp_introduce,
		String dp_propert, String dp_fans, String volume) {
	super();
	Dp_id = dp_id;
	Dp_name = dp_name;
	Dp_introduce = dp_introduce;
	Dp_propert = dp_propert;
	Dp_fans = dp_fans;
	this.volume = volume;
}

public Shop() {
	super();
	// TODO Auto-generated constructor stub
}
	
	
	
	
	
}
