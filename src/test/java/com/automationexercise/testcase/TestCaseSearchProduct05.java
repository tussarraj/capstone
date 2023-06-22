package com.automationexercise.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationexercise.pageObject.ProductsPage;
import com.automationexercise.pageObject.RegisterUser;
public class TestCaseSearchProduct05 extends BaseClass {

	static String search="dress";


    @Test
    public void searchProduct() {
        
    	TestCaseRegister01.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigatedToAllProductsPageSuccessfully();
        verifySearchedProductsIsVisible();
        
        
    }
    
    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
        String allProductsText = new RegisterUser(getDriver()).productsButtonClick().getTitleTextCenter().getText();
        Assert.assertEquals(allProductsText,"ALL PRODUCTS","Verify user is navigated to ALL PRODUCTS page successfully");
    }

 
   
    public static void verifySearchedProductsIsVisible() {
        String searchedProductsText = new ProductsPage(getDriver()).fillSearchProductInput(search).getTitleTextCenter().getText();
        Assert.assertEquals(searchedProductsText,"SEARCHED PRODUCTS","Verify 'SEARCHED PRODUCTS' is visible");
        
    }


}
