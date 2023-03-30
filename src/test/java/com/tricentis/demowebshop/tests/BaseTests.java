package com.tricentis.demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tricentis.demowebshop.config.SelenoidConfig;
import com.tricentis.demowebshop.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTests {

    @BeforeAll
    static void setUp() {
        SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class);
        String loginSelenoid = config.loginSelenoid();
        String passwordSelenoid = config.passwordSelenoid();
        String uniformResourceNameSelenoid = config.uniformResourceNameSelenoid();

        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.baseUrl = "https://demowebshop.tricentis.com/";
        RestAssured.baseURI = "https://demowebshop.tricentis.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://" + loginSelenoid + ":" + passwordSelenoid + "@" + uniformResourceNameSelenoid +"/wd/hub/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
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
