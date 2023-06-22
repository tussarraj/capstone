package com.automationexercise.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoggedHomePage {

    @FindBy(xpath = "//b[contains(.,raj12)]")
    private WebElement username;

    @FindBy(xpath = "//i[@class='fa fa-trash-o']")
    private WebElement deleteAccountButton;


    private WebDriver driver;

    public LoggedHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getUsername() {
        return username;
    }

    public AccountDeletedPage deleteAccountButtonClick() {
        deleteAccountButton.click();
        return new AccountDeletedPage(driver);
    }

}

