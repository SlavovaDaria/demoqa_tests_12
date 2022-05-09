package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");

        $("[id=firstName]").setValue("First Name");
        $("[id=lastName]").setValue("Last Name");
        $("[id=userEmail]").setValue("name@example.com");
        $(byText("Other")).click();
        $("[id=userNumber]").setValue("0123456789");
        $("[id=currentAddress]").setValue("Current Address");
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("First Name Last Name"))
                .parent().shouldHave(text("First Name Last Name"));
        $(".table-responsive").$(byText("name@example.com"))
                .parent().shouldHave(text("name@example.com"));
        $(".table-responsive").$(byText("Other"))
                .parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("0123456789"))
                .parent().shouldHave(text("0123456789"));
        $(".table-responsive").$(byText("09 May,2022"))
                .parent().shouldHave(text("09 May,2022"));
        $(".table-responsive").$(byText("Current Address"))
                .parent().shouldHave(text("Current Address"));
    }
}
