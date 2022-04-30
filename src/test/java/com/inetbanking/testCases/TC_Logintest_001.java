package com.inetbanking.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginpage;



public class TC_Logintest_001 extends BaseClass{
	private static final Logger logger = LogManager.getLogger(TC_Logintest_001.class);
	@Test
	public void LoginTest() {
		driver.get(baseURL);
		loginpage lp = new loginpage(driver);
		lp.setusername(username);
		logger.info("User name Entered");
		lp.setpassword(password);
		logger.info("Password entered");
		lp.clickonsignin();
		logger.info("clicked on sign in");
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}else {
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
		
	}
}
