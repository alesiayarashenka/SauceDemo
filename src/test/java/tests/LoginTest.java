package tests;

import constants.IConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.ITestConstants.PASSWORD;
import static tests.ITestConstants.USERNAME;

public class LoginTest extends Preconditions{
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";



    @Test
    public void loginWithEmptyUserNameTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageTest(),EMPTY_FIELD_USERNAME_ERROR);
//        assertThat(loginPage.getErrorMessageTest(),equalTo(""));
    }
        @Test
        public void loginWithEmptyPasswordTest(){
            loginPage.openPage(LOGIN_PAGE_URL);
            loginPage
                    .waitForPageOpened()
                    .login(userWithEmptyPassword);
            Assert.assertEquals(loginPage.getErrorMessageTest(),EMPTY_FIELD_PASSWORD_ERROR);
        }

        @Test
        public void loginWithEmptyFieldsTest(){
            loginPage.openPage(LOGIN_PAGE_URL);
            loginPage.login(userEmptyFields);
            Assert.assertEquals(loginPage.getErrorMessageTest(),EMPTY_FIELD_USERNAME_ERROR);
        }

    @Test
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageTest(), INCORRECT_DATA_IN_FIELDS);
    }

    @Test
    public void loginWithoutPageFactory(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }

    @Test
    public void loginWithPageFactory(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = loginPageFactory.getAddButton();
        addButton.click();
        WebElement deleteButton = loginPageFactory.getDeleteButton();
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }
}
