package com.automationexercise.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountDeletedPage {

    @FindBy(css = "h2[data-qa='account-deleted']")                                         
    private WebElement accountDeleted;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement continueButton;

    private WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAccountDeleted() {
        return accountDeleted;
    }

    public RegisterUser continueButtonClick() {
        continueButton.click();
        return new RegisterUser(driver);
        
    }
}

