package seleniumTest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(id = "username")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    @Step("Войти под юзером - {login} пароль - {password}")
    public TicketsPage login(String login, String password) {
        this.login.sendKeys(login);
        this.password.sendKeys(password, Keys.ENTER);

        return new TicketsPage();
    }

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}
