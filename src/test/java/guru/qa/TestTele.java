package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestTele {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }


    @DisplayName("Discount")
    @ParameterizedTest(name = "Discount {0}, ожидаем результат: {1}")
    @CsvSource({"1, Скидка 0%",
            "2, Скидка 0%",
            "3, Скидка 5%",
            "4, Скидка 10%",
            "5, Скидка 15%"})
    void discountTest(String testData, String expectedResult) {
        Selenide.open("https://spb.tele2.ru/");
        $(".tariff-cards-container__sim-number-selection").$(byText(testData)).click();
        $$(".tariff-cards-container__sim-number-selection")
                .find(text(expectedResult));
        $(".tariff-cards-container__sim-number-selection").shouldHave(text(testData));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Москва и область",
            "Санкт-Петербург и Ленинградская область"
    })
    void discountTest(String testData) {
        Selenide.open("https://spb.tele2.ru/");
        $("#regionSearchOpener").click();
        $(".text-field").setValue(testData);
        $(".region-results").find(byText(testData)).click();
        $("#regionSearchOpener").shouldHave(text(testData));
    }

    static Stream<Arguments>methodSourceTest() {
        return Stream.of(
                Arguments.of("Москва и область"),
                Arguments.of("Санкт-Петербург и Ленинградская область")
        );
    }
    @MethodSource("methodSourceTest")
    @ParameterizedTest
    void methodSourceTest(String testData) {
        Selenide.open("https://spb.tele2.ru/");
        $("#regionSearchOpener").click();
        $(".text-field").setValue(testData);
        $(".region-results").find(byText(testData)).click();
        $("#regionSearchOpener").shouldHave(text(testData));
    }
}