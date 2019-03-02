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
	

	/**�춹��
	 * ����ͨ���û�ID����ѯ
	 * @return
	 */
	@Override
	@Transactional
	public UserMassege findByUser(String Userid){	
	System.out.println("FindService======"+Userid);
	return 	syuinfoDao.findByUserID(Userid);
	
	}
	
	//��ѯȫ���û�
	@Override
	@Transactional
	public List<UserMassege> findAllUser(){	
	return syuinfoDao.findAll();
	}
	
	//�޸�
	@Override
	@Transactional
	public void upadateUser(String Userid){
	System.out.println("UpdateService======="+Userid);
	syuinfoDao.upadateUser(Userid);
	}
	
	//¼��
	@Override
	@Transactional
	public UserMassege insertUser(UserMassege User){
	System.out.println("insertUserService====="+User.getUsername());
	return syuinfoDao.InsertUser(User);
	}
	
	//��ѯ���е÷�˿�͹�ע������
	@Override
	@Transactional
	public List<UserMassege> QueryConcernAndFans(String UserID){
	System.out.println("insertUserService====="+UserID);
	return syuinfoDao.QueryConcernAndFans(UserID);	
	}
	
	//��ѯ���е÷�˿����
	@Override
	@Transactional
	public List<FansAndconcern> QueryFansName(String UserID){
	System.out.println("QueryFansNameService====="+UserID);	
	return syuinfoDao.QueryFansName(UserID);	
	}
	
	//��ѯ���еù�ע����
	@Override
	@Transactional
    public List<FansAndconcern> QueryConceryName(String UserID){
	System.out.println("QueryConceryNameService====="+UserID);
	return syuinfoDao.QueryConceryName(UserID);
	}
	
	//���빺�ﳵ����
	@Override
	@Transactional
	public void AddCar(Shangpininfo ware,String shuliang){
	System.out.println("wareinfo===="+ware.getSp_name()+"shuliang==="+shuliang);
	car.addcarsp(ware, shuliang);
	}
	
	//���붩����
	@Override
	@Transactional
	public Orderinfo AddOrderTable(String Userid,String total) throws Exception{
	System.out.println("���Ƕ�����Service====");	
	//���ù�����,����������������ֹ�������ظ�
	String od_id =Idcreat.getod_id(Userid);
	Orderinfo od=new Orderinfo(od_id, Userid, total);
	System.out.println("Orderinfo===="+od.getOd_id()+od.getUserid()+od.getTotal());
	return syuinfoDao.AddOrderTable(od);	
	}
	
	//���붩��׷�ٱ�
	@Override
	@Transactional
	public OrderZZ AddOrderOrderZZTable(String Userid) throws Exception{
	System.out.println("���Ƕ���׷�ٵ�service");
	
	String od_id =Idcreat.getod_id(Userid);
	String zZ_id = Idcreat.getOdZZId(od_id);
	String time = Timeunit.getnowtime();
	OrderZZ od = new OrderZZ(zZ_id, od_id, "0", time);
	
	System.out.println("AddOrderOrderZZTable======"+od.getTime()+od.getOd_id()+od.getStatm());	
	return syuinfoDao.AddOrderOrderZZTable(od);
	}
	
	//���붩����ϸ��
	@Override
	@Transactional
	public Order_MX AddOrderMXTable(List<Fengzhuanglei> shopcar,String Userid) throws Exception{
	System.out.println("���Ƕ�����ϸ��Service");
	
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
	
	//��ѯ���ﳵ��ȫ����Ʒ
	@Override
	@Transactional
	public List<Wareinfo> Query(){ 
    return syuinfoDao.QueryAllWareinfo();
	}
	
	//��ѯȫ����Ʒ
	@Override
	@Transactional
	public List<Shangpininfo> QueryAllsp(){
	return syuinfoDao.QueryAllshangpin();	
	}
	
	//ͨ����ƷID��ѯ��Ʒ��ϸ��Ϣ
	@Override
	@Transactional
	public  Wareinfo QueryByID(String ware_id){
	return  syuinfoDao.QueryWareByID(ware_id);
	}
	
	//ͨ����Ʒ��ѯȫ������Ʒ��ģ��������
	/**
	 * ���ưٶȵ�������ʽ
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	 @Override
	 @Transactional
	 public List<Shangpininfo> Multiplesearchone(String value) throws Exception{
	 return syuinfoDao.Multiplesearch(value);
	 } 
	 
	 //ģ����Ѱ���еõ��
	 @Override
	 @Transactional
	 public List<Shop> Multiconditionalsearchone(String value) {
	 return syuinfoDao.Multiconditionalsearchone(value);
	 }
	 
	 
	  //��ѯ���е�ʡ
	  @Override
	  @Transactional
	  public List<Province> QueryAllProvinceone(){  
	  return syuinfoDao.QueryAllProvince();
	  }
	 
	  //ͨ��ʡID��ѯ��
	  @Override
	  @Transactional
	  public List<City> QueryAllCitrByProvinceIDone(String provinceId){
	  return syuinfoDao.QueryAllCitrByProvinceID(provinceId); 
	  }
	    
	  //ͨ���е�ID��ѯ���е���
	  @Override
	  @Transactional
	  public List<County> QueryCountyByCityId(String cityId){
	  return syuinfoDao.QueryAllcountyByCityId(cityId);
	  }
	    
	  //ͨ�������ѯ�����ѯ���е�����(�������);
	  @Override
	  @Transactional
	  public List<Shop> QueryAllShopBypropert(String Dp_propert){
	  System.out.println("000000000000000000000000");
	  return syuinfoDao.QueryShopByPropert(Dp_propert);  
	  }

      //������û�
	  @Override
	  @Transactional
	  public UserMassege adduser(UserMassege user) {
	  System.out.println("adduser===="+user.getUsername());	
	  return syuinfoDao.InsertUser(user);
	  }
      
	  //��ѯȫ������
	  @Override
	  @Transactional
	  public List<Shop> QueryAllShopone() {
	  System.out.println("QueryAllShop=====");
	  return syuinfoDao.QueryAllShop();
	  }
	  
      ////ͨ����ƷID��ѯ��Ʒ
	  @Override
	  @Transactional
	  public Shangpininfo QueryshopByID(String sp_id) {
	  return syuinfoDao.QuerySpbySpID(sp_id);
		}
	  
	//�������ѯ���빺�ﳵ����Ʒ��
	  @Override
	  @Transactional
	  public List<Wareinfo> QueryWareone() {
	  return syuinfoDao.QueryWare();
		}
     
	 //����������ѯ��ƷZZ��״̬Ϊ"1"��ֵ��
	 @Override
	 @Transactional
	 public List<Shangpininfo> Querydeliverone() {	
	 return syuinfoDao.Querydeliver();
	 
	 }
     
	 //���ջ�����ѯ��ƷZZ��״̬Ϊ"2"��ֵ��
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
