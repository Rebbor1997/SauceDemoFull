package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.LoginStep;

import java.util.ArrayList;
import java.util.List;

public class SmokeTest extends BaseTest {
    @Test
    public void criticalPathTest(){
        CheckoutCompletionPage checkoutCompletionPage = new LoginPage(browsersService, true)
                .setUserName(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginButtonClick()
                .addItemToCart("Sauce Labs Backpack")
                .cartBadgeClick()
                .checkoutButtonClick()
                .setFirstNameInput("Bob")
                .setLastNameInput("Fil")
                .setZipcodeInput("22245")
                .continueButtonClick()
                .finishButtonClick();

        Assert.assertEquals(checkoutCompletionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void loginFailedTest(){
        LoginPage loginPage = new LoginPage(browsersService, true)
        .setUserName(lockedUser.getUsername())
        .setPassword(lockedUser.getPassword())
        .loginButtonClick();

        Assert.assertEquals(loginPage.getErrorMessage().getText().trim(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void removeItemFromCartTest(){
        List<String> itemsList = new ArrayList<>();
        itemsList.add("Sauce Labs Backpack");
        itemsList.add("Sauce Labs Bolt T-Shirt");

        ShoppingCartPage shoppingCartPage = new LoginPage(browsersService, true)
                .setUserName(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginButtonClick()
                .addItemsToCart(itemsList)
                .cartBadgeClick()
                .removeButtonClick(itemsList.get(0));

        Assert.assertEquals(shoppingCartPage.getItemsCount(), 1);
    }

    //Steps
    @Test
    public void criticalPathStepsTest(){
        CheckoutCompletionPage checkoutCompletionPage = new LoginStep(browsersService)
                .successLogin(correctUser)
                .addItemToCart("Sauce Labs Backpack")
                .moveToCart()
                .completeOrder();

        Assert.assertEquals(checkoutCompletionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void removeItemFromCartStepsTest(){
        List<String> itemsList = new ArrayList<>();
        itemsList.add("Sauce Labs Backpack");
        itemsList.add("Sauce Labs Bolt T-Shirt");

        ShoppingCartPage shoppingCartPage = new LoginStep(browsersService)
                .successLogin(correctUser)
                .addItemsToCart(itemsList)
                .moveToCart()
                .getShoppingCartPage()
                .removeButtonClick(itemsList.get(1));

        Assert.assertEquals(shoppingCartPage.getItemsCount(), 1);
    }
}
