package com.inetbanking.TestCases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.inetbanking.Utilities.ReadConfig;


@Parameters("browser")
public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
 
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	
	public static final String filePath = "C:\\Users\\Admin\\eclipse-workspace\\inetbankingV1\\src\\test\\java\\com\\inetbaning\\TestData\\Keyword.xlsx"; 
	public static final String excelData = "Keyword.xlsx";
	
	/*public String baseURL="https://demo.guru99.com/v4/";
	public String username="mngr432678";
	public String password="UtabAry";
	public static WebDriver driver;*/
	

	 
 public  static Logger log;

@Parameters("browser")
 @BeforeClass
 public  void setup(String br) throws InterruptedException {

	 log=Logger.getLogger(BaseClass.class);
	PropertyConfigurator.configure("log4j.properties");
	
	if (br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		driver= new ChromeDriver();
	}
	else if (br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
		driver= new FirefoxDriver();
	}
	else if (br.equals("ie")) {
		System.setProperty("webdriver.ie.driver",readconfig.getiepath());
		driver= new InternetExplorerDriver();
	}
	

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get(baseURL);
	
}


/*public void setup() {
	
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+readconfig.getchromepath());
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	driver= new ChromeDriver();
	
	 log=Logger.getLogger(BaseClass.class);
	PropertyConfigurator.configure("log4j.properties");
	
  }*/

public void  CaptureScreen(WebDriver driver,String tname) throws IOException {
TakesScreenshot ts=(TakesScreenshot)driver;
File source= ts.getScreenshotAs(OutputType.FILE);
File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
FileUtils.copyFile(source, target);
System.out.println("Screenshot taken");

}



public String randomstring() {

String generatedstring=RandomStringUtils.randomAlphabetic(5);
return( generatedstring);
}

public String randomnum() {
String generatedstring1=RandomStringUtils.randomNumeric(4);
return (generatedstring1);}

		

@AfterClass
public void teardown() {
	driver.quit();
}







}
