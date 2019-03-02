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
		
	
	/**�춹��
	 * ����ͨ���û�ID����ѯ
	 * @return
	 */
    //ͨ���û�ID��ѯ�û���Ϣ
	public UserMassege findByUser(String Userid);
	
	//��ѯȫ���û�
	public List<UserMassege> findAllUser();
	
	//�޸�
	public void upadateUser(String Userid);
	
	//¼��
	public UserMassege insertUser(UserMassege User);
	
	//��ѯ���е÷�˿�͹�ע������
	@Transactional
	public List<UserMassege> QueryConcernAndFans(String UserID);
	
	//��ѯ���е÷�˿����
	public List<FansAndconcern> QueryFansName(String UserID);
	
	//��ѯ���еù�ע����
    public List<FansAndconcern> QueryConceryName(String UserID);
	
	//���빺�ﳵ����
	public void AddCar(Shangpininfo ware,String shuliang);
	
	//���붩����
	public Orderinfo AddOrderTable(String Userid,String total) throws Exception;
	
	//���붩��׷�ٱ�
	public OrderZZ AddOrderOrderZZTable(String Userid) throws Exception;
	
	//���붩����ϸ��
	public Order_MX AddOrderMXTable(List<Fengzhuanglei> shopcar,String Userid) throws Exception;
	
	//��ѯ���ﳵ��ȫ��shangpin
	public List<Wareinfo> Query();
	
	//��ѯ������ȫ����Ʒ
	public List<Shangpininfo> QueryAllsp();
	
	//ͨ����ƷID��ѯ��Ʒ��ϸ��Ϣ
	public Wareinfo QueryByID(String ware_id);
	
	//ͨ����ƷID��ѯ��Ʒ
	public Shangpininfo QueryshopByID(String sp_id);
	
	
	//��ѯȫ������Ʒ��ģ��������
	/**
	 * ���ưٶȵ�������ʽ
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	  public List<Shangpininfo> Multiplesearchone(String value) throws Exception;
	  
	  //�̼ҵ�ģ������
	  public List<Shop> Multiconditionalsearchone(String value);
	  
	  //��ѯ���е�ʡ
	  public List<Province> QueryAllProvinceone();
	 
	  //ͨ��ʡID��ѯ��
	  public List<City> QueryAllCitrByProvinceIDone(String provinceId);
	    
	  //ͨ���е�ID��ѯ���е���
	  public List<County> QueryCountyByCityId(String cityId);
	    
	  //ͨ�������ѯ�����ѯ���е�����(�������);
	  public List<Shop> QueryAllShopBypropert(String Dp_propert);
    
      //��¼��
	  public UserMassege adduser(UserMassege user);
	  
	  //��ѯȫ������
	  public List<Shop> QueryAllShopone();
	  
	  //�������ѯ���빺�ﳵ����Ʒ��
	  public List<Wareinfo> QueryWareone();
	  //����������ѯ��ƷZZ��״̬Ϊ"1"��ֵ��
	  public List<Shangpininfo> Querydeliverone();
	  //���ջ�����ѯ��ƷZZ��״̬Ϊ"2"��ֵ��
	  public List<Shangpininfo> Querygatherone();
}
