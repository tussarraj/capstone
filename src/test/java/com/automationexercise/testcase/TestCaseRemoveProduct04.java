package com.automationexercise.testcase;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.pageObject.CartPage;
import com.automationexercise.pageObject.ProductsPage;


public class TestCaseRemoveProduct04 extends BaseClass {

    @Test
    public void removeProductsFromCart() {
        TestCaseRegister01.verifyThatHomePageIsVisibleSuccessfully();
        verifyThatCartPageIsDisplayed();
        verifyThatProductIsRemovedFromTheCart();
    }
    
    public static void verifyThatCartPageIsDisplayed() {
        String shoppingCartText = new ProductsPage(getDriver()).addProductsToCart().getShoppingCart().getText();
        Assert.assertEquals(shoppingCartText, "Shopping Cart", "Verify that cart page is displayed");
    }
    
    private void verifyThatProductIsRemovedFromTheCart() {
        String emptyCartText = new CartPage(getDriver()).xButtonClick().getEmptyCartSpan().getText();
        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");
    }
}
