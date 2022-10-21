package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path="C:\\Learnings\\MyStoreV1\\Configuration\\config.properties";
	public ReadConfig()
	{
		properties=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseURL()
	{
		String value=properties.getProperty("baseURL");
		
		if(value!=null)
			return value;
		else

			throw new RuntimeException("url not specified in config file.");
	}
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");
	}
	
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		
	}

	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}

}
