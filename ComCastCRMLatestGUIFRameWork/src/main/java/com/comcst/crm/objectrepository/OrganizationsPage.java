package com.comcst.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@title,'Create')]")
	private WebElement createOrgBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

}
