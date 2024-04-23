package seleniumTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleTicketPage extends BaseSeleniumPage {

    @FindBy(xpath = "//h3")
    private WebElement title;

    @FindBy(xpath = "//*[@id='ticket-description']/p")
    private WebElement description;

    @FindBy(xpath = "//th[text()='Submitter E-Mail']/following::td[1]")
    private WebElement email;

    public SingleTicketPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText().trim();
    }

    public String getEmail() {
        return email.getText().trim();
    }
}
