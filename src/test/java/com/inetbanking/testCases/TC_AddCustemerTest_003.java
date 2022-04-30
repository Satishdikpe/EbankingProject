package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.loginpage;


public class TC_AddCustemerTest_003 extends BaseClass {
	private static final Logger logger = LogManager.getLogger(TC_Logintest_001.class);
	@Test
	public void addNewCustemer() throws InterruptedException, IOException {
		loginpage lp = new loginpage(driver);
		lp.setusername(username);
		logger.info("Username Given");
		lp.setpassword(password);
		logger.info("password Given");
		lp.clickonsignin();
		logger.info("clicked on the login");
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Satish");
		addcust.custgender("male");
		addcust.custdob("10","15","1990");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("Pune");
		addcust.custstate("MH");
		addcust.custpinno("411052");
		addcust.custtelephoneno("90449473498");
		String email=randomString()+"@gmail.com";
		addcust.custemailid(email);
		//addcust.custpassword("abcdef");
		addcust.custsubmit();
		logger.info("Filled custemer details");
		Thread.sleep(3000);
//		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
//	if(res==true) {
//		Assert.assertTrue(true);
//	}else {
//		captureScreen(driver,"addNewCustomer");
//		Assert.assertTrue(false);
//	}
	}
	public String randomString() {
	 return RandomStringUtils.randomAlphabetic(8);
	}
}
