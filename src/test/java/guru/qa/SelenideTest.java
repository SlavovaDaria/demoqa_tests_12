package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("SlavovaDaria")
@Severity(SeverityLevel.BLOCKER)
@Feature("RepoTasks")
@Story("RepoTasksCheck")
public class SelenideTest {

    @Test
    @DisplayName("GoodTest")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("SlavovaDaria/demoqa_tests_12");
        $(".header-search-input").submit();

        $(linkText("SlavovaDaria/demoqa_tests_12")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).click();
    }

}