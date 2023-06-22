package com.automationexercise.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    
	
    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement accountCreated;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement continueButton;

    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAccountCreated() {
        return accountCreated;
    }

   public LoggedHomePage continueButtonClick() {
        continueButton.click();
        
        return new LoggedHomePage(driver);
        
        
    }
}

