package forselenide2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest {

    @BeforeAll
    static void setUp(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.baseUrl = " https://the-internet.herokuapp.com";
    }

    @Test
    void testForChengesBoxes(){
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");
        // Перенесите прямоугольник А на место В
        actions().moveToElement($("#column-a")).clickAndHold()
            .moveToElement($("#column-b")).release().perform();
        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        // до проверки работает, но проверка не проходит почему-то
    }

    @Test
    void testForChengesBoxesSeconVariation(){
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");
        //В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест,
        // если использовать её вместо actions()
        $("#column-a").dragAndDropTo($("#column-b"));
        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));

        // в этом случае тест работает, в чем ошибка в первом варианте, поясните, пожалуйста?
    }


}
