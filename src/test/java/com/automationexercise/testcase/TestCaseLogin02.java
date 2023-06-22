package com.automationexercise.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pageObject.LoginSignupPage;
import com.automationexercise.pageObject.RegisterUser;

import java.io.IOException;
import java.text.ParseException;


public class TestCaseLogin02 extends BaseClass {

    @Test
    public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
        TestCaseRegister01.verifyThatHomePageIsVisibleSuccessfully();
        verifyLoginToYourAccountIsVisible();
        verifyThatLoggedInAsUsernameIsVisible();
    }

    
    public static void verifyLoginToYourAccountIsVisible() {
        String loginToYourAccountText = new RegisterUser(getDriver()).signupLoginClick().getLoginToYourAccount().getText();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify 'Login to your account' is visible");
    }

    
    public static void verifyThatLoggedInAsUsernameIsVisible() throws IOException, ParseException {
        String username = new LoginSignupPage(getDriver()).fillCorrectLogin("raj4@yahoo.com","12345").getUsername().getText();
        Assert.assertEquals(username, "raj4", "Verify that 'Logged in as username' is visible");
    }
}
