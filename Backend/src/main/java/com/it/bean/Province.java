package com.it.bean;

/**
 * 省市三级联动
 * @author 22271
 *
 */
public class Province {
    private String provinceId;
    
    private String provinceName;
    
    private String provinceCode;
    
    private String language;

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Province(String provinceId, String provinceName,
			String provinceCode, String language) {
		super();
		this.provinceId = provinceId;
		this.provinceName = provinceName;
		this.provinceCode = provinceCode;
		this.language = language;
	}

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
	
	
	
}
