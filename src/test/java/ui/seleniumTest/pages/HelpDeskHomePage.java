package ui.seleniumTest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import propertiesTest.ConfigProvider;

public class HelpDeskHomePage extends BaseSeleniumPage {
    public HelpDeskHomePage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='id_queue']")
    private WebElement queueSelect;

    @FindBy(xpath = "//select[@id='id_queue']//option[@value='1']")
    private WebElement queueListValue1;

    @FindBy(id = "id_title")
    private WebElement title;

    @FindBy(id = "id_body")
    private WebElement description;

    @FindBy(xpath = "//select[@id='id_priority']")
    private WebElement prioritySelect;

    @FindBy(xpath = "//select[@id='id_priority']//option[@value='1']")
    private WebElement priorityListValue1;

    @FindBy(id = "id_due_date")
    private WebElement dueDate;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//a[text()='23']")
    private WebElement dateOnCalendar;

    @FindBy(id = "id_submitter_email")
    private WebElement email;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "userDropdown")
    private WebElement userLoginButton;

    @Step("Создать тикет {title} с почтой {email}")
    public HelpDeskHomePage createIssue(String title, String description, String email) {

        waitUntil(5L, ExpectedConditions.elementToBeClickable(queueSelect));
        queueSelect.click();
        queueListValue1.click();

        this.title.sendKeys(title);
        this.description.sendKeys(description);

        prioritySelect.click();
        priorityListValue1.click();

        dueDate.click();
        dateOnCalendar.click();

        this.email.sendKeys(email);

        submitButton.click();

        return this;
    }

    @Step("Перейти на страницу авторизации")
    public LoginPage openLoginPage() {
        userLoginButton.click();
        return new LoginPage();
    }
}