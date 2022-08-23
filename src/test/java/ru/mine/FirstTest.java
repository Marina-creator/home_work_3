package ru.mine;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
    //    Configuration.browserSize = "1366 x 768";

    }

    @AfterAll
    static void setUpAfter(){
        sleep(4000);
    }

    @Test
    void testRegistrationForm() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").val("Marina");
        $("#lastName").val("Abakumova");
        $("#userEmail").val("Abakumova@mine.ru");
        $("#userNumber").val("9998887766");
        $("#currentAddress").val("Georgia, Batumi");

        $("#gender-radio-2").parent().click();
        $("#hobbies-checkbox-2").parent().click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--017:not(.react-datepicker__day--outside-month").click();

        $("#subjectsInput").setValue("Economics").pressEnter();

        $("#uploadPicture").uploadFromClasspath("picture/1.jpg");

        $("#state").click();
        $("#stateCity-wrapper").$(byText ("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText ("Karnal")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(text("Marina"), text("Abakumova"),
                text("Abakumova@mine.ru"), text("9998887766"), text("Georgia, Batumi"), text("Economics"),
                text("1.jpg"), text("Haryana"), text("Karnal"));
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text("17 December,1992"));
    }

}
