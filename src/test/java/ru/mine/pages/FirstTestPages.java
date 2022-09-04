package ru.mine.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.mine.pages.components.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FirstTestPages {

    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userNumberInput = $("#userNumber"),
    currentAddressInput = $("#currentAddress"),
    subjectInput = $("#subjectsInput"),
    hobbiesInput = $("#hobbiesWrapper");

    private final static String TITLE_TEXT = "Student Registration Form";

    private CalendarComponents calendarComponents = new CalendarComponents();
    private GenderComponent genderComponent = new GenderComponent();
    private ResultModalComponent resultModalComponent = new ResultModalComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private SubmitButtonComponent submitButtonComponent = new SubmitButtonComponent();
    private UploadPictureComponent uploadPictureComponent = new UploadPictureComponent();


    public FirstTestPages openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public FirstTestPages setFirstName(String value){
        firstNameInput.val(value);
        return this;
    }
    public FirstTestPages setLastName(String value){
        lastNameInput.val(value);
        return this;
    }
    public FirstTestPages setEmail(String value){
        userEmailInput.val(value);
        return this;
    }
    public FirstTestPages setNumber(String value){
        userNumberInput.val(value);
        return this;
    }
    public FirstTestPages setCurrentAddress(String value){
        currentAddressInput.val(value);
        return this;
    }
    public FirstTestPages setHobbies(String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public FirstTestPages setSubject(String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    public FirstTestPages setGenderOnPage(String gender){
        genderComponent.setGender(gender);
        return this;
    }

    public FirstTestPages setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public FirstTestPages checkResultModalVisible(){
        resultModalComponent.checkVisible();
        return this;
    }

    public FirstTestPages checkResult(String key, String value){
        resultModalComponent.checkResult(key, value);
        return this;
    }
    public FirstTestPages putStateAndCity(String state, String city){
        stateAndCityComponent.putStateAndCity(state, city);
        return this;
    }
    public FirstTestPages clickSubmitButton(){
        submitButtonComponent.clickSubmit();
        return this;
    }
    public FirstTestPages uploadPicture(String picture){
        uploadPictureComponent.uploadPictere(picture);
        return this;
    }




}
