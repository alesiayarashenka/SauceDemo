package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static pages.CartPage.*;
import static tests.ITestConstants.*;
import static tests.ITestConstants.SAUCE_LABS_BACKPACK;
import static tests.Preconditions.userSuccessLogin;


public class CartTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "product")
    public Object[][] productsAndPrices() {
        return new Object[][]{
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONESIE, "$7.99"},
                {TEST_ALL_THE_THINGS_T_SHIRT_RED, "$15.99"},
        };
    }

    /**
     * This is checking for correct product price in cart page and product page
     *
     * @param productName
     * @param price
     */
    @Test(dataProvider = "product")
    public void checkProductPriceInCartTest(String productName, String price) {
        productSteps.loginAndAddProductToCart(userSuccessLogin, productName);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(), price);
    }

    /**
     * This is checking for correct product name, price and quantity in cart page
     */
    @Test()
    public void loginAddProductCheckNameQuantityInCart() {
        List<String> productNames = List.of(SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        List<String> productPrices = List.of(SAUCE_LABS_BACKPACK_PRICE, SAUCE_LABS_BIKE_LIGHT_PRICE);
        productSteps.loginAndAddProductToCart(userSuccessLogin, SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        cartPage.openPage(CART_PAGE_URL);
        softAssert.assertTrue(cartPage.getNameProduct().containsAll(productNames));
        softAssert.assertTrue(cartPage.getPriceProduct().containsAll(productPrices));
        softAssert.assertTrue(cartPage.quantityProductsInCart().contains("1"));
        softAssert.assertAll();
    }

    /**
     * This is checking for buttons "continue","checkout" and "remove" display on the cart page and for "remove" buttons after redirect to product page
     */
    @Test(retryAnalyzer = Retry.class)
    public void loginAddProductContinueShopping() {
        productSteps.loginAndAddProductToCart(userSuccessLogin, SAUCE_LABS_BACKPACK, SAUCE_LABS_BIKE_LIGHT);
        cartPage.openPage(CART_PAGE_URL);
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
        productSteps.loginAndAddProductToCart(userSuccessLogin, SAUCE_LABS_BACKPACK);
        cartSteps.openCartPageAndRemoveProduct(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(cartPage.checkNotDisplayedProductInCartButton());
    }
}
