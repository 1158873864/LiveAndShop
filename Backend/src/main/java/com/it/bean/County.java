package com.it.bean;

/**
 * 省市三级联动
 * @author 22271
 *
 */
public class County {
   private String countyId;
   
   private String countyName;
   
   private String countyCode;
   
   private String cityId;

public String getCountyId() {
	return countyId;
}

public void setCountyId(String countyId) {
	this.countyId = countyId;
}

public String getCountyName() {
	return countyName;
}

public void setCountyName(String countyName) {
	this.countyName = countyName;
}

public String getCountyCode() {
	return countyCode;
}

public void setCountyCode(String countyCode) {
	this.countyCode = countyCode;
}

public String getCityId() {
	return cityId;
}

public void setCityId(String cityId) {
	this.cityId = cityId;
}

public County(String countyId, String countyName, String countyCode,
		String cityId) {
	super();
	this.countyId = countyId;
	this.countyName = countyName;
	this.countyCode = countyCode;
	this.cityId = cityId;
}

public County() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
