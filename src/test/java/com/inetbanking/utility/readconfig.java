package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {
Properties prop;

	public readconfig() {
		File scr = new File("./Configuration/configue.properties");
		try {
		FileInputStream fis = new FileInputStream(scr);
		prop = new Properties();
		prop.load(fis);} catch(Exception e) {
			System.out.println("Execution is : - "+e.getMessage());
		}
		
	}
	public String getapplicationURL() {
		return prop.getProperty("baseURL");
	}
	public String getusername() {
		return prop.getProperty("username");
	}
	public String getpassword() {
		return prop.getProperty("password");
	}
	public String getChromePath()
	{
	String chromepath=prop.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=prop.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=prop.getProperty("firefoxpath");
	return firefoxpath;
	}
	public String getMSEdge()
	{
	String edgepath=prop.getProperty("edge");
	return edgepath;
	}
	
	
}
