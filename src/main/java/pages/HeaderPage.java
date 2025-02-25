package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public static final By CART_BUTTON = By.id("shopping_cart_container");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This is opening cart page by click
     * @return
     */
    public CartPage clickToCartButton() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    /**
     * This is returning amount of products on the cart counter
     * @return
     */
    public String countProductsInCart() {
        return driver.findElement(CART_BUTTON).getText();
    }
}
