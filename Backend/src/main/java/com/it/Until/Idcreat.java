package com.it.Until;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Idcreat {
	
	public static String getsubstring(String name){
		System.out.println("我是工具类得字符转换");
		String ext=""; 
		int index=name.lastIndexOf(".");
		if(index!=-1){
			ext=name.substring(index);
			
		}
		return ext;
	 }
	
	
	public static String gettp_id(){
		return UUID.randomUUID()+"";
	
	} 
	
	
     public static String getod_id(String Userid){
    	 return Userid+"-"+UUID.randomUUID();
     }
     
	 public static String  getmx_id(String od_id){
		return od_id+""+UUID.randomUUID(); 
		
	 }
	 public static String getOdZZId(String od_id){
			return od_id+"-"+(int)(100000*Math.random());
		}
	 
	 
	
}
