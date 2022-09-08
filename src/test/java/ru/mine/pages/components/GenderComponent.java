package ru.mine.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GenderComponent {

    public GenderComponent setGender(String gender){
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }
}
