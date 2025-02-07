package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginAddProductCheckInCart() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("https://saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        String productName = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        String productPrice = driver.findElement(By.xpath("//*[contains(@id,'sauce-labs-backpack')]/../div[@class='inventory_item_price']")).getText();
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']"));
        WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
        addToCartButton.click();
        cartButton.click();
        WebElement nameProductInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(nameProductInCart.getText(), productName);
        String productPriceInCart = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        Assert.assertEquals(productPriceInCart.split("\n")[0], productPrice.split("\n")[0]);
        driver.quit();






    }
}
