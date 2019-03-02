package com.it.service;

import java.util.List;

import javax.transaction.Transactional;
import com.it.bean.City;
import com.it.bean.County;
import com.it.bean.FansAndconcern;
import com.it.bean.OrderZZ;
import com.it.bean.Order_MX;
import com.it.bean.Orderinfo;
import com.it.bean.Province;
import com.it.bean.Shangpininfo;
import com.it.bean.Shop;
import com.it.bean.Syuinfo;
import com.it.bean.UserMassege;
import com.it.bean.Wareinfo;
import com.it.shoppingservlet.Fengzhuanglei;


public interface Syuinfo_service {
    public Syuinfo findone(String stu_id);
	public Syuinfo addsyu(Syuinfo stu);
		
	
	/**红豆角
	 * 这是通过用户ID来查询
	 * @return
	 */
    //通过用户ID查询用户信息
	public UserMassege findByUser(String Userid);
	
	//查询全部用户
	public List<UserMassege> findAllUser();
	
	//修改
	public void upadateUser(String Userid);
	
	//录入
	public UserMassege insertUser(UserMassege User);
	
	//查询所有得粉丝和关注得数量
	@Transactional
	public List<UserMassege> QueryConcernAndFans(String UserID);
	
	//查询所有得粉丝名称
	public List<FansAndconcern> QueryFansName(String UserID);
	
	//查询所有得关注名称
    public List<FansAndconcern> QueryConceryName(String UserID);
	
	//加入购物车功能
	public void AddCar(Shangpininfo ware,String shuliang);
	
	//加入订单表
	public Orderinfo AddOrderTable(String Userid,String total) throws Exception;
	
	//加入订单追踪表
	public OrderZZ AddOrderOrderZZTable(String Userid) throws Exception;
	
	//加入订单明细表
	public Order_MX AddOrderMXTable(List<Fengzhuanglei> shopcar,String Userid) throws Exception;
	
	//查询购物车得全部shangpin
	public List<Wareinfo> Query();
	
	//查询主界面全部商品
	public List<Shangpininfo> QueryAllsp();
	
	//通过物品ID查询物品详细信息
	public Wareinfo QueryByID(String ware_id);
	
	//通过商品ID查询商品
	public Shangpininfo QueryshopByID(String sp_id);
	
	
	//查询全部得商品（模糊搜索）
	/**
	 * 类似百度的搜索方式
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	  public List<Shangpininfo> Multiplesearchone(String value) throws Exception;
	  
	  //商家得模糊搜索
	  public List<Shop> Multiconditionalsearchone(String value);
	  
	  //查询所有的省
	  public List<Province> QueryAllProvinceone();
	 
	  //通过省ID查询市
	  public List<City> QueryAllCitrByProvinceIDone(String provinceId);
	    
	  //通过市的ID查询所有的区
	  public List<County> QueryCountyByCityId(String cityId);
	    
	  //通过分类查询点击查询所有得内容(点击服饰);
	  public List<Shop> QueryAllShopBypropert(String Dp_propert);
    
      //简单录入
	  public UserMassege adduser(UserMassege user);
	  
	  //查询全部店铺
	  public List<Shop> QueryAllShopone();
	  
	  //待付款（查询加入购物车得物品）
	  public List<Wareinfo> QueryWareone();
	  //待发货（查询商品ZZ表状态为"1"得值）
	  public List<Shangpininfo> Querydeliverone();
	  //待收货（查询商品ZZ表状态为"2"得值）
	  public List<Shangpininfo> Querygatherone();
}
