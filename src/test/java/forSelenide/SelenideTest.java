package forSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void openGithub(){
        // Откройте страницу Selenide в Github
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        $("#wiki-content").shouldHave(text("Welcome to the selenide wiki!"));

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$("[data-filterable-for=wiki-pages-filter] li").last().$("[type=button]").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        //Откройте страницу SoftAssertions
        $("#wiki-pages-box").$("a[href*='SoftAssertions']").click();

        // проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
