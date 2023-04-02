package com.tricentis.demowebshop.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("parfionov")
@Feature("Регистрация")
@Story("Возможность создания учетной записи в интернет-магазине")
@DisplayName("Регистрация на странице")
public class RegisterTests extends BaseTests {

    @Test
    @DisplayName("Ошибки на пустые поля в блоке 'Register'")
    @Severity(SeverityLevel.NORMAL)
    void registrationPage() {
        step("Открыть страницу", () -> {
            open("/register");
        });
        step("Нажать на кнопку 'Register'", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибок на пустые поля", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("* First name is required."),
                            text("* Last name is required."),
                            text("* Email is required."),
                            text("* Password is required."),
                            text("* Password is required."));
        });
    }
}
