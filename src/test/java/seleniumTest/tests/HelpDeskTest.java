package seleniumTest.tests;

import helpers.TestValues;
import helpers.WebUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.Assert;
import org.junit.Test;
import propertiesTest.ConfigProvider;
import seleniumTest.BaseSeleniumTest;
import seleniumTest.pages.HelpDeskHomePage;
import seleniumTest.pages.SingleTicketPage;

public class HelpDeskTest extends BaseSeleniumTest {

    @Owner("test QA")
    @Description("Создание тикета в helpDesk")
    @TmsLink("www.vk.com")
    @Issue("PSCPSC-00000")
    @Test
    public void createTicket() {
        String title = TestValues.ISSUE_TITLE + WebUtils.getDate();
        String description = TestValues.ISSUE_DESCRIPTION + WebUtils.getRandomInt();

        SingleTicketPage ticket = new HelpDeskHomePage()
                .createIssue(title, description, TestValues.REPORTER_EMAIL)
                .openLoginPage()
                .login(ConfigProvider.ADMIN_LOGIN, ConfigProvider.ADMIN_PASSWORD)
                .search(title);

        Assert.assertTrue(ticket.getTitle().contains(title));
        Assert.assertEquals(ticket.getDescription(), description);
        Assert.assertEquals(ticket.getEmail(), TestValues.REPORTER_EMAIL);
    }

    @Test
    public void test2() {
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        Assert.assertTrue(true);
    }
}
