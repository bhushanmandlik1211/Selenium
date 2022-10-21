package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registerdUserAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {

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

	@Test(dataProvider="LoginDataProvider")
	public void verifyLogin(String userEmail,String userPass,String expectedUsername) throws IOException
	{
		indexPage pg=new indexPage(driver);
		pg.clickOnSignIN();

		myAccount ac=new myAccount(driver);
		ac.enterRegisteremail(userEmail);
		ac.enterPassword(userPass);
		ac.sign_IN();

		registerdUserAccount registerdUser=new registerdUserAccount(driver);
		String username=registerdUser.getUsername();

		if(username.equals(expectedUsername))
		{
			logger.info("verfylogin--passed");
			Assert.assertTrue(true);
			registerdUser.signout();
		}
		else
		{
			logger.info("verfylogin--failed");
			captureScreenshot(driver,"verifyLogin");
			Assert.assertTrue(false);
		}
	}
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}
