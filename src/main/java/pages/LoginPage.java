package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessageTest(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
