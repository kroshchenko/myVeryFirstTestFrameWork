package seleniumTest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketsPage extends BaseSeleniumPage {

    @FindBy(id = "search_query")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='tickettitle']/a")
    private WebElement ticketName;

    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    public SingleTicketPage search(String text) {
        searchInput.sendKeys(text, Keys.ENTER);
        ticketName.click();
        return new SingleTicketPage();
    }
}
