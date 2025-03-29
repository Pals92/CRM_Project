package com.crmVTiger.moduleTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcst.crm.generic.baseClassUtility.BaseClass;
import com.comcst.crm.objectrepository.CreateNewOrganizationPage;
import com.comcst.crm.objectrepository.HomePage;
import com.comcst.crm.objectrepository.OrganizationsPage;

@Listeners(com.comcst.crm.generic.listenerutility.ListenerImplementaionClass.class)
public class CreateOrgTest extends BaseClass {
	
	@Test(groups="smokeTest")
	public void createOrgNameTest() {
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		// Lets Create New Organization
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		
		//let's fill all the details
		
		CreateNewOrganizationPage newOrgPage = new CreateNewOrganizationPage(driver);
		newOrgPage.getOrgNameTF().sendKeys("hiiiiiii");
		newOrgPage.getIndustryDropDown().click();
		wbLib.selectByValue(newOrgPage.getIndustryDropDown(), "Banking");
		newOrgPage.getOrgNameTF().sendKeys("");
		newOrgPage.getTypeDropDown().sendKeys("sdjhfjshf");
		Assert.assertEquals(false, true);
		
		
		
	}
	

}
