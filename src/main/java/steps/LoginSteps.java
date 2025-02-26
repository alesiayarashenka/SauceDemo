package steps;

import constants.IConstants;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

    public class LoginSteps {
        private LoginPage loginPage;

        public LoginSteps(WebDriver driver) {
            loginPage = new LoginPage(driver);
        }

        @Step("")
        public LoginSteps loginAndWaitForPageOpened(String username, String password) {
            loginPage.openPage(IConstants.LOGIN_PAGE_URL);
            loginPage
                    .waitForPageOpened()
                    .login(username, password);
            return this;
        }

        @Step("")
        public LoginSteps loginAndWaitForPageOpened(User user) {
            loginPage.openPage(IConstants.LOGIN_PAGE_URL);
            loginPage
                    .waitForPageOpened()
                    .login(user);
            return this;
        }
    }

