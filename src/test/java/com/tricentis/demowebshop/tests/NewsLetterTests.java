package com.tricentis.demowebshop.tests;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.pages.AuthFormPage;
import com.tricentis.demowebshop.pages.NewsLetterPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Подписаться на новости")
    void subscribeNews() {
        authFormPage.openPage("");
        newsLetterPage.setNewsletterInput(correctEmail);
        newsLetterPage.clickSubscribeButton();
        newsLetterPage.checkMessage(successfulSubscriptionMessage);
    }

    @Test
    @DisplayName("Подписаться на новости с некорректной почтой")
    void subscribeNewsIncorrectEmail() {
        authFormPage.openPage("");
        newsLetterPage.setNewsletterInput(incorrectEmail);
        newsLetterPage.clickSubscribeButton();
        newsLetterPage.checkMessage(incorrectEmailMessage);
    }

    @Test
    @DisplayName("Подписаться на новости с незаполненной почтой")
    void subscribeNewsEmptyEmail() {
        authFormPage.openPage("");
        newsLetterPage.clickSubscribeButton();
        newsLetterPage.checkMessage(incorrectEmailMessage);
    }
}
