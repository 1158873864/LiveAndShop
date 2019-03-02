package com.it.Until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Timeunit {
     public  static  final DateFormat  fmt=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	
	 public static String getnowtime(){
		 Date date=new Date();
		  return fmt.format(date);
		 
	 }
	
}
