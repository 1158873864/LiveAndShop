package com.it.shoppingservlet;
import org.springframework.stereotype.Component;

import com.it.bean.Shangpininfo;

/**
 * 这个类的目的是为了把购物车里面的商品和数量封装成一个对象
 * 里面有
 * @author zq
 *
 */
@Component
 public class Fengzhuanglei {
	
	private Shangpininfo ware;
    private String shuliang;
    
    
	public Shangpininfo getWare() {
		return ware;
	}
	public void setWare(Shangpininfo ware) {
		this.ware = ware;
	}
	public String getShuliang() {
		return shuliang;
	}
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	public Fengzhuanglei(Shangpininfo ware, String shuliang) {
		super();
		this.ware = ware;
		this.shuliang = shuliang;
	}
	public Fengzhuanglei() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
	
}
