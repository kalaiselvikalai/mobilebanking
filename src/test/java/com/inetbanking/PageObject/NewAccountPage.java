package com.inetbanking.PageObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {
	WebDriver driver;
	public NewAccountPage(WebDriver driver2) {
		driver=driver2;
		PageFactory.initElements(driver2,this);
	}

	@FindBy(xpath="//a[contains(text(),'New Account')]")
	@CacheLookup
	WebElement NewAccount;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement costomerID;
	
	@FindBy(name="inideposit")
	@CacheLookup
	WebElement deposit;
	
	@FindBy(name="button2")
	@CacheLookup
	WebElement btn;
	
	@FindBy(xpath=" //p[contains(text(),'Account Generated Successfully!!!')]")
	@CacheLookup
	WebElement text;
	
	public void clickNewAccount() {
		NewAccount.click();
	}
	public void entercustomerID(String custid) {
		if(costomerID.isEnabled()) {
			costomerID.sendKeys(custid);
		}else {
			driver.navigate().refresh();
			NewAccount.click();
			costomerID.sendKeys(custid);
		}
		
	}
	public void EnterdepositAmount(String amount) {
		deposit.sendKeys(amount);
	}
	public void clickbtn() {
		btn.click();
	}
	public String gettext() {
		return text.getText();
	}
}

