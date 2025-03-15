package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiters.Waiter;

import java.time.Duration;

@Log4j2
public class LoginPage extends BasePage{

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");
    Waiter waiter = new Waiter();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This logins by object
     * @return
     */
    public ProductsPage login(User user){
        waiter.waitForPageLoaded();
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        log.info("User is registered with username: {}", user.getUsername());
        return new ProductsPage(driver);
    }

    /**
     * This logins by param
     * @return
     */
    public ProductsPage login(String username, String password){
        waiter.waitForPageLoaded();
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("User is registered with username: {}", username);
        return new ProductsPage(driver);
    }

    /**
     * This is checking text of error messages
     * @return
     */
    public String getErrorMessageTest(){
        String message = driver.findElement(ERROR_MESSAGE).getText();
        log.info("User was not logged: {}", message);
        return message;
    }

    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }
}
