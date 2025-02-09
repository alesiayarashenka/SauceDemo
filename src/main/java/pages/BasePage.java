package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;

public abstract class BasePage implements IConstants {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url){
        driver.get(url);
    }
}
