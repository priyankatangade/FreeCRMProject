package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	public HomePageTest(){
		super();
	}
 @BeforeMethod
 public void setUp(){
	 initialization();
	 testUtil=new TestUtil();
	 loginPage=new LoginPage();
	 contactPage=new ContactsPage();
	 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 }
 
 @Test(priority=1)
 public void verifyHomePageTitle(){
	String homePageTitle= homePage.verifyHomePageTitle();
	Assert.assertEquals("CRMPRO", homePageTitle," Home Page Title Not Match");
 }
 
 @Test(priority=2)
 public void verifyUserNameTest(){
	 testUtil.switchToFrame();
	 Assert.assertTrue(homePage.verifyCorrectUserName());
 }
 @Test(priority=3)
 public void verifyContactLinkTest(){
	 testUtil.switchToFrame();
	 contactPage=homePage.clickOnContactLink();
	 
	 
 }
 @AfterMethod
 public void teraDown(){
	 driver.quit();
 }
}
