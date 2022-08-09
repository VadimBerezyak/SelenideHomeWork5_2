package com.heroku;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;

public class HerokuAppTest {
    @BeforeAll
    static void configuration() {
//      Configuration.headless = true;
        Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
    }
    @Test
    void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));

    }
}
