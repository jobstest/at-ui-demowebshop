package com.tricentis.demowebshop.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.tricentis.demowebshop.helpers.Attach;
import com.tricentis.demowebshop.helpers.DriverSetting;
import com.tricentis.demowebshop.pages.AuthFormPage;
import com.tricentis.demowebshop.pages.BasePage;
import com.tricentis.demowebshop.pages.NewsLetterPage;
import com.tricentis.demowebshop.pages.SaerchStorePage;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTests {
    protected final Faker faker = new Faker();
    protected final BasePage basePage = new BasePage();
    protected final AuthFormPage authFormPage = new AuthFormPage();
    protected final NewsLetterPage newsLetterPage = new NewsLetterPage();
    protected final SaerchStorePage saerchStorePage = new SaerchStorePage();

    @BeforeAll
    static void setUp() {
        DriverSetting.configure();

        SelenideLogger.addListener("allure", new AllureSelenide());

        RestAssured.baseURI = "https://demowebshop.tricentis.com/";
    }

    @AfterEach
    void addAttchments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        WebDriverRunner.closeWindow();
    }
}
