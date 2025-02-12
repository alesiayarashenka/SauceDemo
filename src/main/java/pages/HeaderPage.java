package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    public static final By CART_BUTTON = By.id("shopping_cart_container");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickToCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    public String countProductsInCart() {
        return driver.findElement(CART_BUTTON).getText();
    }
}
