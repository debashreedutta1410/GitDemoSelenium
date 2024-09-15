
@tag
Feature: Purchase the order from e-commerce website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page

 @Regression
  Scenario Outline: Positive Test for submitting order
    Given I logged in with username <name> and password <password>
    When I add the product <productName> to cart
    And checkout <productName> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed in ConfirmationPage

    Examples: 
      | name  				| 	password 			|	productName
      | dutta@abc.com |		Ayesha@14			|	ADIDAS ORIGINAL
