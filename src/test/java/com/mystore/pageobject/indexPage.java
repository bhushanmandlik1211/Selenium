package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	//1.create object of webdriver
	public static WebDriver ldriver;
	
	//2.create constructor
	public indexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//3.identify web elemnts
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	WebElement tshirtMenu;
	
	//4.action on webelement
	
	public void clickOnSignIN()
	{
		SignIn.click();
		
	}
	
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
	
	public void clickOnTShirtMenu()
	{
		tshirtMenu.click();
	}

}
