package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	String baseURL=readconfig.getBaseURL();
	String browser=readconfig.getBrowser();
	
	public String emailAddress = readconfig.getEmail();
	String password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	@BeforeClass
	public void setup()
	{
		//launch browser
				switch(browser.toLowerCase())
				{
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

				case "msedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					driver = null;
					break;

				}

				//implicit wait of 10 secs
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				//for logging
				logger = LogManager.getLogger("MyStoreV1");
				
				//open url
				driver.get(baseURL);
				logger.info("url opened");
				
	}
	@AfterClass
	public void tearDown()
	{
		
		driver.close();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String testname) throws IOException
	{
		//convert webdriver object to takesscreenshot interface
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		
		//call getscreenshotAs method to create img file
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+testname+".png");
		
		//copy img file to destination
		FileUtils.copyFile(src, dest);
		
	}

}
