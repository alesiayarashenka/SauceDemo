package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static pages.CartPage.*;
import static tests.ITestConstants.*;
import static tests.ITestConstants.SAUCE_LABS_BACKPACK;

public class CartTest extends BaseTest {

    @Test(description = "Add product in cart, check product name, price and quantity on the cart page")
    public void loginAddProductCheckNameQuantityInCart() {
        SoftAssert softAssert = new SoftAssert();
        List<String> productNames = List.of(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        List<String> productPrices = List.of(SAUCE_LABS_BACKPACK_PRICE, SAUCE_LABS_BIKE_LIGHT_PRICE);
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickToCartButton();
        softAssert.assertTrue(cartPage.getNameProduct().containsAll(productNames));
        softAssert.assertTrue(cartPage.getPriceProduct().containsAll(productPrices));
        softAssert.assertTrue(cartPage.quantityProductsInCart().contains("1"));
    }

    @Test(description = "Add products in cart, check displayed buttons and continue shopping")
    public void loginAddProductContinueShopping() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickToCartButton();
        softAssert.assertTrue(cartPage.displayedButton(CONTINUE_SHOPPING_BUTTON));
        softAssert.assertTrue(cartPage.displayedButton(CHECKOUT_BUTTON));
        softAssert.assertTrue(cartPage.checkDisplayedRemoveButtonInCart(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(cartPage.checkDisplayedRemoveButtonInCart(SAUCE_LABS_BIKE_LIGHT));
        cartPage.continueShopping();
        softAssert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BIKE_LIGHT));
    }

    @Test(description = "Add product in cart, remove product, check the product is not displayed")
    public void loginAddProductAndRemove() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK);
        headerPage.clickToCartButton();
        cartPage.removeProductOnCartPage(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(cartPage.checkNotDisplayedProductInCartButton());
    }
}
