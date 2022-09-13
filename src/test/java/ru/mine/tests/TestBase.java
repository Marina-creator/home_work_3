package ru.mine.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.mine.pages.FirstTestPages;

import static java.lang.String.format;
import static ru.mine.tests.TestData.*;
import static ru.mine.tests.TestData.pathToPicture;

public class TestBase {

    static FirstTestPages firstTestPages = new FirstTestPages();

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;

    }

    @BeforeEach
    void setBeforeEach(){
        firstTestPages.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setNumber(userNumber)
                .setCurrentAddress(userAddress)
                .setHobbies(userHobbies)
                .setDateOfBirth(day, month, year)
                .setGenderOnPage(userGender)
                .setSubject(userSubject)
                .putStateAndCity(state, city)
                .uploadPicture(pathToPicture);
    }
}
