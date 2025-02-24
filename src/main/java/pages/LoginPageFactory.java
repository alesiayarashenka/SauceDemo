package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * This is checking text of error messages
     * @return
     */
    public String getErrorMessageTest() {
        return errorMessage.getText();
    }

}
