package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.inetbanking.utility.readconfig;

public class BaseClass {
	readconfig read = new readconfig();
public String baseURL =read.getapplicationURL();
public String username= read.getusername();
public String password=read.getpassword();
public static WebDriver driver;

@Parameters("browser")
@BeforeClass
public void setup(String br) {
	if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",read.getChromePath());
driver = new ChromeDriver();}else if(br.equals("firefox")) {
	System.setProperty("webdriver.gecko.driver",read.getFirefoxPath());
	driver = new FirefoxDriver();
	
}else if(br.equals("edge")) {
	System.setProperty("webdriver.edge.driver",read.getMSEdge());
	driver = new EdgeDriver();
}else {
	System.out.println("Driver not in box ");
}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(baseURL);
}

@AfterClass  
public void teardown() {
	driver.close();
}
public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}
}
