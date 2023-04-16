package com.tricentis.demowebshop.tests.web.chatgpt;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.tricentis.demowebshop.tests.BaseTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Owner("parfionov")
@Feature("ChatGpt")
@Story("Создание тестов в ChatGpt")
@DisplayName("Создание тестов из ChatGpt")
public class ChatGptTests extends BaseTests {

    @Test
    @Disabled
    @DisplayName("Тест сгенерированный ChatGpt")
    public void addBookToCart() {
        // Set up Selenide Configuration
        Configuration.browser = "chrome";
        //Configuration.startMaximized = true;

        // Open the website
        Selenide.open("https://demowebshop.tricentis.com");

        // Go to the BOOKS tab
        SelenideElement booksTab = $("a[href='/books']");
        booksTab.click();

        // Click on the "Add to cart" button for "Computers and Internet"
        SelenideElement addToCartButton = $("button[data-productid='13']");
        addToCartButton.click();

        // Check that "1" appears in the shopping cart
        SelenideElement cartQuantity = $("span.cart-qty");
        cartQuantity.shouldHave(text("1"));

        // Open the shopping cart
        SelenideElement cartLink = $("a[href='/cart']");
        cartLink.click();

        // Check that the book "Computers and Internet" has been added
        SelenideElement cartItem = $("table.cart tbody tr:first-child");
        cartItem.shouldHave(text("Computers and Internet"));

        // Click on the checkbox and update the shopping cart
        SelenideElement checkbox = $("input[type='checkbox']");
        checkbox.click();
        SelenideElement updateCartButton = $("button[name='updatecart']");
        updateCartButton.click();

        // Check that there is no "1" and no books "Computers and Internet" in the shopping cart
        cartQuantity.shouldNotBe(text("1"));
        cartItem.shouldNotHave(text("Computers and Internet"));
    }
}
//Please note that this code assumes that you have imported the Selenide library and
//the appropriate Java libraries into your project. Also, you may need to update the CSS selectors used in the code
// if the website's HTML structure changes.
