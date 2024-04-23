package selenideTest.tests;

import org.junit.Assert;
import org.junit.Test;
import selenideTest.BaseSelenideTest;
import selenideTest.pages.MainPage;

public class AppleInsiderTest extends BaseSelenideTest {
    private static final String BASE_URL = "https://appleinsider.ru/";
    private static final String SEARCH_STRING = "Чем отличается iPhone 13 от iPhone 12";
    private static final String EXPECTED_WORD = "iphone-13";

    @Test
    public void checkFirstArticleHref() {
        String href = new MainPage(BASE_URL)
                .searchSmart(SEARCH_STRING)
                .getFirstArticleHref();

        System.out.println(href);

        Assert.assertTrue(href.contains(EXPECTED_WORD));
    }
}