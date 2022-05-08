package guru.qa;

import org.junit.jupiter.api.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class Junit5Tests {

    @BeforeAll
    static void initDB() {
        System.out.println("### @BeforeAll");
    }

    @BeforeEach
    void openYaPage() {
        Selenide.open("https://ya.ru");
    }

    @AfterEach
    void close() {
        WebDriverRunner.closeWindow();
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("### @AfterAll");
    }

    @Test
    void assertTest0() {

    }

    @Test
    void assertTest1() {

    }

    @Test
    void assertTest2() {

    }
    @Test
    void assertTest3() {

    }
    @Test
    void assertTest4() {

    }
}
