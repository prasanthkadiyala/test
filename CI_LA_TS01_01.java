/* 
 * Project    : Catalyst Insight
 * Module Name: LookUpAdmin
 * Script     : CI_LA_TS01_01
 * Author     : Aravind
 * Date       : 7.5.2014
 * Description: User should be able to navigate to lookup admin page
 */
package com.prakat.lookupadmin;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.prakat.admin.LookUpAdmin;
import com.prakat.genericutility.BaseClass;
import com.prakat.genericutility.BusinessUtil;
import com.prakat.genericutility.ButtonHelper;
import com.prakat.pages.CataHomePage;
import com.prakat.pages.CatalystAdminModule;
import com.prakat.pages.LookUpPage;

public class CI_LA_TS01_01 extends LookUpAdmin {

	static CataHomePage homePage = null;
	static CatalystAdminModule adminModule = null;
	static LookUpPage lookUpPage = null;

	@Test
	public static void navigateToLookAdmin() throws Exception {
		BaseClass.test = BaseClass.extent.createTest("navigate to lookup admin");
		try {

			BusinessUtil.login("");// Login to application with valid username and password
			BaseClass.test.log(Status.INFO, MarkupHelper.createLabel("Successfully logged in", ExtentColor.BLUE));

			CataHomePage homePage = new CataHomePage(driver);
			adminModule = homePage.clickAdminButton();

			BaseClass.test.log(Status.INFO, MarkupHelper.createLabel("Navigated to Admin module", ExtentColor.BLUE));
			adminModule.clickLookUpAdmin();

			BaseClass.test.log(Status.INFO, MarkupHelper.createLabel("Navigated to lookup admin", ExtentColor.BLUE));

			lookUpPage = new LookUpPage(driver);
			Boolean addlookup = ButtonHelper.isButtonPresent(lookUpPage.getAddLookUpButton());

			Assert.assertTrue(addlookup, "Create Lookup button is not present");
			Boolean addlookupvalue = ButtonHelper.isButtonPresent(lookUpPage.getAddLookUpValueButton(),
					"Add lookup values");
			Assert.assertTrue(addlookupvalue, "Add lookup values button is not present");
			Boolean deleteselectedlookupvalue = ButtonHelper.isButtonPresent(lookUpPage.getdeleteselectedlookupvalue());

			Assert.assertTrue(deleteselectedlookupvalue, "Delete selected lookup values button is not present");
			BaseClass.test.log(Status.INFO,
					MarkupHelper.createLabel(
							"User is able to navigate to lookup admin and all the lookups buttons are present",
							ExtentColor.BLUE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
