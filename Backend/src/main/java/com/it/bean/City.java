package com.it.bean;

/**
 * 省市三级联动
 * @author 22271
 *
 */
public class City {
  private String cityId;
  
  private String cityName;
  
  private String cityCode;
  
  private String provinceId;

public String getCityId() {
	return cityId;
}

public void setCityId(String cityId) {
	this.cityId = cityId;
}

public String getCityName() {
	return cityName;
}

public void setCityName(String cityName) {
	this.cityName = cityName;
}

public String getCityCode() {
	return cityCode;
}

public void setCityCode(String cityCode) {
	this.cityCode = cityCode;
}

public String getProvinceId() {
	return provinceId;
}

public void setProvinceId(String provinceId) {
	this.provinceId = provinceId;
}

public City(String cityId, String cityName, String cityCode, String provinceId) {
	super();
	this.cityId = cityId;
	this.cityName = cityName;
	this.cityCode = cityCode;
	this.provinceId = provinceId;
}

public City() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
}
