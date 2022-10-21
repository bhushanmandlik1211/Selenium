package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerdUserAccount {
	
	WebDriver ldriver;
	
	public registerdUserAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement userName;
	
	@FindBy(linkText="Sign out")
	WebElement signOut;
	
	@FindBy(name ="search_query")
	WebElement searchBox;

	@FindBy(name ="submit_search")
	WebElement submit_search;

	@FindBy(linkText = "Women")
	WebElement WomenMenu;

	@FindBy(linkText="T-shirts")
	WebElement TShirtMenu;
	
	public String getUsername()
	{
		String user=userName.getText();
		return user;
		
	}

	public void signout() {
		signOut.click();
		
	}
	
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}


	
	public void MouseOverTShirtMenu()
	{
		Actions actions=new Actions(ldriver);
		actions.moveToElement(WomenMenu).moveToElement(TShirtMenu).click().perform();
	}

	public void ClickOnSearchButton() {
		submit_search.click();
		
	}
	

}
