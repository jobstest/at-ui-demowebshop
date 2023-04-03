package com.tricentis.demowebshop.tests.ChatGpt;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.tricentis.demowebshop.tests.BaseTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Owner("parfionov")
@Feature("ChatGpt")
@Story("Корректировка тестов в ChatGpt")
@DisplayName("Корректировка тестов из ChatGpt")
public class CorrectChatGptTests extends BaseTests {

    @Test
    @DisplayName("Откорректированный тест ChatGpt")
    public void addBookToCartCorrect() {
        /*Write Selenide, Java, Gradle code to open https://demowebshop.tricentis.com / by Test example: Add an item to the cart
          1 Go to the BOOKS tab
          2 In the "Computers and Internet" section, click on the "Add to cart" button
          Check: 1 appeared in the shopping cart
          3 Open the shopping cart
          Check: the book "Computers and the Internet" has been added
          4 Click on the checkbox
          5 Click on the Update Shopping Cart button
          Result: There is no 1 and no books Computers and Internet on the Shopping Cart page*/

        // Set up Selenide Configuration
        Configuration.browser = "chrome";

        // Open the website
        Selenide.open("https://demowebshop.tricentis.com");

        // Go to the BOOKS tab
        SelenideElement booksTab = $("a[href='/books']");
        booksTab.click();

        // Click on the "Add to cart" button for "Computers and Internet"
        SelenideElement addToCartButton = $(By.xpath("//*[@href='/computing-and-internet']/ancestor::div[@class='details']//div[@class='buttons']/input"));
        addToCartButton.click();

        // Check that "1" appears in the shopping cart
        SelenideElement cartQuantity = $("span.cart-qty");
        cartQuantity.shouldHave(text("1"));

        // Open the shopping cart
        SelenideElement cartLink = $("a[href='/cart']");
        cartLink.click();

        // Check that the book "Computers and Internet" has been added
        SelenideElement cartItem = $("table.cart tbody tr:first-child td.product");
        cartItem.shouldHave(text("Computing and Internet"));

        // Click on the checkbox and update the shopping cart
        SelenideElement checkbox = $("input[type='checkbox']");
        checkbox.click();
        SelenideElement updateCartButton = $(By.name("updatecart"));
        updateCartButton.click();

        // Check that there is no "1" and no books "Computers and Internet" in the shopping cart
        SelenideElement shoppingCartPage = $(".center-1");
        shoppingCartPage.shouldNotBe(text("1"));
        shoppingCartPage.shouldNotHave(text("Computers and Internet"));
    }
}
