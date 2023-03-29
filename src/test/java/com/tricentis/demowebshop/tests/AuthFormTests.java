package com.tricentis.demowebshop.tests;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.config.AuthConfig;
import com.tricentis.demowebshop.pages.AuthFormPage;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.nio.file.attribute.UserDefinedFileAttributeView;

@Owner("parfionov")
@Severity(SeverityLevel.BLOCKER)
@Feature("Aутентификация")
@Story("Возможность войти в ЛК")
@DisplayName("Аутентификация на странице")
@Tag("auth")
public class AuthFormTests extends BaseTests{

    AuthConfig config = ConfigFactory.create(AuthConfig.class);
    AuthFormPage authFormPage = new AuthFormPage();
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String incorrectEmail = faker.internet().emailAddress() + faker.random();
    String password = faker.internet().password();
    String correctEmail = config.correctEmail();
    String correctPassword = config.correctPassword();

    @Test
    @DisplayName("Aутентификация c зарегистрированными почтой и паролем")
    void authWithRegisteredEmailAndPassword(){
        authFormPage.openLogOnPage("/login")
                .setEmailAndPassword(correctEmail, correctPassword)
                .clickLogInButton()
                .checkEmail("test_web_shop@mail.ru");
    }

    @Test
    @DisplayName("Aутентификация c не зарегистрированной почтой")
    void authWithNotRegisteredEmail(){
        authFormPage.openLogOnPage("/login")
                .setEmailAndPassword(email, correctPassword)
                .clickLogInButton()
                .checkErrorMessageAuth("Login was unsuccessful. Please correct the errors and try again.\n" +
                        "No customer account found");
    }

    @Test
    @DisplayName("Aутентификация с не зарегистрированным паролем")
    void authWithNotRegisteredPassword(){
        authFormPage.openLogOnPage("/login")
                .setEmailAndPassword(correctEmail, password)
                .clickLogInButton()
                .checkErrorMessageAuth("Login was unsuccessful. Please correct the errors and try again.\n" +
                        "The credentials provided are incorrect");
    }

    @Test
    @DisplayName("Aутентификация c не заполненными  почтой и паролем")
    void authWithEmptyEmailAndPassword(){
        authFormPage.openLogOnPage("/login")
                .clickLogInButton()
                .checkErrorMessageAuth("Login was unsuccessful. Please correct the errors and try again.\n" +
                        "No customer account found");
    }

    @Test
    @DisplayName("Aутентификация c не заполненными  почтой и паролем")
    void authWithIncorrectEmail(){
        authFormPage.openLogOnPage("/login")
                .setEmailAndPassword(incorrectEmail, "")
                .clickLogInButton()
                .checkErrorMessageEmail("Please enter a valid email address.");
    }
}
