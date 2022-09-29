package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver driver;
	
	public  EditCustomerPage(WebDriver tdriver) {
		
		driver=tdriver;
		
		PageFactory.initElements(tdriver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	@CacheLookup
	WebElement EditCustomer;
	
	@FindBy(xpath="//tbody/tr[6]/td[2]/input[1]")
	@CacheLookup
	WebElement CustomerID;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement Submit;
	
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement editSumit;
	
	public void ClickEditCustomer() {
		EditCustomer.click();
}
	public void EnterCusID(String cusid) throws InterruptedException {
		if(CustomerID.isEnabled()) {
		CustomerID.sendKeys(cusid);
		}else {driver.navigate().refresh();
		Thread.sleep(500);
		EditCustomer.click();
			}
		}
	public void ClickeditSumit() {
		Submit.click();
	}
	public void editCity(String city) {
		txtcity.clear();
		txtcity.sendKeys(city);
	}
	public void editsumit() {
		editSumit.click();
		
	} 
	}
