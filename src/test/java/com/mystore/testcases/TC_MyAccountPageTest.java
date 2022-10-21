package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registerdUserAccount;

public class TC_MyAccountPageTest extends BaseClass {

	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{


		indexPage pg=new indexPage(driver);
		pg.clickOnSignIN();

		myAccount ac=new myAccount(driver);
		ac.enterEmail("bhushan1211@gmail.com");
		ac.clickOnSubmit();

		accountCreationDetails accountCreationpg=new accountCreationDetails(driver);

		accountCreationpg.selectMr_Title();
		accountCreationpg.enterCustomerFirstName("Bhushan");
		accountCreationpg.enterCustomerLastName("Mandlik");
		accountCreationpg.enterPassword("bhushan1211");

		accountCreationpg.enterAddressFirstName("Bhushan");
		accountCreationpg.enterAddressLastName("Mandlik");
		accountCreationpg.enterAddress("junnar");
		accountCreationpg.selectCity("pune");
		accountCreationpg.selectState("Alabama");
		accountCreationpg.enterPostalcode("12345");
		accountCreationpg.selectCountry("United States");

		accountCreationpg.enterMobilenumber("9872625535");
		accountCreationpg.enterAlias("home");

		accountCreationpg.clickOnregister();

		registerdUserAccount registerdUser=new registerdUserAccount(driver);
		String username=registerdUser.getUsername();

		assertEquals("Bhushan Mandlik", username);
	}

	@Test
	public void verifyLogin() throws IOException
	{
		indexPage pg=new indexPage(driver);
		pg.clickOnSignIN();

		myAccount ac=new myAccount(driver);
		ac.enterRegisteremail("bhushan1211@gmail.com");
		ac.enterPassword("bhushan1211");
		ac.sign_IN();

		registerdUserAccount registerdUser=new registerdUserAccount(driver);
		String username=registerdUser.getUsername();

		if(username.equals("Bhushan Mandlik"))
		{
			logger.info("verfylogin--passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verfylogin--failed");
			captureScreenshot(driver,"verifyLogin");
			Assert.assertTrue(false);
		}
	}
	@Test
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIN();;
		logger.info("Clicked on sign in link");

		myAccount myAcpg = new myAccount(driver);

		myAcpg.enterRegisteremail("bhushan1211@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterPassword("bhushan1211");
		logger.info("Entered password");

		myAcpg.sign_IN();;
		logger.info("Clicked on sign in link..");


		registerdUserAccount regUser = new registerdUserAccount(driver);
		regUser.signout();

		if(pg.getPageTitle().equals("Login - My Store"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenshot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}


}
