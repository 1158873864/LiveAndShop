package com.it.shoppingservlet;

import java.util.List;

import com.it.bean.Shangpininfo;



public class Car {
	//��ϸ���ǰ�������Ʒ��������Ȼ���װ�ã����൱�ڰѴ���õ���ϸ���빺�ﳵ�����ﳵ���൱��һ������
	
	@SuppressWarnings("unused")
	private static final List<Fengzhuanglei> list1 = null;
	private List<Fengzhuanglei> car;

	
	public List<Fengzhuanglei> getCar() {
		return car;
	}

	public void setCar(List<Fengzhuanglei> car) {
		this.car = car;
	}

	public Car(List<Fengzhuanglei> car) {
		super();
		this.car = car;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void remove(String sp_id){
		for(Fengzhuanglei it:car){
			if(it.getWare().getSp_id().equals(sp_id)){
				car.remove(it);
                 return;

			}
			
		}
		
	}
	
	
	//------------------------------------------

	public void clean(){
		car.clear();
	}
	
	
	
	//��������д����Ʒ���빺�ﳵ�İ취�ˣ�����
	  public void addcarsp(Shangpininfo ware,String ct){
	//�жϹ��ﳵ��û����Ʒ
		for(Fengzhuanglei it:car){
			if(it.getWare().getSp_id().equals(ware.getSp_id())){
				String sum=(Integer.parseInt(it.getShuliang())+Integer.parseInt(ct))+"";
               it.setShuliang(sum);
               return;

			}
			
		}
		 //���û������һ����֤�����ﳵû�������Ʒ 
	
		car.add(new  Fengzhuanglei(ware,ct));
	  }
	
	
	  
	  public  void clearSelectedGoods(String []goods){
	    	for(int i=0;i<car.size();i++){
				for(int j=0;j<goods.length;j++){
	               if(car.get(i).getWare().getSp_id().equals(goods[j])){
	            	   car.remove(i);
	               }		
				}
			}
	    }
	  
	  
	  
	  
	  
	  
	  
	
}
