package com.tricentis.demowebshop.tests.web;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.config.AuthConfig;
import com.tricentis.demowebshop.pages.AuthFormPage;
import com.tricentis.demowebshop.pages.BasePage;
import com.tricentis.demowebshop.tests.BaseTests;
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
    BasePage basePage = new BasePage();
    AuthFormPage authFormPage = new AuthFormPage();
    Faker faker = new Faker();
    private String email = faker.internet().emailAddress();
    private String incorrectEmail = faker.internet().emailAddress() + faker.random();
    private String password = faker.internet().password();
    private final String correctEmail = config.correctEmail();
    private final String correctPassword = config.correctPassword();
    private String errorMessageEmailPassword = "Login was unsuccessful. Please correct the errors and try again. No customer account found";
    private String errorMessagePassword = "Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect";
    private String errorMessageEmail = "Please enter a valid email address.";

    @Test
    @Tag("auth")
    @AllureId("16791")
    @DisplayName("Aвторизация c зарегистрированными почтой и паролем")
    void authWithRegisteredEmailAndPassword() {
        basePage.openPage("/login");
        authFormPage.setEmailAndPassword(correctEmail, correctPassword)
                .clickLogInButton()
                .checkEmail(correctEmail);
    }

    @Test
    @AllureId("16789")
    @DisplayName("Aвторизация c не зарегистрированной почтой")
    void authWithNotRegisteredEmail() {
        basePage.openPage("/login");
        authFormPage.setEmailAndPassword(email, correctPassword)
                .clickLogInButton()
                .checkErrorMessageAuth(errorMessageEmailPassword);
    }

    @Test
    @AllureId("16790")
    @DisplayName("Aвторизация c не заполненными  почтой и паролем")
    void authWithEmptyEmailAndPassword() {
        basePage.openPage("/login");
        authFormPage.clickLogInButton()
                .checkErrorMessageAuth(errorMessageEmailPassword);
    }

    @Test
    @AllureId("16793")
    @DisplayName("Aвторизация с не зарегистрированным паролем")
    void authWithNotRegisteredPassword() {
        basePage.openPage("/login");
        authFormPage.setEmailAndPassword(correctEmail, password)
                .clickLogInButton()
                .checkErrorMessageAuth(errorMessagePassword);
    }

    @Test
    @AllureId("16792")
    @DisplayName("Aвторизация c некорректной почтой")
    void authWithIncorrectEmail() {
        basePage.openPage("/login");
        authFormPage.setEmailAndPassword(incorrectEmail, "")
                .clickLogInButton()
                .checkErrorMessageEmail(errorMessageEmail);
    }
}
