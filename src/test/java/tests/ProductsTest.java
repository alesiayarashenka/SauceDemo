package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static tests.ITestConstants.*;
import static tests.Preconditions.userSuccessLogin;

public class ProductsTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Add product in cart and check buttons, remove product from cart and check buttons on the product page")
    public void loginAddProductRemoveFromCart() {
        productSteps.loginAndAddProductToCart(userSuccessLogin, SAUCE_LABS_BACKPACK);
        softAssert.assertTrue(productsPage.checkNotDisplayedAddToCartButton(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BACKPACK));
        productSteps.removeProductFromCartInCartPage(SAUCE_LABS_BACKPACK);
        softAssert.assertTrue(productsPage.checkNotDisplayedRemoveButton(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(productsPage.checkDisplayedAddToCartButton(SAUCE_LABS_BACKPACK));
        softAssert.assertAll();
    }

    @Test(description = "Add products in cart and check counter of products in cart on the product page")
    public void loginAddProductCheckInCart() {
        productSteps.loginAndAddProductToCart(userSuccessLogin, SAUCE_LABS_BACKPACK);
        String counterOneProduct = headerPage.countProductsInCart();
        Assert.assertEquals(counterOneProduct, "1");
        productsPage
                .addProductInCart(SAUCE_LABS_BIKE_LIGHT);
        String counterTwoProducts = headerPage.countProductsInCart();
        Assert.assertEquals(counterTwoProducts, "2");
    }
}
