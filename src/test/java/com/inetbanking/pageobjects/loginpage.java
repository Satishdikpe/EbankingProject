package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
WebDriver idrive;
public loginpage(WebDriver rdriver){
	idrive=rdriver;
	PageFactory.initElements(rdriver, this);
}
@FindBy(name="uid")
WebElement textusername;

@FindBy(name="password")
WebElement txtpassword;

@FindBy(name="btnLogin")
WebElement lgnbutton;

@FindBy(xpath="//a[text()='Log out']")
WebElement logoutbutton;

public void setusername(String uname) {
	textusername.sendKeys(uname);
}
public void setpassword(String pwd) {
	txtpassword.sendKeys(pwd);
}
public void clickonsignin() {
	lgnbutton.click();
}
public void clicklogout() {
	logoutbutton.click();
}
}
