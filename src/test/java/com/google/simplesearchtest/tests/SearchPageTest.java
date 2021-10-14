package com.google.simplesearchtest.tests;

import com.google.simplesearchtest.model.SearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Owner("pavlo.svynarenko")
public class SearchPageTest extends BaseTest {

    private final SearchPage searchPage = new SearchPage();

    @Feature("Home page verification")
    @Test
    @Description("Verify home page is properly loaded")
    public void searchPageShouldHaveElementsLoaded() {
        //when
        open("https://google.com");
        if (searchPage.isConfirmationButtonDisplayed()) {
            searchPage.closeConfirmationDialog();
        }

        //then
        searchPage.hasSearchInput();
        searchPage.hasSearchButton();
        searchPage.hasLuckyButton();
    }

}
