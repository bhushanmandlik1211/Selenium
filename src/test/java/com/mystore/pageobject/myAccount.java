package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	
	WebDriver ldriver;
	
	public myAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="email_create")
	WebElement enterEmail;
	
	@FindBy(xpath="//*[@id=\"SubmitCreate\"]/span")
	WebElement clickOnSubmit;
	
	//already register user
	
	@FindBy(id="email")
	WebElement enterRegisteremail;
	
	@FindBy(id="passwd")
	WebElement enterPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement clickonLogin;

	//create new user
	public void enterEmail(String email)
	{
		enterEmail.sendKeys(email);
	}
	
	public void clickOnSubmit()
	{
		clickOnSubmit.click();
	}
	
	//login 
	
	public void enterRegisteremail(String regmail)
	{
		enterRegisteremail.sendKeys(regmail);
	}
	
	public void enterPassword(String pass)
	{
		enterPassword.sendKeys(pass);
	}
	

	public void sign_IN() {
		clickonLogin.click();
		
		
	}
}
