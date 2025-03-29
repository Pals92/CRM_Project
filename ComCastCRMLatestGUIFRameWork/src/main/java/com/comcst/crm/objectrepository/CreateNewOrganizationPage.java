package com.comcst.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTF;
		
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTF;
	
	@FindBy(css = "input[accesskey=\"S\"]")
	private WebElement saveBtn;
}
