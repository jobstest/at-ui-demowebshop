package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AuthFormPage {

    SelenideElement emailInput = $("#Email");
    SelenideElement passwordInput = $("#Password");
    SelenideElement buttonLogIn = $(By.xpath("//input[@value='Log in']"));
    SelenideElement emailAuth = $(".account");
    SelenideElement errorMessageAuth = $(".message-error");

    SelenideElement errorMessageAuthEmail = $(".field-validation-error");


    public AuthFormPage openPage(String url) {
        step("Открыть страницу", () -> {
            open(url);
        });

        return this;
    }

    public AuthFormPage setEmailAndPassword(String email, String password) {
        step("Заполнить поля 'Email' и 'Password'", () -> {
            emailInput.setValue(email);
            passwordInput.setValue(password);
        });

        return this;
    }

    public AuthFormPage clickLogInButton() {
        step("Нажать на кнопку 'Log In'", () -> {
            buttonLogIn.click();
        });

        return this;
    }

    public AuthFormPage checkErrorMessageAuth(String message) {
        step("Проверить наличие сообщение об ошибке входа", () -> {
            errorMessageAuth.shouldHave(text(message));
        });

        return this;
    }

    public AuthFormPage checkErrorMessageEmail(String message) {
        step("Проверить наличие сообщение об неправильной почте", () -> {
            errorMessageAuthEmail.shouldHave(text(message));
        });

        return this;
    }

    public AuthFormPage checkEmail(String email) {
        step("Проверить наличие email", () -> {
            emailAuth.shouldHave(text(email));
        });

        return this;
    }
}
