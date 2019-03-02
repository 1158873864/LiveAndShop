package com.it.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.Dao.SyuinfoDao;
import com.it.Until.Idcreat;
import com.it.Until.Timeunit;
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
import com.it.service.Syuinfo_service;
import com.it.shoppingservlet.Car;
import com.it.shoppingservlet.Fengzhuanglei;

@Service
public class Serviceimp implements Syuinfo_service{

	@Autowired
    private SyuinfoDao syuinfoDao;
	private Car car;
	
	@Override
	@Transactional
    public Syuinfo findone(String stu_id){
    	return syuinfoDao.findById(stu_id);
    }
	
	@Override
	@Transactional
	public Syuinfo addsyu(Syuinfo stu){
		System.out.println("000000000000000000");
		return syuinfoDao.insertSyu(stu);
	}
	

	/**红豆角
	 * 这是通过用户ID来查询
	 * @return
	 */
	@Override
	@Transactional
	public UserMassege findByUser(String Userid){	
	System.out.println("FindService======"+Userid);
	return 	syuinfoDao.findByUserID(Userid);
	
	}
	
	//查询全部用户
	@Override
	@Transactional
	public List<UserMassege> findAllUser(){	
	return syuinfoDao.findAll();
	}
	
	//修改
	@Override
	@Transactional
	public void upadateUser(String Userid){
	System.out.println("UpdateService======="+Userid);
	syuinfoDao.upadateUser(Userid);
	}
	
	//录入
	@Override
	@Transactional
	public UserMassege insertUser(UserMassege User){
	System.out.println("insertUserService====="+User.getUsername());
	return syuinfoDao.InsertUser(User);
	}
	
	//查询所有得粉丝和关注得数量
	@Override
	@Transactional
	public List<UserMassege> QueryConcernAndFans(String UserID){
	System.out.println("insertUserService====="+UserID);
	return syuinfoDao.QueryConcernAndFans(UserID);	
	}
	
	//查询所有得粉丝名称
	@Override
	@Transactional
	public List<FansAndconcern> QueryFansName(String UserID){
	System.out.println("QueryFansNameService====="+UserID);	
	return syuinfoDao.QueryFansName(UserID);	
	}
	
	//查询所有得关注名称
	@Override
	@Transactional
    public List<FansAndconcern> QueryConceryName(String UserID){
	System.out.println("QueryConceryNameService====="+UserID);
	return syuinfoDao.QueryConceryName(UserID);
	}
	
	//加入购物车功能
	@Override
	@Transactional
	public void AddCar(Shangpininfo ware,String shuliang){
	System.out.println("wareinfo===="+ware.getSp_name()+"shuliang==="+shuliang);
	car.addcarsp(ware, shuliang);
	}
	
	//加入订单表
	@Override
	@Transactional
	public Orderinfo AddOrderTable(String Userid,String total) throws Exception{
	System.out.println("我是订单得Service====");	
	//调用工具类,给订单号命名，防止订单号重复
	String od_id =Idcreat.getod_id(Userid);
	Orderinfo od=new Orderinfo(od_id, Userid, total);
	System.out.println("Orderinfo===="+od.getOd_id()+od.getUserid()+od.getTotal());
	return syuinfoDao.AddOrderTable(od);	
	}
	
	//加入订单追踪表
	@Override
	@Transactional
	public OrderZZ AddOrderOrderZZTable(String Userid) throws Exception{
	System.out.println("我是订单追踪的service");
	
	String od_id =Idcreat.getod_id(Userid);
	String zZ_id = Idcreat.getOdZZId(od_id);
	String time = Timeunit.getnowtime();
	OrderZZ od = new OrderZZ(zZ_id, od_id, "0", time);
	
	System.out.println("AddOrderOrderZZTable======"+od.getTime()+od.getOd_id()+od.getStatm());	
	return syuinfoDao.AddOrderOrderZZTable(od);
	}
	
	//加入订单明细表
	@Override
	@Transactional
	public Order_MX AddOrderMXTable(List<Fengzhuanglei> shopcar,String Userid) throws Exception{
	System.out.println("我是订单明细得Service");
	
	for (Fengzhuanglei it : shopcar) {
		
		 String od_id =Idcreat.getod_id(Userid);
	     String Sp_id = it.getWare().getSp_id();
		 String shuliang = it.getShuliang();
		 String mx_id = Idcreat.getmx_id(od_id);

		 Order_MX mx = new Order_MX(mx_id, od_id, Sp_id, shuliang); 
	     System.out.println("AddOrderMXTable-------"+mx.getOd_id());
	     syuinfoDao.AddOrderMXTable(mx);
	    }
	    return null;
	}
	
	//查询购物车得全部商品
	@Override
	@Transactional
	public List<Wareinfo> Query(){ 
    return syuinfoDao.QueryAllWareinfo();
	}
	
	//查询全部商品
	@Override
	@Transactional
	public List<Shangpininfo> QueryAllsp(){
	return syuinfoDao.QueryAllshangpin();	
	}
	
	//通过物品ID查询物品详细信息
	@Override
	@Transactional
	public  Wareinfo QueryByID(String ware_id){
	return  syuinfoDao.QueryWareByID(ware_id);
	}
	
	//通过物品查询全部得商品（模糊搜索）
	/**
	 * 类似百度的搜索方式
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	 @Override
	 @Transactional
	 public List<Shangpininfo> Multiplesearchone(String value) throws Exception{
	 return syuinfoDao.Multiplesearch(value);
	 } 
	 
	 //模糊查寻所有得店家
	 @Override
	 @Transactional
	 public List<Shop> Multiconditionalsearchone(String value) {
	 return syuinfoDao.Multiconditionalsearchone(value);
	 }
	 
	 
	  //查询所有的省
	  @Override
	  @Transactional
	  public List<Province> QueryAllProvinceone(){  
	  return syuinfoDao.QueryAllProvince();
	  }
	 
	  //通过省ID查询市
	  @Override
	  @Transactional
	  public List<City> QueryAllCitrByProvinceIDone(String provinceId){
	  return syuinfoDao.QueryAllCitrByProvinceID(provinceId); 
	  }
	    
	  //通过市的ID查询所有的区
	  @Override
	  @Transactional
	  public List<County> QueryCountyByCityId(String cityId){
	  return syuinfoDao.QueryAllcountyByCityId(cityId);
	  }
	    
	  //通过分类查询点击查询所有得内容(点击服饰);
	  @Override
	  @Transactional
	  public List<Shop> QueryAllShopBypropert(String Dp_propert){
	  System.out.println("000000000000000000000000");
	  return syuinfoDao.QueryShopByPropert(Dp_propert);  
	  }

      //简单添加用户
	  @Override
	  @Transactional
	  public UserMassege adduser(UserMassege user) {
	  System.out.println("adduser===="+user.getUsername());	
	  return syuinfoDao.InsertUser(user);
	  }
      
	  //查询全部店铺
	  @Override
	  @Transactional
	  public List<Shop> QueryAllShopone() {
	  System.out.println("QueryAllShop=====");
	  return syuinfoDao.QueryAllShop();
	  }
	  
      ////通过商品ID查询商品
	  @Override
	  @Transactional
	  public Shangpininfo QueryshopByID(String sp_id) {
	  return syuinfoDao.QuerySpbySpID(sp_id);
		}
	  
	//待付款（查询加入购物车得物品）
	  @Override
	  @Transactional
	  public List<Wareinfo> QueryWareone() {
	  return syuinfoDao.QueryWare();
		}
     
	 //待发货（查询商品ZZ表状态为"1"得值）
	 @Override
	 @Transactional
	 public List<Shangpininfo> Querydeliverone() {	
	 return syuinfoDao.Querydeliver();
	 
	 }
     
	 //待收货（查询商品ZZ表状态为"2"得值）
	 @Override
	 @Transactional
	 public List<Shangpininfo> Querygatherone() {	
	 return syuinfoDao.Querygather();
	 
	 }
	  
	  
	  
	public SyuinfoDao getSyuinfoDao() {
		return syuinfoDao;
	}

	public void setSyuinfoDao(SyuinfoDao syuinfoDao) {
		this.syuinfoDao = syuinfoDao;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	



	


	  
	
	
}
