package seleniumTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseSeleniumPage {
    protected static WebDriver driver;

    public static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static <T> void waitUntil(Long timeout, ExpectedCondition<T> condition) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(condition);
    }
}