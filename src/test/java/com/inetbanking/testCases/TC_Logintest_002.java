package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginpage;
import com.inetbanking.utility.XLUtils;

public class TC_Logintest_002 extends BaseClass{
	
	private static final Logger logger = LogManager.getLogger(TC_Logintest_002.class);
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pass) {
		
	loginpage lp = new loginpage(driver);
	lp.setusername(user);
	logger.info("User Name Entered ");
	lp.setpassword(pass);
	logger.info("Password Entered ");
	lp.clickonsignin();
	logger.info("clicked on loginbutton  ");
	if(isalertPrasent()==true) {
		driver.switchTo().alert().accept();
		logger.info("Login Failed");
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		
		
	}else {
		
		logger.info("Login passesd");
		lp.clicklogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
	}
}
	
	public boolean isalertPrasent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException{
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Logindata.xlsx";
	int rowcount = XLUtils.getRowCount(path, "Sheet1");
	int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	String LoginData[][]=new String[rowcount][colcount];
	for (int i = 1; i < rowcount; i++) {
		for (int j = 0; j < colcount; j++) {
			LoginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
		}
	}
	return LoginData;
	}
}
