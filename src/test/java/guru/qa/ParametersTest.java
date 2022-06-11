package guru.qa;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParametersTest {

    @Test
    @DisplayName("FavTest")
    public void testAnnotated() {
        Allure.parameter("Регион", "Московская область");
        Allure.parameter("Город", "Москва");
    }
}
