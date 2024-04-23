package seleniumTest.pages;

import org.openqa.selenium.WebDriver;

public abstract class BaseSeleniumPage {
    protected static WebDriver driver;

    public static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}