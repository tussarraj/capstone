package com.automationexercise.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pageObject.ProductDetailPage;
import com.automationexercise.pageObject.ProductsPage;
import com.automationexercise.pageObject.RegisterUser;

import java.io.IOException;
import java.text.ParseException;

public class TestCaseAddReview06 extends BaseClass {

    @Test
    public void addReviewOnProduct() throws IOException, ParseException {
    	
        verifyUserIsNavigatedToAllProductsPageSuccessfully();
        verifyWriteYourReviewIsVisible();
        verifySuccessMessageThankYouForYourReview();
    }
    
    
    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
        String allProductsText = new RegisterUser(getDriver()).productsButtonClick().getTitleTextCenter().getText();

        if (allProductsText.equals("ALL PRODUCTS")) {
            System.out.println("User is navigated to ALL PRODUCTS page successfully");
        } else {
            System.out.println("User is not navigated to ALL PRODUCTS page");
        }
    }

    
   private void verifyWriteYourReviewIsVisible() {
        String writeYourReviewText = new ProductsPage(getDriver()).viewProductOfFirstProductButtonClick().getWriteYourReview().getText();
        Assert.assertEquals(writeYourReviewText, "WRITE YOUR REVIEW", "Verify 'Write Your Review' is visible");
    }

    
    private void verifySuccessMessageThankYouForYourReview() throws IOException, ParseException {
        String successMessageText = new ProductDetailPage(getDriver()).fillReview().getSuccessMessage().getText();
        
        if (successMessageText.equals("Thank you for your review.")) {
            System.out.println("Verification Passed: Success message is 'Thank you for your review.'");
        } else {
            System.out.println("Verification Failed: Success message is not 'Thank you for your review.'");
        }
    }
}
