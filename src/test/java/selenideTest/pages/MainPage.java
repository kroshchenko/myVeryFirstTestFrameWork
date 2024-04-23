package selenideTest.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

/**
 * Главная страница appleInsider.ru
 **/

public class MainPage {

    public MainPage(String url) {
        Selenide.open(url);
    }

    private final SelenideElement searchButton = $("form");
    private final SelenideElement searchInput = $("form input");

    private void clickSearchButton() {
        searchButton.click();
    }

    public SearchPage search(String text) {
        clickSearchButton();
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

    public SearchPage searchSmart(String text) {
        searchInput.setValue(text);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }
}
