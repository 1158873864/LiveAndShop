package com.it.shoppingservlet;

import java.util.List;

import com.it.bean.Shangpininfo;



public class Car {
	//明细就是包含了物品和数量，然后封装好，就相当于把打包好的明细刚入购物车，购物车就相当于一个集合
	
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
	
	
	
	//接下来就写把商品加入购物车的办法了，依赖
	  public void addcarsp(Shangpininfo ware,String ct){
	//判断购物车有没有商品
		for(Fengzhuanglei it:car){
			if(it.getWare().getSp_id().equals(ware.getSp_id())){
				String sum=(Integer.parseInt(it.getShuliang())+Integer.parseInt(ct))+"";
               it.setShuliang(sum);
               return;

			}
			
		}
		 //如果没有走上一步，证明购物车没有这个物品 
	
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
