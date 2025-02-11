package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static tests.ITestConstants.*;

public class ProductsTest extends BaseTest {

    //loginPage.openPage()
    //loginPage.login(username, password)
    //productPage.addToCart("Product Name")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Name")
    //cartPage.getPrice("Product Name")
    //Assertions

    @Test(description = "Add product in cart and check buttons, remove product from cart and check buttons on the product page")
    public void loginAddProductRemoveFromCart() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK);
        softAssert.assertTrue(productsPage.checkNotDisplayedAddToCartButton(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(productsPage.checkDisplayedRemoveButton(SAUCE_LABS_BACKPACK));
        productsPage.removeProductInCart(SAUCE_LABS_BACKPACK);
        softAssert.assertTrue(productsPage.checkNotDisplayedRemoveButton(SAUCE_LABS_BACKPACK));
        softAssert.assertTrue(productsPage.checkDisplayedAddToCartButton(SAUCE_LABS_BACKPACK));
    }

    @Test(description = "Add products in cart and check counter of products in cart on the product page")
    public void loginAddProductCheckInCart() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductInCart(SAUCE_LABS_BACKPACK);
        String counterOneProduct = headerPage.countProductsInCart();
        Assert.assertEquals(counterOneProduct, "1");
        productsPage.addProductInCart(SAUCE_LABS_BIKE_LIGHT);
        String counterTwoProducts = headerPage.countProductsInCart();
        Assert.assertEquals(counterTwoProducts, "2");
    }
}
