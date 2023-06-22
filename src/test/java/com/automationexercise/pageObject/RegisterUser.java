package com.automationexercise.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelper;


public class RegisterUser {
	static WebDriver driver;
	
	public RegisterUser(WebDriver driver) {
		RegisterUser.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	  @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
	    private WebElement home;

	    @FindBy(css = "a[href='/login']")
	    private WebElement signupLoginButton;
	    

	    @FindBy(xpath = "//a[@href='/products']" )                        
	    private WebElement productsButton;
	    
	    public ProductsPage productsButtonClick()  {
	    	
	        productsButton.click();
	        
	        return new ProductsPage(driver);
	    }
	    
	    @FindBy(css = "a[href='/view_cart']")
	    private WebElement cartButton;

	    @FindBy(css = "a[href='/product_details/1']")
	    private WebElement viewProduct1Button;

	    @FindBy(css = "div[class='modal-content'] a[href='/view_cart']")
	    private WebElement viewCartButton;

	    @FindBy(id = "scrollUp")
	    private WebElement scrollUpButton;


	    public WebElement homePageIsVisible() {
	        return home;
	    }

	    public LoginSignupPage signupLoginClick() {
	        signupLoginButton.click();
	        
	        return new LoginSignupPage(driver);
	    }

	   

	    public CartPage cartButtonClick() {
	        cartButton.click();
	        return new CartPage(driver);
	    }

	    public ProductDetailPage viewProduct1ButtonClick() {
	        SeleniumHelper.waitForElementToBeClickable(driver, viewProduct1Button);
	        viewProduct1Button.click();
	        return new ProductDetailPage(driver);
	    }



	    public CartPage viewCartButtonClick() {
	        SeleniumHelper.waitForElementToBeVisible(driver, viewCartButton);
	        viewCartButton.click();
	        return new CartPage(driver);
	    }

	    public RegisterUser scrollUpButtonClick() {
	        scrollUpButton.click();
	        return this;
	    }



}
