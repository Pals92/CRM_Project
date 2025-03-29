package com.comcst.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement userNameTF;
	
	@FindBy(name="user_password")
	private WebElement passWordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	public WebDriver getDriver() {
		return driver;
	}

	
	// ====================Object Initialization========================

	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPassWordTF() {
		return passWordTF;
	}

	public WebElement getSubmitBtn() {
		return loginBtn;
	}
	
	
	public void loginToApp(String user_name, String passWord) {
		userNameTF.sendKeys(user_name);
		passWordTF.sendKeys(passWord);
		loginBtn.click();
		
	}
	
}
