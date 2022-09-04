package ru.mine.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.mine.pages.FirstTestPages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTestWithPageObjects {

    FirstTestPages firstTestPages = new FirstTestPages();

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void testRegistrationForm() {
        firstTestPages.openPage()
            .setFirstName("Marina")
            .setLastName("Abakumova")
            .setEmail("Abakumova@mine.ru")
            .setNumber("9998887766")
            .setCurrentAddress("Georgia, Batumi")
            .setHobbies("Reading")
            .setDateOfBirth("17", "December", "1992")
            .setGenderOnPage("Female")
            .setSubject("Economics")
            .putStateAndCity("Haryana", "Karnal");


        firstTestPages.uploadPicture("picture/1.jpg");

        firstTestPages.clickSubmitButton();

        firstTestPages.checkResultModalVisible();

        firstTestPages.checkResult("Label", "Values")
                .checkResult("Student Name", "Marina Abakumova")
                .checkResult("Student Email", "Abakumova@mine.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9998887766")
                .checkResult("Date of Birth", "17 December,1992")
                .checkResult("Subjects", "Economics")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "1.jpg")
                .checkResult("Address", "Georgia, Batumi")
                .checkResult("State and City", "Haryana Karnal");


    }

}
