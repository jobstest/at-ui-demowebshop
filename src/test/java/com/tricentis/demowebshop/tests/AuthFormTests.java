package com.tricentis.demowebshop.tests;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.config.AuthConfig;
import com.tricentis.demowebshop.pages.AuthFormPage;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Owner("parfionov")
@Severity(SeverityLevel.BLOCKER)
@Feature("Aвторизация")
@Story("Возможность войти в ЛК")
@Tag("auth")
@DisplayName("Aвторизация на странице")
public class AuthFormTests extends BaseTests {

    AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
    AuthFormPage authFormPage = new AuthFormPage();
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String incorrectEmail = faker.internet().emailAddress() + faker.random();
    String password = faker.internet().password();
    String correctEmail = config.correctEmail();
    String correctPassword = config.correctPassword();
    String errorMessageEmailPassword = "Login was unsuccessful. Please correct the errors and try again. No customer account found";
    String errorMessagePassword = "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect";
    String errorMessageEmail = "Please enter a valid email address.";

    @Test
    @Tag("auth")
    @AllureId("16791")
    @DisplayName("Aвторизация c зарегистрированными почтой и паролем")
    void authWithRegisteredEmailAndPassword() {
        authFormPage.openPage("/login")
                .setEmailAndPassword(correctEmail, correctPassword)
                .clickLogInButton()
                .checkEmail(correctEmail);
    }

    @Test
    @AllureId("16789")
    @DisplayName("Aвторизация c не зарегистрированной почтой")
    void authWithNotRegisteredEmail() {
        authFormPage.openPage("/login")
                .setEmailAndPassword(email, correctPassword)
                .clickLogInButton()
                .checkErrorMessageAuth(errorMessageEmailPassword);
    }

    @Test
    @AllureId("16793")
    @DisplayName("Aвторизация с не зарегистрированным паролем")
    void authWithNotRegisteredPassword() {
        authFormPage.openPage("/login")
                .setEmailAndPassword(correctEmail, password)
                .clickLogInButton()
                .checkErrorMessageAuth(errorMessagePassword);
    }

    @Test
    @AllureId("16790")
    @DisplayName("Aвторизация c не заполненными  почтой и паролем")
    void authWithEmptyEmailAndPassword() {
        authFormPage.openPage("/login")
                .clickLogInButton()
                .checkErrorMessageAuth(errorMessageEmailPassword);
    }

    @Test
    @AllureId("16792")
    @DisplayName("Aвторизация c некорректной почтой")
    void authWithIncorrectEmail() {
        authFormPage.openPage("/login")
                .setEmailAndPassword(incorrectEmail, "")
                .clickLogInButton()
                .checkErrorMessageEmail(errorMessageEmail);
    }
}
