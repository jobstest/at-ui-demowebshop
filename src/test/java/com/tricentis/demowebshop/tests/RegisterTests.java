package com.tricentis.demowebshop.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegisterTests extends BaseTests {

    @Test
    @DisplayName("Ошибки на пустые поля в блоке 'Register'")
    void registrationPage() {
        step("Открыть страницу", () -> {
            open("/register");
        });
        step("Нажать на кнопку 'Register'", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибок на пустые поля", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("* First name is required."))
                    .shouldHave(text("* Last name is required."))
                    .shouldHave(text("* Email is required."))
                    .shouldHave(text("* Password is required."))
                    .shouldHave(text("* Password is required."));
        });

    }
}
