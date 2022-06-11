package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "SlavovaDaria/demoqa_tests_12";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("OpenMainPage", () -> {
            open("https://github.com");
        });
        step("FindRepo " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("GoToRepoLink " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("ClickIssues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("CheckIssueNumber" + ISSUE_NUMBER, () -> {
            $(withText("#1")).should(Condition.exist);
            Allure.getLifecycle().addAttachment(
                    "Page",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
