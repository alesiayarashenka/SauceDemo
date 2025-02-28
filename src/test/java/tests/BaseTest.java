package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.CartSteps;
import steps.LoginSteps;
import steps.ProductSteps;

import java.time.Duration;

public class BaseTest implements IConstants {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    LoginPageFactory loginPageFactory;
    ProductSteps productSteps;
    LoginSteps loginSteps;
    CartSteps cartSteps;

    /**
     * This is initialization of pages
     */
    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        initPages();
    }

    public void initPages(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        productSteps = new ProductSteps(driver);
        loginSteps = new LoginSteps(driver);
        cartSteps = new CartSteps(driver);
    }

    /**
     * This is closing of pages
     */
    @AfterMethod
    public void endTest(){
        driver.quit();
    }
}
