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

        $("#firstName").setValue("First Name");
        $("#lastName").setValue("Last Name");
        $("#userEmail").setValue("name@example.com");
        $(byText("Other")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label$='September 4th, 1991']").click();
        $("#subjectsInput").setValue("C").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");
        $("#currentAddress").setValue("Current Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("First Name Last Name"))
                .parent().shouldHave(text("First Name Last Name"));
        $(".table-responsive").$(byText("name@example.com"))
                .parent().shouldHave(text("name@example.com"));
        $(".table-responsive").$(byText("Other"))
                .parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("0123456789"))
                .parent().shouldHave(text("0123456789"));
        $(".table-responsive").$(byText("04 September,1991"))
                .parent().shouldHave(text("04 September,1991"));
        $(".table-responsive").$(byText("Physics"))
                .parent().shouldHave(text("Physics"));
        $(".table-responsive").$(byText("Reading"))
                .parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("1.jpg"))
                .parent().shouldHave(text("1.jpg"));
        $(".table-responsive").$(byText("Current Address"))
                .parent().shouldHave(text("Current Address"));
        $(".table-responsive").$(byText("NCR Delhi"))
                .parent().shouldHave(text("NCR Delhi"));
    }
}
