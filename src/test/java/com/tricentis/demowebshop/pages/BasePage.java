package com.tricentis.demowebshop.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
public class BasePage {

    @Step("Открыть страницу")
    public BasePage openPage(String url) {
        open(url);
        return this;
    }
}
