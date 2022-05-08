package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";

    }


    @Test
    void fillFormTest() {
        open("/text-box");
    }

}
