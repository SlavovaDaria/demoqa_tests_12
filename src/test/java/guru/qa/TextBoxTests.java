package guru.qa;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        open ("https://demoqa.com/automation-practice-form");
    }

}
