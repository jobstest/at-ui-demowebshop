package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NewsLetterPage {

    SelenideElement newsLetterInput = $("#newsletter-email");
    SelenideElement subscribeButton = $("#newsletter-subscribe-button");
    SelenideElement infoMessageBlock = $("#newsletter-result-block");

    @Step("Заполнить поле newsletter")
    public void setNewsletterInput(String email) {
        newsLetterInput.setValue(email);
    }

    @Step("Нажать на кнопку 'Subscribe'")
    public void clickSubscribeButton() {
        subscribeButton.click();
    }

    @Step("Проверить сообщение")
    public void checkMessage(String message) {
        infoMessageBlock.shouldHave(text(message));
    }
}
