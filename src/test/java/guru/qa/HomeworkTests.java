package guru.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkTests {

    public static final ElementsCollection PAGES = $("#wiki-pages-box").$$("ul li");
    public static final SelenideElement WIKI_TAB = $("#wiki-tab");
    public static final SelenideElement WIKI_PAGES_FILTER = $("#wiki-pages-filter");
    public static final SelenideElement WIKI_BODY = $("#wiki-body");

    public static final String SEARCH_FOR_PAGE = "SoftAssertions";
    public static final String JUNIT_5_BLOCK = "3. Using JUnit5 extend test class:";


    @Test
    void checkSoftAssertionsPage() {
        open("https://github.com/selenide/selenide");
        WIKI_TAB.click();
        WIKI_PAGES_FILTER.setValue(SEARCH_FOR_PAGE);
        PAGES.findBy(exactTextCaseSensitive(SEARCH_FOR_PAGE)).click();
        WIKI_BODY.$(byText(JUNIT_5_BLOCK)).shouldBe(visible);
    }
}