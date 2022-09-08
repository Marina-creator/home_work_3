package ru.mine.pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadPictureComponent {

    public UploadPictureComponent uploadPictere(String picture){
        $("#uploadPicture").uploadFromClasspath(picture);
        return this;
    }
}
