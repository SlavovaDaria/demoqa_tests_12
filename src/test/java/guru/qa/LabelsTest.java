package guru.qa;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class LabelsTest {

    @Test
    @Owner("SlavovaDaria")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("RepoTasks")
    @Story("RepoTasksCheck")
    @DisplayName("FavTest")
    @Link(value = "Testing", url = "https://github.com")
    public void testAnnotated() {
    }

    @Test
    public void testCode() {
        Allure.label("owner", "SlavovaDaria");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("RepoTasks");
        Allure.story("RepoTasksCheck");
        Allure.link("Testing", "https://github.com");
    }


    @Documented
    @Owner("SlavovaDaria")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("RepoTasks")
    @Story("RepoTasksCheck")
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IssueShow {

    }
}
