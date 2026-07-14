package org.Test;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.POMrepository.CellPhonePage;
import org.GenricLibary.BaseTest;
import org.POMrepository.BAsePage;
import org.POMrepository.ElectronicsPage;
import org.POMrepository.ShoppingCartPage;



@Listeners(org.GenricLibary.MyListener.class)
public class TC_RemoveProductFromCart_003_Test extends BaseTest
{
	@Test
	public void removeproduct() throws InterruptedException
	{
		BAsePage wp = new BAsePage(driver);
		wp.getElectronicLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		
		CellPhonePage clph = new CellPhonePage(driver);
		clph.getAddtoCartButton().click();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(clph.getProductaddedtocart().isDisplayed(), true, "Rpoduct added to cart");
		
		wp.getSoppingCart().click();
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		scp.removeSmartPhonefromcart();
		
		try
		{
			if(scp.getSmartphonecartItem().isDisplayed())
			{
				Reporter.log("Product is not removed from cart!");
			}
		}
		catch(Exception e)
		{
			Reporter.log("Product is removed from cart!");
		}
	}

}
