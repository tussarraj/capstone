package com.automationexercise.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.automationexercise.testcase.BaseClass;



public class EnterAccountInformationPage extends BaseClass {

    @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")  
    private WebElement enterAccountInformation;

    @FindBy(id = "id_gender1")
    private WebElement titleMrCheckbox;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    private WebDriver driver;

    public EnterAccountInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getEnterAccountInformation() {
        return enterAccountInformation;
    }

    public AccountCreatedPage fillAccountDetails() {
        String password = "12345";
        titleMrCheckbox.click();
        passwordInput.sendKeys(password);
        
        Select days = new Select(daysSelect);
        days.selectByValue("11");  
        
        Select months = new Select(monthsSelect);
        months.selectByValue("5"); 
        
        Select years = new Select(yearsSelect);
        years.selectByValue("1901"); 
        
        // newsletterCheckbox.click();
         
        
        //specialOffersCheckbox.click();
      
        firstNameInput.sendKeys("John"); 
        lastNameInput.sendKeys("Doe"); 
        companyInput.sendKeys("Example Company"); 
        address1Input.sendKeys("123 Main Street"); 
        address2Input.sendKeys("Apt 4B"); 
        Select countrySelector = new Select(countrySelect);
        countrySelector.selectByIndex(0); 
        stateInput.sendKeys("California"); 
        cityInput.sendKeys("Los Angeles"); 
        
        BaseClass obj =new BaseClass();
        obj.scrollDown();
        
        zipcodeInput.sendKeys("90001"); 
        mobileNumberInput.sendKeys("1234567890"); 
        createAccountButton.click();
        return new AccountCreatedPage(driver);
    }
}

