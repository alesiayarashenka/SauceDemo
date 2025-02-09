package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import static tests.ITestConstants.PASSWORD;
import static tests.ITestConstants.USERNAME;

public class LoginTest extends BaseTest{
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";



    @Test
    public void loginWithEmptyUserNameTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login("",PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageTest(),EMPTY_FIELD_USERNAME_ERROR);
    }
        @Test
        public void loginWithEmptyPasswordTest(){
            loginPage.openPage(IConstants.LOGIN_PAGE_URL);
            loginPage.login(USERNAME,"");
            Assert.assertEquals(loginPage.getErrorMessageTest(),EMPTY_FIELD_PASSWORD_ERROR);
        }

        @Test
        public void loginWithEmptyFieldsTest(){
            loginPage.openPage(IConstants.LOGIN_PAGE_URL);
            loginPage.login("","");
            Assert.assertEquals(loginPage.getErrorMessageTest(),EMPTY_FIELD_USERNAME_ERROR);
        }

    @Test
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("efwefwe", "efwfwe");
        Assert.assertEquals(loginPage.getErrorMessageTest(), INCORRECT_DATA_IN_FIELDS);
    }
}
