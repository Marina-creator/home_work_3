package ru.mine;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FirstTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
    }

    @Test
    void testForm() {

    }

}
