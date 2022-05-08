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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1024x768";
    }


    @Test
    void fillFormTest() {
        open("/text-box");
    }

}
