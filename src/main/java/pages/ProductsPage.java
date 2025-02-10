package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends HeaderPage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class" + "='inventory_item']";
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains" + "(text(), 'Add')]";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//*[contains" + "(text(), 'Remove')]";

    public void addProductInCart(String productName){
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }
    public void removeProductInCart(String productName){
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,productName))).click();
    }

    public boolean checkNotDisplayedRemoveButton(String productName){
        List<WebElement> removeButton = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,productName)));
        removeButton.isEmpty();
        return true;
    }

    public boolean checkNotDisplayedAddToCartButton(String productName){
        List<WebElement> addButton = driver.findElements(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON,productName)));
        addButton.isEmpty();
        return true;
    }

    public boolean checkDisplayedRemoveButton(String productName){
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,productName))).isDisplayed();
        return true;
    }
    public boolean checkDisplayedAddToCartButton(String productName){
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON,productName))).isDisplayed();
        return true;
    }

}
