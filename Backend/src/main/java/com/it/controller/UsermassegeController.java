package com.it.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.bean.City;
import com.it.bean.County;
import com.it.bean.FansAndconcern;
import com.it.bean.Province;
import com.it.bean.Shangpininfo;
import com.it.bean.Shop;
import com.it.bean.UserMassege;
import com.it.service.Syuinfo_service;
import com.it.shoppingservlet.Car;
import com.it.shoppingservlet.Fengzhuanglei;

@Controller
@RequestMapping("/UserManage")
public class UsermassegeController {
	@Autowired
    private Syuinfo_service syuinfo_service;
	private UserMassege User=new UserMassege("", "", "", "", "","","");
    
	/**
	 * 通过ID显示用户信息
	 * @return
	 */
    // /UserManage /show /showUser {UserId}  OK
    @RequestMapping(value="/showUser/{Userid}",method=RequestMethod.POST)
    public ModelAndView showUser(@PathVariable ("Userid") String Userid){
   	System.out.println("=======showAction========="+Userid);
   	ModelAndView model=new ModelAndView("index");
    UserMassege User=syuinfo_service.findByUser(Userid);
   	System.out.println(User.getUsername()+"111111111111");
   	model.addObject("User", User);
   	//Spring得视图解析器，会自动找到对应的JSP页面
   	return model;
   }
	
   //查询全部用户信息 ok
   @ResponseBody   
   @RequestMapping(value="/QueryAllUser",method=RequestMethod.POST)
   public ModelAndView QueryAllUser(){
   List<UserMassege> User=syuinfo_service.findAllUser(); 
   System.out.println(User.size());
   ModelAndView model=new ModelAndView("index");
   model.addObject("User", User);
   return model;  
   }
	
   //修改
   @RequestMapping(value="/UpadateUser/{Userid}",method=RequestMethod.POST)
   public String UpadateUser(@PathVariable ("Userid") String Userid){
   System.out.println("UpadateUser======"+Userid);
   syuinfo_service.upadateUser(Userid);
   return "index";
   }
   
   //录入 no
   @RequestMapping(value="/InputUser")
   public String InputUser(@RequestParam(value="Username",required=true)String Username
	,@RequestParam("Usersex")String Usersex,@RequestParam("Phonenumble")String Phonenumble
    ,@RequestParam("Signature") String Signature,@RequestParam("Concern") String Concern,@RequestParam("Fans") String Fans){
   System.out.println("inputUser==="+User.getUsername()); 
   User.setUsername(Username);
   User.setUsersex(Usersex);
   User.setPhonenumble(Phonenumble);
   User.setSignature(Signature);
   //新用户都是0
   User.setConcern("0");
   User.setFans("0");
   syuinfo_service.insertUser(User);
   return "index";  
   }
   
   
   //简单录入 no
   @RequestMapping(value="AddUser")
   public String AddUser(UserMassege User){
   System.out.println("AddUser===="+User.getUsername());
   syuinfo_service.insertUser(User); 
   return "index";
   }
   
   
   //查询所有得粉丝数量和关注数量 ok
   @RequestMapping(value="/FansAndConcernCount/{UserId}",method=RequestMethod.POST)
   public ModelAndView FansAndConcernCount(@PathVariable ("UserId") String UserId){
   System.out.println("FansAndConcernCount========="+UserId);
   ModelAndView model=new ModelAndView("index");
   List<UserMassege> userinfo=syuinfo_service.QueryConcernAndFans(UserId);
   model.addObject("userinfo", userinfo);
   return model;
   }
   
   //查询所有得粉丝姓名 ok
   @RequestMapping(value="/FindFansName/{UserID}",method=RequestMethod.POST)
   public ModelAndView FindFansName(@PathVariable ("UserID") String UserID){ 
   System.out.println("FindFansName====="+UserID);
   List<FansAndconcern> FansName=syuinfo_service.QueryFansName(UserID);
   ModelAndView model=new ModelAndView("index");
   model.addObject("FansName", FansName);
   return model;
   }
   
    //查询所有得关注名称 ok
   @RequestMapping(value="QueryConceryName/{UserID}",method=RequestMethod.POST)
   public ModelAndView QueryConceryName(String UserID){
   System.out.println("QueryConceryName====="+UserID);
   List<FansAndconcern> Concername=syuinfo_service.QueryConceryName(UserID);
   ModelAndView model=new ModelAndView("index");
   model.addObject("Concername", Concername);
   return model;     
   }
  
   //查询全部商品 ok
   @RequestMapping(value="QuerySp")
   public ModelAndView QuerySp(){
   System.out.println("sp==========");
   List<Shangpininfo> sp=syuinfo_service.QueryAllsp();
   ModelAndView model=new ModelAndView("index");
   model.addObject("sp", sp);
   return model;
   }
   
   
   //查询省市三级联动
   @RequestMapping(value="/QueryProvinice",method=RequestMethod.POST)
   public ModelAndView QueryProvinice(){
   List<Province> pro=syuinfo_service.QueryAllProvinceone(); 
   ModelAndView model=new ModelAndView("index");
   model.addObject("pro", pro);
   return model; 
   }
   
   //查找市得联动 ok
   @RequestMapping(value="/QueryCity/{provinceId}",method=RequestMethod.POST)
   public ModelAndView QueryCity(@PathVariable("provinceId") String provinceId){
   System.out.println("QueryCity===="+provinceId);
   List<City> city=syuinfo_service.QueryAllCitrByProvinceIDone(provinceId);
   ModelAndView model=new ModelAndView("index");
   model.addObject("city", city);
   return model; 
   }
   
   //查找区得联动 ok
   @RequestMapping(value="/QueryCounty/{cityId}",method=RequestMethod.POST)
   public ModelAndView QueryCounty(@PathVariable("cityId") String cityId){
   System.out.println("=========="+cityId+"=====");
   List<County> county=syuinfo_service.QueryCountyByCityId(cityId); 
   ModelAndView model=new ModelAndView("index"); 
   model.addObject("county", county);
   return model;
   }
   
   //通过点击分类查询所有得店铺 ok
   @RequestMapping(value="/QueryShop/{Dp_propert}",method=RequestMethod.POST)
   public ModelAndView QueryShop(@PathVariable("Dp_propert") String Dp_propert){
   System.out.println("String Dp_propert====="+Dp_propert);
   List<Shop> shop=syuinfo_service.QueryAllShopBypropert(Dp_propert);
   ModelAndView model=new ModelAndView("index");
   model.addObject("shop", shop);
   return model;
   }
   
   
   //查询全部店铺 ok
   @RequestMapping(value="QueryAllShop",method=RequestMethod.POST)
   public ModelAndView QueryAllShop(){
   System.out.println("sp==========");
   List<Shop> sp=syuinfo_service.QueryAllShopone();
   ModelAndView model=new ModelAndView("index");
   model.addObject("sp", sp);
   return model;
   }
   
   //模糊搜索（百度） ok
   @RequestMapping(value="/Mohusearch/{value}",method=RequestMethod.POST)
   public ModelAndView Mohusearch(@PathVariable("value") String value) throws Exception{
   System.out.println("Mohusearch======="+value);
   List<Shangpininfo> SP=syuinfo_service.Multiplesearchone(value);
   ModelAndView model=new ModelAndView("index");
   model.addObject("SP", SP);
   return model;   
   }
   
   //模糊搜索店家 ok
   @RequestMapping(value="/MohusearchAllShop/{value}",method=RequestMethod.POST)
   public ModelAndView MohusearchAllShop(@PathVariable("value") String value) throws Exception{
   System.out.println("Mohusearch======="+value);
   List<Shop> SP=syuinfo_service.Multiconditionalsearchone(value);
   ModelAndView model=new ModelAndView("index");
   model.addObject("SP", SP);
   return model;   
   }
   
   //加入购物车功能 (待测试)
   @RequestMapping(value="/AddCar/{sp_id}/AddCar/{shuliang}" ,method=RequestMethod.POST)
   public String AddCar(@PathVariable("sp_id") String sp_id,@PathVariable("shuliang") String shuliang,HttpSession session){
   System.out.println("AddCar===ware_id="+sp_id+"====shuliang="+shuliang);   
   //通过sp_id来查询出所有得商品 
   Shangpininfo shop= syuinfo_service.QueryshopByID(sp_id);
   @SuppressWarnings("unchecked")
   List<Fengzhuanglei> list1=(List<Fengzhuanglei>)session.getAttribute("car");
   Car shopcar=new Car(list1);
   shopcar.addcarsp(shop, shuliang);
   //转发到购物车界面
   return "index";
   }
   
   
   //下单支付（事务，同时添加三张表）(有点问题)
   @RequestMapping("/PayMoney")
   public String PayMoney(List<Fengzhuanglei> shopcar,String Userid,String total) throws Exception{
   syuinfo_service.AddOrderMXTable(shopcar, Userid);
   syuinfo_service.AddOrderOrderZZTable(Userid);
   syuinfo_service.AddOrderTable(Userid, total);
   return "index";   
   }
   
   //待付款（查询加入购物车得物品）
   
   //待发货（查询商品ZZ表状态为"1"得值）
   @RequestMapping(value="QueryAllware",method=RequestMethod.POST)
   public ModelAndView QueryAllware(){
   System.out.println("QueryAllware==========");
   List<Shangpininfo> sp=syuinfo_service.Querydeliverone();
   ModelAndView model=new ModelAndView("index");
   model.addObject("sp", sp);
   return model;
   }
   //待收货（查询商品ZZ表状态为"2"得值）
   @RequestMapping(value="QueryAllShouhuo",method=RequestMethod.POST)
   public ModelAndView QueryAllShouhuo(){
   System.out.println("QueryAllware==========");
   List<Shangpininfo> sp=syuinfo_service.Querygatherone();
   ModelAndView model=new ModelAndView("index");
   model.addObject("sp", sp);
   return model;
   }
   
   
 
public UserMassege getUser() {
	return User;
}

public void setUser(UserMassege user) {
	User = user;
}

public Syuinfo_service getSyuinfo_service() {
	return syuinfo_service;
}

public void setSyuinfo_service(Syuinfo_service syuinfo_service) {
	this.syuinfo_service = syuinfo_service;
}



   
}
