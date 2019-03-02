package com.it.Dao;

import java.util.List;

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

/**
 * 整合的接口
 * 
 * @author 22271
 *
 */
public interface SyuinfoDao {
	
    public Syuinfo findById(String stu_id);
    public Syuinfo insertSyu(Syuinfo stu);
    
    /**
     * 红豆角得增删改查
     * @param Userid
     * @return
     */
    public List<UserMassege> findAll();
    public UserMassege findByUserID(String Userid);
    public void upadateUser(String Userid);
    
    //包含所有字段得Insert得语句
    public UserMassege InsertUser(UserMassege User);
    
    //查询所有得关注和粉丝数量
    public List<UserMassege> QueryConcernAndFans(String UserId);
    //查询所有得粉丝姓名
    public List<FansAndconcern> QueryFansName(String UserId);
    //查询所有得关注姓名
    public List<FansAndconcern> QueryConceryName(String UserId);
    //加入订单明细表
    public Order_MX AddOrderMXTable(Order_MX od)throws Exception;
    //加入订单追踪表
  	public OrderZZ AddOrderOrderZZTable(OrderZZ od)throws Exception;
    //加入订单表
  	public Orderinfo AddOrderTable(Orderinfo od)throws Exception;
  	//查询购物车全部商品
  	public List<Wareinfo> QueryAllWareinfo();
  	//查讯全部商品
  	public List<Shangpininfo> QueryAllshangpin();
  	//通过购物车得商品ID查询ID
  	public Wareinfo QueryWareByID(String ware_id);
  	//通过商品ID查询商品
  	public Shangpininfo QuerySpbySpID(String sp_id);
    //模糊搜索功能
  	public List<Shangpininfo> Multiplesearch(String value);
  	//模糊搜索商家
  	public List<Shop> Multiconditionalsearchone(String value);
  	//查询所有的省
  	public List<Province> QueryAllProvince();
  	//通过省ID查询所有的市
  	public List<City> QueryAllCitrByProvinceID(String provinceId);
  	//通过市的ID查询所有的区
  	public List<County> QueryAllcountyByCityId(String cityId);
  	//通过店铺得属性来查找相关得字段
  	public List<Shop> QueryShopByPropert(String Dp_propert);
  	//录入得简单写法
  	public UserMassege inputUser(UserMassege user);
  	//查询全部商品
  	public List<Shop> QueryAllShop();
    //待付款（查询加入购物车得物品）
    public List<Wareinfo> QueryWare();
    //待发货（查询商品ZZ表状态为"1"得值）
    public List<Shangpininfo> Querydeliver();
    //待收货（查询商品ZZ表状态为"2"得值）
    public List<Shangpininfo> Querygather();
}
