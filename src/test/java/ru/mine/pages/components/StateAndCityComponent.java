package ru.mine.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {

    public StateAndCityComponent putStateAndCity(String state, String city){
        $("#state").click();
        $("#stateCity-wrapper").$(byText (state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText (city)).click();
        return this;
    }
}
