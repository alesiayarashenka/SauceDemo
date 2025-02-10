package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static pages.CartPage.*;
import static tests.ITestConstants.*;
import static tests.ITestConstants.SAUCE_LABS_BACKPACK;

public class CartTest extends BaseTest {

    @Test(description = "Add product in cart, check product name, price and quantity on the cart page")
    public void loginAddProductCheckNameQuantityInCart() {
        List<String> productNames = List.of(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        List<String> productPrices = List.of(SAUCE_LABS_BACKPACK_PRICE, SAUCE_LABS_BIKE_LIGHT_PRICE);
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK);
        productsPage.addProductInCart(SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickToCartButton();
        Assert.assertTrue(cartPage.getNameProduct().containsAll(productNames));
        Assert.assertTrue(cartPage.getPriceProduct().containsAll(productPrices));
        Assert.assertTrue(cartPage.quantityProductsInCart().contains("1"));
    }

    @Test(description = "Add products in cart, check displayed buttons and continue shopping")
    public void loginAddProductContinueShopping() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK);
        productsPage.addProductInCart(SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickToCartButton();
        Assert.assertTrue(cartPage.displayedButton(CONTINUE_SHOPPING_BUTTON));
        Assert.assertTrue(cartPage.displayedButton(CHECKOUT_BUTTON));
        Assert.assertTrue(cartPage.checkDisplayedRemoveButtonInCart(SAUCE_LABS_BACKPACK));
        Assert.assertTrue(cartPage.checkDisplayedRemoveButtonInCart(SAUCE_LABS_BIKE_LIGHT));
        cartPage.continueShopping();
        Assert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BACKPACK));
        Assert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BIKE_LIGHT));
    }

    @Test(description = "Add product in cart, remove product, check the product is not displayed")
    public void loginAddProductAndRemove() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK);
        headerPage.clickToCartButton();
        Assert.assertTrue(cartPage.getNameProduct().contains(SAUCE_LABS_BACKPACK));
        cartPage.removeProductOnCartPage(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(cartPage.checkNotDisplayedProductInCartButton());
    }
}
