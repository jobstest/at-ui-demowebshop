package com.tricentis.demowebshop.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("parfionov")
@Feature("Регистрация")
@Story("Cоздание учетной записи в интернет-магазине")
@DisplayName("Регистрация на странице")
public class RegisterTests extends BaseTests {

    Faker faker = new Faker();
    String incorrectEmail = faker.internet().emailAddress() + faker.random();
    Name firstName = faker.name();
    Name lastName = faker.name();
    String password = faker.internet().password();
    String incorrectPassword = faker.internet().password(1, 5);

    @Test
    @AllureId("16797")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Ошибки на пустые поля в блоке 'Register'")
    void emptyFieldRegPage() {
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

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Ошибка на некорректную почту в поле Email")
    void errorIncorrectEmailsRegPage() {
        step("Открыть страницу регистрации", () -> {
            open("/register");
        });
        step("В поле Email ввести некорректную почту", () -> {
            $("#Email").setValue(incorrectEmail);
        });
        step("Нажать на кнопку Register", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибки:  * Wrong email", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("* Wrong email"));
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Ошибка на некорректный пароль в поле Password")
    void errorIncorrectPasswordRegPage() {
        step("Открыть страницу регистрации", () -> {
            open("/register");
        });
        step("В поле Password ввести некорректную почту", () -> {
            $("#Password").setValue(incorrectPassword);
        });
        step("Нажать на кнопку Register", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибки:  The password should have at least 6 characters.", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("The password should have at least 6 characters."));
        });
    }

    @Test
    @Deprecated
    @DisplayName("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    void inputAllFieldsRegPage() {
        step("Открыть страницу Register", () -> {
            open("/register");
        });
        step("Нажать на радиокнопку Male", () -> {
            $("#gender-male").click();
        });
        step("Заполнить поле First name", () -> {
            $("#FirstName").setValue(String.valueOf(firstName));
        });
        step("Заполнить поле Last name", () -> {
            $("#LastName").setValue(String.valueOf(lastName));
        });
        step("Заполнить поле Email некорректной почтой", () -> {
            $("#Email").setValue(incorrectEmail);
        });
        step("Заполнить поле Password", () -> {
            $("#Password").setValue(password);
        });
        step("Заполнить поле Confirm password", () -> {
            $("#ConfirmPassword").setValue(password);
        });
        step("Нажать на кнопку 'Register'", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибок на пустые поля", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("* Wrong email"));
        });
    }
}
