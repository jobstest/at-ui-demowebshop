package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthFormPage {

    private SelenideElement emailInput = $("#Email");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement buttonLogIn = $(By.xpath("//input[@value='Log in']"));
    private SelenideElement emailAuth = $(".account");
    private SelenideElement errorMessageAuth = $(".message-error");

    private SelenideElement errorMessageAuthEmail = $(".field-validation-error");

    @Step("Открыть страницу")
    public AuthFormPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Заполнить поля 'Email' и 'Password'")
    public AuthFormPage setEmailAndPassword(String email, String password) {
        emailInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку 'Log In'")
    public AuthFormPage clickLogInButton() {
        buttonLogIn.shouldBe(visible);
        buttonLogIn.click();
        return this;
    }

    @Step("Проверить наличие сообщение об ошибке входа")
    public AuthFormPage checkErrorMessageAuth(String message) {
        errorMessageAuth.shouldHave(text(message));
        return this;
    }

    @Step("Проверить наличие сообщение об неправильной почте")
    public AuthFormPage checkErrorMessageEmail(String message) {
        errorMessageAuthEmail.shouldHave(text(message));
        return this;
    }

    @Step("Проверить наличие email")
    public AuthFormPage checkEmail(String email) {
        emailAuth.shouldHave(text(email));
        return this;
    }
}
