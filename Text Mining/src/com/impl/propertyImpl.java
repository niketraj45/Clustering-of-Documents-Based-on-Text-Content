package com.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
public class propertyImpl {
private static String loadProperties;
private static Properties prop = new Properties();
private static InputStream input = null;


static{
	loadProperties();
}
	public static String getproperty(String propertyName){
		String propertydata = null;
		propertydata = prop.getProperty(propertyName);
		return propertydata;
	}
	public static void setproperty(String propertyName,String propertyValue){
		prop.setProperty(propertyName, propertyValue);
	}
	
	private static void loadProperties(){
		try{
			System.out.println(Constants.configFileName);
			input = new FileInputStream(new File(Constants.configFileName));
		if(input!=null){
			System.out.println(";;;;");
			prop.load(input);
		}
		else{
			System.out.println("Cannot Load the configuration file");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
