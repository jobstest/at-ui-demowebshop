package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SaerchStorePage {

    private SelenideElement searchStoreInput = $("#small-searchterms");
    private SelenideElement buttonSearch = $(By.xpath("//input[@value='Search']"));
    private SelenideElement pageCategories = $(".page-body");

    @Step("Заполнить поле 'Saerch store'")
    public SaerchStorePage setSearhInput(String product) {
        searchStoreInput.shouldBe(visible);
        searchStoreInput.setValue(product);
        return this;
    }

    @Step("Нажать на кнопку 'Saerch'")
    public SaerchStorePage clickSearchButton() {
        buttonSearch.shouldBe(visible);
        buttonSearch.click();
        return this;
    }

    @Step("Проверить наличие товара")
    public SaerchStorePage checkProduct(String product) {
        pageCategories.shouldHave(text(product));
        return this;
    }
}
