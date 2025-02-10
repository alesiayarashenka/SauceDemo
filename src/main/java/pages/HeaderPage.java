package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePage{

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public static final By CART_BUTTON = By.id("shopping_cart_container");

    public void clickToCartButton(){
        driver.findElement(CART_BUTTON).click();
    }

    public String countProductsInCart(){
        String counter = driver.findElement(CART_BUTTON).getText();
        return counter;
    }
}
