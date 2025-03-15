package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class ProductsPage extends HeaderPage {

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class" + "='inventory_item']";
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains" + "(text(), 'Add')]";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//*[contains" + "(text(), 'Remove')]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This is adding products in a cart
     * @return
     */
    public ProductsPage addProductInCart(String... productName) {
        for (String productNames : productName) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productNames))).click();
            log.info("Product {} was added in a cart", productName);
        }
        return this;
    }

    /**
     * This is removing products from cart
     * @return
     */
    public ProductsPage removeProductInCart(String... productName) {
        for (String productNames : productName) {
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productNames))).click();
            log.info("Product {} was removed from cart", productName);
        }
        return this;
    }

    /**
     * This is checking for missing remove button
     * @return
     */
    public boolean checkNotDisplayedRemoveButton(String productName) {
        List<WebElement> removeButton = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName)));
        return removeButton.isEmpty();
    }

    /**
     * This is checking for missing add to cart button
     * @return
     */
    public boolean checkNotDisplayedAddToCartButton(String productName) {
        List<WebElement> addButton = driver.findElements(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        return addButton.isEmpty();
    }

    /**
     * This is checking for the display remove button
     * @return
     */
    public boolean checkDisplayedRemoveButton(String productName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    /**
     * This is checking for the display add to cart button
     * @return
     */
    public boolean checkDisplayedAddToCartButton(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }
}
