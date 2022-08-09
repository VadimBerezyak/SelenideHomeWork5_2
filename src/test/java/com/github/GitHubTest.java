package com.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
    @BeforeAll
    static void configuration() {
//        Configuration.headless = true;
        Configuration.browser = "firefox";
        Configuration.browserSize = "1024x768";
    }

    @Test
    void someGithubTest() {
        open("https://github.com");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");
        $(byText("Pricing")).hover();
        $("div.dropdown-menu a[href='/pricing#compare-features']").click();
        $$("h2.h3.mt-1").shouldHave(textsInAnyOrder("Free", "Team", "Enterprise"));
        sleep(4000);

    }

}
