package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static pages.CartPage.*;
import static tests.ITestConstants.*;
import static tests.ITestConstants.SAUCE_LABS_BACKPACK;

public class CartTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "product")
    public Object[][] productsAndPrices() {
        return new Object[][] {
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONESIE, "$7.99"},
                {TEST_ALL_THE_THINGS_T_SHIRT_RED, "$15.99"},
        };
    }

    /**
     *
     * @param productName
     * @param price
     */
    @Test(dataProvider = "product")
    public void checkProductPriceInCartTest(String productName, String price) {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductInCart(productName);
        cartPage.openCartPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(), price);
    }

    @Test()
    public void loginAddProductCheckNameQuantityInCart() {
        List<String> productNames = List.of(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        List<String> productPrices = List.of(SAUCE_LABS_BACKPACK_PRICE, SAUCE_LABS_BIKE_LIGHT_PRICE);
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductInCart(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickToCartButton();
        softAssert.assertTrue(cartPage.getNameProduct().containsAll(productNames));
        softAssert.assertTrue(cartPage.getPriceProduct().containsAll(productPrices));
        softAssert.assertTrue(cartPage.quantityProductsInCart().contains("1"));
        softAssert.assertAll();
    }

    @Test(retryAnalyzer = Retry.class)
    public void loginAddProductContinueShopping() {
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductInCart(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickToCartButton();
        softAssert.assertTrue(cartPage.displayedButton(CONTINUE_SHOPPING_BUTTON));
        softAssert.assertTrue(cartPage.displayedButton(CHECKOUT_BUTTON));
        softAssert.assertTrue(cartPage.checkDisplayedRemoveButtonInCart(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(cartPage.checkDisplayedRemoveButtonInCart(SAUCE_LABS_BIKE_LIGHT));
        cartPage.continueShopping();
        softAssert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BIKE_LIGHT));
        softAssert.assertAll();
    }

    @Test(description = "Add product in cart, remove product, check the product is not displayed")
    public void loginAddProductAndRemove() {
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductInCart(SAUCE_LABS_BACKPACK);
        cartPage
                .openCartPage(CART_PAGE_URL)
                .removeProductOnCartPage(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(cartPage.checkNotDisplayedProductInCartButton());
    }
}
