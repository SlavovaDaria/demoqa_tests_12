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
        $(byText("Male")).click();
        $("[id=userNumber]").setValue("0123456789");

        $("[id=currentAddress]").setValue("Current Address");

        $("[id=submit]").click();





    }
}
