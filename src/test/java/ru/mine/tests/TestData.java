package ru.mine.tests;

import com.github.javafaker.Faker;

import static java.lang.String.format;

public class TestData {
    static Faker faker = new Faker();
    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            day = "17",
            month = "December",
            year = "1992",
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            userAddress = faker.address().fullAddress(),
            userHobbies = "Reading",
            userGender = "Female",
            userSubject = "Economics",
            state = "Haryana",
            city = "Karnal",
            pathToPicture = "picture/1.jpg",
            namePicture = pathToPicture.substring(1, pathToPicture.indexOf("/")),
//            namePicture = "1.jpg",
            checkStateAndCity = format("%s %s", state, city),
            checkFullName = format("%s %s", firstName, lastName),
            checkDateOfBirth = format("%s %s,%s", day, month, year);
}
