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
 * ���ϵĽӿ�
 * 
 * @author 22271
 *
 */
public interface SyuinfoDao {
	
    public Syuinfo findById(String stu_id);
    public Syuinfo insertSyu(Syuinfo stu);
    
    /**
     * �춹�ǵ���ɾ�Ĳ�
     * @param Userid
     * @return
     */
    public List<UserMassege> findAll();
    public UserMassege findByUserID(String Userid);
    public void upadateUser(String Userid);
    
    //���������ֶε�Insert�����
    public UserMassege InsertUser(UserMassege User);
    
    //��ѯ���еù�ע�ͷ�˿����
    public List<UserMassege> QueryConcernAndFans(String UserId);
    //��ѯ���е÷�˿����
    public List<FansAndconcern> QueryFansName(String UserId);
    //��ѯ���еù�ע����
    public List<FansAndconcern> QueryConceryName(String UserId);
    //���붩����ϸ��
    public Order_MX AddOrderMXTable(Order_MX od)throws Exception;
    //���붩��׷�ٱ�
  	public OrderZZ AddOrderOrderZZTable(OrderZZ od)throws Exception;
    //���붩����
  	public Orderinfo AddOrderTable(Orderinfo od)throws Exception;
  	//��ѯ���ﳵȫ����Ʒ
  	public List<Wareinfo> QueryAllWareinfo();
  	//��Ѷȫ����Ʒ
  	public List<Shangpininfo> QueryAllshangpin();
  	//ͨ�����ﳵ����ƷID��ѯID
  	public Wareinfo QueryWareByID(String ware_id);
  	//ͨ����ƷID��ѯ��Ʒ
  	public Shangpininfo QuerySpbySpID(String sp_id);
    //ģ����������
  	public List<Shangpininfo> Multiplesearch(String value);
  	//ģ�������̼�
  	public List<Shop> Multiconditionalsearchone(String value);
  	//��ѯ���е�ʡ
  	public List<Province> QueryAllProvince();
  	//ͨ��ʡID��ѯ���е���
  	public List<City> QueryAllCitrByProvinceID(String provinceId);
  	//ͨ���е�ID��ѯ���е���
  	public List<County> QueryAllcountyByCityId(String cityId);
  	//ͨ�����̵�������������ص��ֶ�
  	public List<Shop> QueryShopByPropert(String Dp_propert);
  	//¼��ü�д��
  	public UserMassege inputUser(UserMassege user);
  	//��ѯȫ����Ʒ
  	public List<Shop> QueryAllShop();
    //�������ѯ���빺�ﳵ����Ʒ��
    public List<Wareinfo> QueryWare();
    //����������ѯ��ƷZZ��״̬Ϊ"1"��ֵ��
    public List<Shangpininfo> Querydeliver();
    //���ջ�����ѯ��ƷZZ��״̬Ϊ"2"��ֵ��
    public List<Shangpininfo> Querygather();
}
