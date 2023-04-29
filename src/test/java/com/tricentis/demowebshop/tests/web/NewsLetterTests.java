package com.tricentis.demowebshop.tests.web;

import com.tricentis.demowebshop.tests.BaseTests;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("parfionov")
@Severity(SeverityLevel.NORMAL)
@Feature("Подписка")
@Story("Подписка на новости от интернет-магазина")
@DisplayName("Подписка на новости")
public class NewsLetterTests extends BaseTests {
    private String correctEmail = faker.internet().emailAddress();
    private String incorrectEmail = faker.internet().emailAddress() + faker.random();
    private String successfulSubscriptionMessage = "Thank you for signing up! " +
            "A verification email has been sent. We appreciate your interest.";
    private String incorrectEmailMessage = "Enter valid email";

    @Test
    @AllureId("16795")
    @DisplayName("Подписаться на новости")
    void subscribeNews() {
        basePage.openPage("");
        newsLetterPage.setNewsletterInput(correctEmail)
                .clickSubscribeButton()
                .checkMessage(successfulSubscriptionMessage);
    }

    @Test
    @AllureId("16796")
    @DisplayName("Подписаться на новости с некорректной почтой")
    void subscribeNewsIncorrectEmail() {
        basePage.openPage("");
        newsLetterPage.setNewsletterInput(incorrectEmail)
                .clickSubscribeButton()
                .checkMessage(incorrectEmailMessage);
    }

    @Test
    @AllureId("16794")
    @DisplayName("Подписаться на новости с незаполненной почтой")
    void subscribeNewsEmptyEmail() {
        basePage.openPage("");
        newsLetterPage.clickSubscribeButton()
                .checkMessage(incorrectEmailMessage);
    }
}
