package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.pages.AuthFormPage;
import com.tricentis.demowebshop.pages.SaerchStorePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@Owner("parfionov")
@Severity(SeverityLevel.NORMAL)
@Feature("Поиск")
@Story("Поиск товара")
@DisplayName("Поиск товара в поисковой строке")
@Tag("auth")
public class SearchStoreTests extends BaseTests{
    AuthFormPage authFormPage = new AuthFormPage();
    SaerchStorePage saerchStorePage = new SaerchStorePage();

    @CsvSource(value = {
            "Computing and Internet | Computing and Internet",
            "Build your own expensive computer | Build your own expensive computer",
            "14.1-inch Laptop | 14.1-inch Laptop",
            "TCP Self-Paced Training additional month | TCP Self-Paced Training additional month",
            "1MP 60GB Hard Drive Handycam Camcorder | 1MP 60GB Hard Drive Handycam Camcorder",
            "Smartphone | Smartphone",
            "50's Rockabilly Polka Dot Top JR Plus Size | 50's Rockabilly Polka Dot Top JR Plus Size",
            "3rd Album | 3rd Album",
            "Black & White Diamond Heart | Black & White Diamond Heart",
            "$5 Virtual Gift Card | $5 Virtual Gift Card"
    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Поиск в поисковой строке продукта {0}, ожидаем результат: {1}")
    void searchProductAllCategories(String product, String result){
        authFormPage.openPage("");
        saerchStorePage.setSearhInput(product)
                .clickSearchButton()
                .checkProduct(result);
    }

    @ValueSource(strings = {
            "Build your own cheap computer",
            "Build your own computer",
            "Build your own expensive computer",
            "Desktop PC with CDRW",
            "Elite Desktop PC",
            "Simple Computer"
    })
    @ParameterizedTest(name = "Поиск в поисковой строке продукта из категории 'Desktops' {0}")
    void searchProductDekstopsCategory(String product){
        authFormPage.openPage("");
        saerchStorePage.setSearhInput(product)
                .clickSearchButton()
                .checkProduct(product);
    }

    static Stream<Arguments> searchProductCameraPhotoCategory(){
        return Stream.of(
                Arguments.of("1MP 60GB Hard Drive Handycam Camcorder"),
                Arguments.of("Camcorder"),
                Arguments.of("Digital SLR Camera 12.2 Mpixel"),
                Arguments.of("High Definition 3D Camcorder")
        );
    }
    @MethodSource("searchProductCameraPhotoCategory")
    @ParameterizedTest(name = "Поиск в поисковой строке продукта из категории 'Camera, photo'")
    void searchProductCameraPhotoCategory(String product){
        authFormPage.openPage("");
        saerchStorePage.setSearhInput(product)
                .clickSearchButton()
                .checkProduct(product);
    }

    @CsvFileSource(resources = "/doc/test-data-cell-phones.csv", delimiter = '|', numLinesToSkip = 1)
    @ParameterizedTest(name = "Поиск в поисковой строке продукта из категории 'Cell phones'")
    void searchProductCellPhonesCategory(String product, String result){
        authFormPage.openPage("");
        saerchStorePage.setSearhInput(product)
                .clickSearchButton()
                .checkProduct(result);
    }







}
