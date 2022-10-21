package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {
	
	WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="id_gender1")
	WebElement mrTitle;
	
	@FindBy(id="id_gender2")
	WebElement mrsTitle;
	
	@FindBy(id="customer_firstname")
	WebElement customerFirstname;
	
	@FindBy(id="customer_lastname")
	WebElement customerLastname;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="firstname")
	WebElement addFirstname;
	
	@FindBy(id="lastname")
	WebElement addLastname;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postalcode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone_mobile")
	WebElement phoneNumber;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	
	
	public void selectMr_Title()
	{
		mrTitle.click();
	}
	
	public void selectMrs_Title()
	{
		mrsTitle.click();
	}
	
	public void enterCustomerFirstName(String fname)
	{
		customerFirstname.sendKeys(fname);
	}
	
	public void enterCustomerLastName(String lname)
	{
		customerLastname.sendKeys(lname);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void enterAddressFirstName(String fname) 
	{
		addFirstname.clear();
		addFirstname.sendKeys(fname);
	}
	
	public void enterAddressLastName(String lname)
	{
		addLastname.clear();
		addLastname.sendKeys(lname);
	}
	
	public void enterAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void selectCity(String scity)
	{
		city.sendKeys(scity);
	}
	
	public void selectState(String text )
	{
		Select s=new Select(state);
		s.selectByVisibleText(text);
	}
	
	public void enterPostalcode(String code)
	{
		postalcode.sendKeys(code);
	}
	
	public void selectCountry(String text )
	{
		Select s1=new Select(country);
		s1.selectByVisibleText(text);
	}
	
	public void enterMobilenumber(String number)
	{
		phoneNumber.sendKeys(number);
	}
	
	public void enterAlias(String text)
	{
		alias.clear();
		alias.sendKeys(text);
	}
	
	public void clickOnregister()
	{
		register.click();
	}
}
