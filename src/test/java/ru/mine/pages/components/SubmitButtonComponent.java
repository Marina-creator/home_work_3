package ru.mine.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubmitButtonComponent {

    public SubmitButtonComponent clickSubmit(){
        $("#submit").click();
        return this;
    }
}
