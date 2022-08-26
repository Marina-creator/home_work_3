package forSelenide2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest2 {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void openComparePlansFromPricing(){
        // На главной странице GitHub выберите меню Pricing -> Compare Plans с помощью команды hover для Pricing.
        // Убедитесь что загрузилась нужная страница (например что заголовок - "Choose the plan that’s right for you."

        open("https://github.com/");
        $("[aria-label=Global]").$(byText("Pricing")).hover();
        $(byText("Compare plans")).click();
        $(".application-main .h1").shouldHave(text("Compare features"));
    }
}
