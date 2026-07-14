package org.Test;

import java.io.IOException;

import org.GenricLibary.BaseTest;
import org.GenricLibary.Flib;
import org.POMrepository.BAsePage;
import org.POMrepository.CellPhonePage;
import org.POMrepository.Checkout;
import org.POMrepository.ElectronicsPage;
import org.POMrepository.ShoppingCartPage;
import org.POMrepository.Success;
import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(org.GenricLibary.MyListener.class)
public class TC_BuyProduct_002_Test extends BaseTest{
	
		private static final String CheckOutPage = null;

		@Test
		public void buyProductMeThod() throws EncryptedDocumentException, IOException
		{
			BAsePage basePage = new BAsePage(driver);
			basePage.getElectronicLink().click();
			
			ElectronicsPage ep = new ElectronicsPage(driver);
			ep.getCellPhoneLink().click();
			
			CellPhonePage clph = new CellPhonePage(driver);
			clph.getAddtoCartButton().click();
			
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(clph.getProductaddedtocart().isDisplayed(), true, "Rpoduct added to cart");
			
			basePage.getSoppingCart().click();
			
			ShoppingCartPage shp = new ShoppingCartPage(driver);
			shp.getSmartphonecartItem().click();
			shp.getTermsofservicesButton().click();
			shp.getCheckoutButton().click();
			
			String city = Flib.readCellValueFromExcel(excel_path_test,"Sheet1", 1, 0);
			String adress = Flib.readCellValueFromExcel(excel_path_test,"Sheet1", 1, 1);
			String pincode = Flib.readCellValueFromExcelinint(excel_path_test,"Sheet1", 1, 2);
			String contact = Flib.readCellValueFromExcelinint(excel_path_test,"Sheet1", 1, 3);
			
			System.out.println(city);
			System.out.println(adress);
			System.out.println(pincode);
			System.out.println(contact);
			
			int rn = Flib.generateRandonNo();
			String PhoneNo = contact+rn;
			System.out.println(PhoneNo);
			
			Checkout cop = new Checkout(driver);
			cop.buyproduct(city, adress, pincode, PhoneNo);
			
		     Success sp = new Success(driver);
			
			String actualtitle = sp.getSuccess().getText();
			sa.assertEquals(actualtitle, "Your order has been successfully processed!", "Prduct has been failed to process");
			
			sa.assertAll();
		}
	}


