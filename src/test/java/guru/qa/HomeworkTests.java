package guru.qa;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import guru.qa.Generator;
import guru.qa.RegistrationFormPage;

import java.time.LocalDate;
import static java.lang.String.format;

public class HomeworkTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Generator gen = new Generator();


    LocalDate birthDate = gen.getDate();
    String firstName = gen.getFirstName();
    String lastName = gen.getLastName();
    String email = gen.getEmail();
    String gender = gen.getGender();
    String phoneNumber = gen.getPhoneNumber();
    String subject = gen.getSubject();
    String hobby = gen.getHobby();
    String imgPath = "img/1.jpg";
    String address = gen.getAddress();
    String state = gen.getState();
    String city = gen.getCity(state);

    //expected results
    String expectedFullName = format("%s %s", firstName, lastName);
    String expectedMonth = StringUtils.capitalize(birthDate.getMonth().toString().toLowerCase()); //Capitalized month name
    String expectedDate = format("%s %s,%s", birthDate.getDayOfMonth(), expectedMonth, birthDate.getYear());
    String expectedLocation = format("%s %s", state, city);
    String expectedFileName = imgPath.substring(4);

    @BeforeAll
    static void prepare() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void execute() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(birthDate)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(imgPath)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submitForm()
                .checkTitle("Thanks for submitting the form")
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", expectedDate)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", expectedFileName)
                .checkResult("Address", address)
                .checkResult("State and City", expectedLocation);
    }
}