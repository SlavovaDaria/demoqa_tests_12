package guru.qa;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @Test
    void fillFormTest() {
        open ("https://demoqa.com/automation-practice-form");
    }

}
