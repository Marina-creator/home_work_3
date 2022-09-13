package ru.mine.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mine.pages.FirstTestPages;

import static java.lang.String.format;
import static ru.mine.tests.TestData.*;

public class FirstTestWithTestData extends TestBase {
    FirstTestPages firstTestPages = new FirstTestPages();

    @Test
    void testRegistrationForm() {
        firstTestPages.clickSubmitButton();

        firstTestPages.checkResultModalVisible();


        firstTestPages.checkResult("Label", "Values")
                .checkResult("Student Name", checkFullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", checkDateOfBirth)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", namePicture)
                .checkResult("Address", userAddress)
                .checkResult("State and City", checkStateAndCity);


    }

}
