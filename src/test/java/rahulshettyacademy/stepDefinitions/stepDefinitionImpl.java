package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class stepDefinitionImpl extends BaseTest{

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException

		{
		landingPage = launchApplication();
		}
	
	@Given("^I logged in with username (.+) and password (.+)$")
	public void I_logged_in_with_username_and_password(String username, String password)
	{
		 productCatalogue = landingPage.loginApplication(username,password);
	}
	@When("^I add the product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	@When("^checkout (.+) and submit order$")
	public void checkout_and_submit_order(String productName)
	{
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	@Then("{string} message is displayed in ConfirmationPage")
	public void messag_is_displayed_ConfirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then ("{string} message is displayed")
	public void message_is_displayed(String stringArg)
	{
		Assert.assertEquals(stringArg, landingPage.getErrorMessage());	
		driver.close();
	}
}


