package ui.selenideTest.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private final ElementsCollection articleTitles = $$("article h2");

    public String getFirstArticleHref() {
        return articleTitles.first()
                .find("a")
                .getAttribute("href");
    }
}
