package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest {

	@Test (groups = {"ErrorHandling"}, retryAnalyzer = rahulshettyacademy.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("debashr@gmail.com", "Ayesha@14");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());	

	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("dutta@abc.com", "Ayesha@14");

		List<WebElement> products = productCatalogue.getProductList();

		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);


	}

}
