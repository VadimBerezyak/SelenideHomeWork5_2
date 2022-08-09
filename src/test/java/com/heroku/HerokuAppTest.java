package com.heroku;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HerokuAppTest {
    @BeforeAll
    static void configuration() {
//      Configuration.headless = true;
//      Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
    }
    @BeforeEach
    void beforeEachTEst(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");
    }
    @Test
    void dragAndDropTest(){
        $("#column-a").shouldHave(text("a"));
        $("#column-b").shouldHave(text("b"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
    @Test
    void actionsDragAndDropTest(){
        $("#column-a").shouldHave(text("a"));
        $("#column-b").shouldHave(text("b"));
//        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(30, 0).release().perform();
//        actions().dragAndDropBy($("#column-b"), 250, 0).perform();  todo: выяснить почему не работает
    }
}
