package steps;

import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static constants.IConstants.LOGIN_PAGE_URL;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProductToCart(String username, String password, String... productName) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(username, password);
        productsPage.addProductInCart(productName);
        return this;
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProductToCart(User user, String... productName) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        productsPage.addProductInCart(productName);
        return this;
    }

    @Step("Remove product from cart")
    public ProductSteps removeProductFromCartInCartPage(String... productName) {
        productsPage.removeProductInCart(productName);
        return this;
    }
}