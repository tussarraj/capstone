package com.automationexercise.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pageObject.LoginSignupPage;

public class TestCaseIncorrectLogin03 extends BaseClass {

    @Test
    public void loginUserWithIncorrectEmailAndPassword() {
        TestCaseRegister01.verifyThatHomePageIsVisibleSuccessfully();
        TestCaseLogin02.verifyLoginToYourAccountIsVisible();
        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();
    }

    
    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        String email = "raj1@yahoo.com";
        String password = "1234";

        String errorLoginText = new LoginSignupPage(getDriver()).fillIncorrectLogin(email, password).getErrorLogin().getText();
        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "Verify error 'Your email or password is incorrect!' is visible");
    }
}
