package org.Test;

import org.GenricLibary.BaseTest;
import org.GenricLibary.Flib;
import org.POMrepository.BAsePage;
import org.POMrepository.CellPhonePage;
import org.POMrepository.ElectronicsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_AddToCart_001_Test extends BaseTest {

	@Test
	public void addTocart()
	{
		BAsePage basePage = new BAsePage(driver);
		basePage.getElectronicLink().click();
		
		ElectronicsPage elec = new ElectronicsPage(driver);
		elec.getCellPhoneLink().click();
		CellPhonePage cellPhone = new CellPhonePage(driver);
		cellPhone.getAddtoCartButton().click();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(cellPhone.getProductaddedtocart().isDisplayed(), true, "Rpoduct added to cart");
		
		sa.assertAll();
	
		
	}

}  
