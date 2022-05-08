package guru.qa;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class SimpleTest {

    @BeforeEach
    void openYaPage() {
        System.out.println("###     @BeforeEach");
//        Selenide.open("https://ya.ru");
    }

    @Test
    void assertTest() {

    }

    @Test
    void assertTest1() {

    }

}
