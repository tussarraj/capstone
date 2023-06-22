package com.automationexercise.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.testcase.BaseClass;

import utils.SeleniumHelper;

import java.io.IOException;
import java.text.ParseException;

public class ProductDetailPage {


    @FindBy(css = "button[class='btn btn-default cart']")
    private WebElement addToCartButton;

    @FindBy(css = "a[href='/view_cart'] u")
    private WebElement viewCartButton;

    @FindBy(css = "a[href='#reviews']")
    private WebElement writeYourReview;

    @FindBy(id = "name")
    private WebElement yourNameInput;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "review")
    private WebElement addReviewHere;

    @FindBy(id="button-review")
    private WebElement submitButton;

    @FindBy(css ="div[class='alert-success alert'] span")
    private WebElement successMessage;

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public ProductDetailPage addToCartButtonClick() {
        addToCartButton.click();
        return this;
    }

    public CartPage viewCartButtonClick() {
        SeleniumHelper.waitForElementToBeClickable(driver, viewCartButton);
        viewCartButton.click();
        return new CartPage(driver);
    }

    public WebElement getWriteYourReview() {
        return writeYourReview;
    }

    public ProductDetailPage fillReview() throws IOException, ParseException {
    	
        yourNameInput.sendKeys("name");
        emailAddress.sendKeys("email@email.com");
        addReviewHere.sendKeys("Nice");
        
        BaseClass obj =new BaseClass();
        obj.scrollDown();
        submitButton.click();
        return this;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }
}
