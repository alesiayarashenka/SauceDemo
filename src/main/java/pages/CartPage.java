package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import waiters.Waiter;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends HeaderPage {

    Waiter waiter = new Waiter();

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

    /**
     * this is opening CartPage
     * @param url
     * @return
     */
    public CartPage openCartPage(String url) {
        waiter.waitForPageLoaded();
        driver.get(url);
        return this;
    }

    /**
     * This is returning names of many products
     * @return
     */
    public List<String> getNameProduct() {
        List<String> name = new ArrayList<>();
        List<WebElement> nameProduct = driver.findElements(PRODUCT_NAME_IN_CART);
        for (WebElement webElement : nameProduct) {
            name.add(webElement.getText());
        }
        return name;
    }

    /**
     * This is returning prices of many products
     * @return
     */
    public List<String> getPriceProduct() {
        List<String> price = new ArrayList<>();
        List<WebElement> priceProduct = driver.findElements(PRODUCT_PRICE_IN_CART);
        for (WebElement webElement : priceProduct) {
            price.add(webElement.getText().split("\n")[0]);
        }
        return price;
    }

    /**
     * This is returning price of one product
     * @return
     */
    public String getProductPrice() {
        return driver.findElement(PRODUCT_PRICE_IN_CART).getText();
    }

    /**
     * This is returning quantity for each product on the page
     * @return
     */
    public List<String> quantityProductsInCart() {
        List<String> quantity = new ArrayList<>();
        List<WebElement> quantityProduct = driver.findElements(PRODUCT_QUANTITY_IN_CART);
        for (WebElement webElement : quantityProduct) {
            quantity.add(webElement.getText());
        }
        return quantity;
    }

    /**
     * This is returning all quantity of products on the page
     * @return
     */
    public Integer getAllProductsQuantity() {
        return driver.findElements(By.xpath(CART_ITEM_CONTAINER)).size();
    }

    /**
     * This is returning from cart page to product page
     * @return
     */
    public ProductsPage continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        waiter.waitForPageLoaded();
        return new ProductsPage(driver);
    }

    /**
     * This is directing from cart page to checkout page
     * @return
     */
    public void directInCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    /**
     * This is checking for displayed button and quantity of button
     * @return
     */
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

    /**
     * This is checking for the display remove button
     * @return
     */
    public boolean checkDisplayedRemoveButtonInCart(String productName) {
        List<WebElement> removeButton = driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_ON_CART_BUTTON, productName)));
        return removeButton.contains(productName);
    }

    /**
     * This is removing product from cart
     * @return
     */
    public CartPage removeProductOnCartPage(String... productName) {
        for (String productNames : productName) {
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_ON_CART_BUTTON, productNames))).click();
        }
        return this;
    }

    /**
     * This is checking for missing remove button
     * @return
     */
    public boolean checkNotDisplayedProductInCartButton() {
        List<WebElement> product = driver.findElements(PRODUCT_NAME_IN_CART);
        return product.isEmpty();
    }
}
