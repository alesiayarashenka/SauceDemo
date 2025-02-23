package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends HeaderPage {

    public static final By PRODUCT_NAME_IN_CART = By.xpath("//div[@class = 'inventory_item_name']");
    public static final By PRODUCT_PRICE_IN_CART = By.xpath("//div[@class='inventory_item_price']");
    public static final By PRODUCT_QUANTITY_IN_CART = By.xpath("//div[@class='cart_quantity']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//button[@id='continue-shopping']");
    public static final By CHECKOUT_BUTTON = By.xpath("//button[@id='checkout']");
    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class" + "='cart_item']";
    public static final String REMOVE_PRODUCT_ON_CART_BUTTON = PRODUCT_ITEM + "//*[contains" + "(text(), 'Remove')]";
    public static final String CART_ITEM_CONTAINER = "//*[@class='cart_item']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openCartPage(String url) {
        driver.get(url);
        return this;
    }

    public List<String> getNameProduct() {
        List<String> name = new ArrayList<>();
        List<WebElement> nameProduct = driver.findElements(PRODUCT_NAME_IN_CART);
        for (WebElement webElement : nameProduct) {
            name.add(webElement.getText());
        }
        return name;
    }

    public List<String> getPriceProduct() {
        List<String> price = new ArrayList<>();
        List<WebElement> priceProduct = driver.findElements(PRODUCT_PRICE_IN_CART);
        for (WebElement webElement : priceProduct) {
            price.add(webElement.getText().split("\n")[0]);
        }
        return price;
    }

    public String getProductPrice() {
        return driver.findElement(PRODUCT_PRICE_IN_CART).getText();
    }

    public List<String> quantityProductsInCart() {
        List<String> quantity = new ArrayList<>();
        List<WebElement> quantityProduct = driver.findElements(PRODUCT_QUANTITY_IN_CART);
        for (WebElement webElement : quantityProduct) {
            quantity.add(webElement.getText());
        }
        return quantity;
    }

    public Integer getAllProductsQuantity() {
        return driver.findElements(By.xpath(CART_ITEM_CONTAINER)).size();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void directInCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public boolean displayedButton(By webElement) {
        List<WebElement> button = driver.findElements(webElement);
        if (button.size() == 1) {
            for (WebElement webElement1 : button) {
                if (webElement1.isDisplayed()) ;
            }
            return true;
        }
        return false;
    }

    public boolean checkDisplayedRemoveButtonInCart(String productName) {
        List<WebElement> removeButton = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_ON_CART_BUTTON, productName)));
        return removeButton.contains(productName);
    }

    public CartPage removeProductOnCartPage(String... productName) {
        for (String productNames : productName) {
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_ON_CART_BUTTON, productNames))).click();
        }
        return this;
    }

    public boolean checkNotDisplayedProductInCartButton() {
        List<WebElement> product = driver.findElements(PRODUCT_NAME_IN_CART);
        return product.isEmpty();
    }
}
