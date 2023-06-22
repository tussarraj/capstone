package com.automationexercise.testcase;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pageObject.AccountCreatedPage;
import com.automationexercise.pageObject.AccountDeletedPage;
import com.automationexercise.pageObject.EnterAccountInformationPage;
import com.automationexercise.pageObject.LoggedHomePage;
import com.automationexercise.pageObject.LoginSignupPage;
import com.automationexercise.pageObject.RegisterUser;

public class TestCaseRegister01 extends BaseClass {

	String name = "raj29";
    String email = "raj29@yahoo.com";
	
	
    @Test
    public void registerUser()  throws IOException, ParseException{
       verifyThatHomePageIsVisibleSuccessfully();
       verifyNewUserSignupIsVisible();
       verifyThatEnterAccountInformationIsVisible();
       verifyThatAccountCreatedIsVisible();
       verifyThatLoggedInAsUsernameIsVisible();
       verifyThatAccountDeletedIsVisibleAndClickContinueButton();

    }
   
    public static void verifyThatHomePageIsVisibleSuccessfully() {
        boolean homePageVisible = new RegisterUser(getDriver()).homePageIsVisible().isDisplayed();
        Assert.assertTrue(homePageVisible, "Verify that home page is visible successfully");
    }
    public static void verifyNewUserSignupIsVisible() {
        String newUserSignupText = new RegisterUser(getDriver()).signupLoginClick().getNewUserSignup().getText();
        Assert.assertEquals(newUserSignupText, "New User Signup!", "Verify 'New User Signup!' is visible");
    }
    
    
    private void verifyThatEnterAccountInformationIsVisible() {
        String enterAccountInformationText = new LoginSignupPage(getDriver()).fillCorrectSignup(name, email).getEnterAccountInformation().getText();
        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }

    
    private void verifyThatAccountCreatedIsVisible() throws IOException, ParseException {
        String accountCreatedText = new EnterAccountInformationPage(getDriver()).fillAccountDetails().getAccountCreated().getText();
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify that 'ACCOUNT CREATED!' is visible");
    }
    
   
    private void verifyThatLoggedInAsUsernameIsVisible() {
        String username = new AccountCreatedPage(getDriver()).continueButtonClick().getUsername().getText();
        //Assert.assertEquals(username, "Verify that 'Logged in as username' is visible");
    }

    
   public static void verifyThatAccountDeletedIsVisibleAndClickContinueButton() {
        String accountDeletedText = new LoggedHomePage(getDriver()).deleteAccountButtonClick().getAccountDeleted().getText();
        //Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");
        new AccountDeletedPage(getDriver()).continueButtonClick();
    }

}
