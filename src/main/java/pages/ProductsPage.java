package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends HeaderPage {

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class" + "='inventory_item']";
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains" + "(text(), 'Add')]";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//*[contains" + "(text(), 'Remove')]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage addProductInCart(String... productName) {
        for (String productNames : productName) {
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productNames))).click();
        }
        return this;
    }

    public void removeProductInCart(String... productName) {
        for (String productNames : productName) {
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productNames))).click();
        }
    }

    public boolean checkNotDisplayedRemoveButton(String productName) {
        List<WebElement> removeButton = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName)));
        return removeButton.isEmpty();
    }

    public boolean checkNotDisplayedAddToCartButton(String productName) {
        List<WebElement> addButton = driver.findElements(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        return addButton.isEmpty();
    }

    public boolean checkDisplayedRemoveButton(String productName) {
        List<WebElement> removeButton = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName)));
        return removeButton.contains(productName);
    }

    public boolean checkDisplayedAddToCartButton(String productName) {
        List<WebElement> addToCartButton = driver.findElements(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        return addToCartButton.contains(productName);
    }

}
