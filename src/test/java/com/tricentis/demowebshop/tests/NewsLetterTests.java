package com.tricentis.demowebshop.tests;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.pages.AuthFormPage;
import com.tricentis.demowebshop.pages.NewsLetterPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("parfionov")
@Severity(SeverityLevel.NORMAL)
@Feature("Подписка")
@Story("Подписка на новости от интернет-магазина")
@DisplayName("Подписка на новости")
public class NewsLetterTests extends BaseTests {
    AuthFormPage authFormPage = new AuthFormPage();
    NewsLetterPage newsLetterPage = new NewsLetterPage();
    Faker faker = new Faker();
    String correctEmail = faker.internet().emailAddress();
    String incorrectEmail = faker.internet().emailAddress() + faker.random();
    String successfulSubscriptionMessage = "Thank you for signing up! " +
            "A verification email has been sent. We appreciate your interest.";
    String incorrectEmailMessage = "Enter valid email";

    @Test
    @AllureId("16795")
    @DisplayName("Подписаться на новости")
    void subscribeNews() {
        authFormPage.openPage("");
        newsLetterPage.setNewsletterInput(correctEmail);
        newsLetterPage.clickSubscribeButton();
        newsLetterPage.checkMessage(successfulSubscriptionMessage);
    }

    @Test
    @AllureId("16796")
    @DisplayName("Подписаться на новости с некорректной почтой")
    void subscribeNewsIncorrectEmail() {
        authFormPage.openPage("");
        newsLetterPage.setNewsletterInput(incorrectEmail);
        newsLetterPage.clickSubscribeButton();
        newsLetterPage.checkMessage(incorrectEmailMessage);
    }

    @Test
    @AllureId("16794")
    @DisplayName("Подписаться на новости с незаполненной почтой")
    void subscribeNewsEmptyEmail() {
        authFormPage.openPage("");
        newsLetterPage.clickSubscribeButton();
        newsLetterPage.checkMessage(incorrectEmailMessage);
    }
}
