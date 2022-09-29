package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadConfig {

	Properties pro;

	public ReadConfig() { // constractor

		File src = new File("./Configuration/Config.properties");

		try {

			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); // at run time properties file will load maybe change to get fail so try catch
							// used
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getusername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getchromepath() {
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}

	public String getiepath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String getfirefoxpath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
