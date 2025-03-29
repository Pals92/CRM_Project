package com.comcst.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement signOutIMG;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Organizations']")
	private WebElement organizationsLink;

	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Contacts']")
	private WebElement contactsLink;

	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Products']")
	private WebElement productsLink;

	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Leads']")
	private WebElement leadsLink;


	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSignOutIMG() {
		return signOutIMG;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	
	public void signOut() {
		signOutIMG.click();
		signOutLink.click();
	}





}


