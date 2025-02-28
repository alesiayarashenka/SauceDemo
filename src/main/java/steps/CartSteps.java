package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.ProductsPage;
import waiters.Waiter;

public class CartSteps {
    private CartPage cartPage;
    private ProductsPage productsPage;
    Waiter waiter = new Waiter();

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Open cart page and remove product from cart")
    public CartSteps openCartPageAndRemoveProduct(String... productName) {
        cartPage.openPage(IConstants.CART_PAGE_URL);
        waiter.waitForPageLoaded();
        cartPage.removeProductOnCartPage(productName);
        return this;
    }
}
