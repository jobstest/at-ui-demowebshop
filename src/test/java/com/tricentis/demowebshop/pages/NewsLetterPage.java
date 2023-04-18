package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewsLetterPage {

    private SelenideElement newsLetterInput = $("#newsletter-email");
    private SelenideElement subscribeButton = $("#newsletter-subscribe-button");
    private SelenideElement infoMessageBlock = $("#newsletter-result-block");

    @Step("Заполнить поле newsletter")
    public NewsLetterPage setNewsletterInput(String email) {
        newsLetterInput.shouldBe(visible);
        newsLetterInput.setValue(email);
        return this;
    }

    @Step("Нажать на кнопку 'Subscribe'")
    public NewsLetterPage clickSubscribeButton() {
        subscribeButton.shouldBe(visible);
        subscribeButton.click();
        return this;
    }

    @Step("Проверить сообщение")
    public NewsLetterPage checkMessage(String message) {
        infoMessageBlock.shouldHave(text(message));
        return this;
    }
}
