package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SaerchStorePage {

    SelenideElement searchStoreInput = $("#small-searchterms");
    SelenideElement buttonSearch = $(By.xpath("//input[@value='Search']"));
    SelenideElement pageCategories = $(".page-body");

    public SaerchStorePage setSearhInput(String product){
        step("Заполнить поле 'Saerch store'", () ->{
            searchStoreInput.setValue(product);
        });
        return this;
    }

    public SaerchStorePage clickSearchButton(){
        step("Нажать на кнопку 'Saerch'", () -> {
            buttonSearch.click();
        });

        return this;
    }

    public SaerchStorePage checkProduct(String product) {
        step("Проверить наличие товара", () -> {
            pageCategories.shouldHave(text(product));
        });

        return this;
    }
}
