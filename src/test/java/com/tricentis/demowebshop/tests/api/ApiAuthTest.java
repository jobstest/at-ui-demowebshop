package com.tricentis.demowebshop.tests.api;

import com.codeborne.selenide.WebDriverRunner;
import com.tricentis.demowebshop.config.AuthConfig;
import com.tricentis.demowebshop.tests.BaseTests;
import io.qameta.allure.restassured.AllureRestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.tricentis.demowebshop.helpers.CustomApiListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class ApiAuthTest extends BaseTests {
    AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
    String correctEmail = config.correctEmail();
    String correctPassword = config.correctPassword();
    String authCookieName = "NOPCOMMERCE.AUTH";

    @Test
    @DisplayName("Aвторизация c зарегистрированными почтой и паролем (API + UI)")
    void authWithRegisteredEmailAndPassword() {
        step("Получить сookie api и вставить их в браузер", () -> {
            String authCookieValue = given()
                    .filter(withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("Email", correctEmail)
                    .formParam("Password", correctPassword)
                    .log().all()
                    .when()
                    .post("/login")
                    .then()
                    .log().all()
                    .statusCode(302)
                    .extract().cookie(authCookieName);

            step("Открыть минимальный контент, чтобы сookie можно было вставить, когда открыт сайт", () -> {
                open("/Themes/DefaultClean/Content/images/logo.png");
            });
            step("Вставить сookie в браузер", () -> {
                Cookie authCookie = new Cookie(authCookieName, authCookieValue);
                WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
            });
        });
        step("Открыть главную страницу", () -> {
            open("/");
        });
        step("Проверить наличие email", () -> {
            $(".account").shouldHave(text(correctEmail));
        });
    }
}
