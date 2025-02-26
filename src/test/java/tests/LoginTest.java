package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions {
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    /**
     * This is checking message for login with empty username field
     */
    @Test
    public void loginWithEmptyUserNameTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageTest(), EMPTY_FIELD_USERNAME_ERROR);
//        assertThat(loginPage.getErrorMessageTest(),equalTo(""));
    }

    /**
     * This is checking message for login with empty password field
     */
    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage
                .login(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageTest(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    /**
     * This is checking message for login with empty username and password fields
     */
    @Test
    public void loginWithEmptyFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(userEmptyFields);
        Assert.assertEquals(loginPage.getErrorMessageTest(), EMPTY_FIELD_USERNAME_ERROR);
    }

    /**
     * This is checking message for login with incorrect username and password
     */
    @Test
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageTest(), INCORRECT_DATA_IN_FIELDS);
    }

    /**
     * This is checking for click on the delete button without pattern Page Factory
     */
    @Test
    public void loginWithoutPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }

    /**
     * This is checking for click on the delete button with pattern Page Factory
     */
    @Test
    public void loginWithPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = loginPageFactory.getAddButton();
        addButton.click();
        WebElement deleteButton = loginPageFactory.getDeleteButton();
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }
}
