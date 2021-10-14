package com.google.simplesearchtest.tests;

import com.google.simplesearchtest.model.SearchPage;
import com.google.simplesearchtest.model.SearchResultsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Owner("pavlo.svynarenko")
@Feature("Search results verification")
public class SearchResultsPageTest extends  BaseTest {

    private final SearchPage searchPage = new SearchPage();
    private final SearchResultsPage results = new SearchResultsPage();

    @BeforeEach
    public void closePrivacyDialog() {
        open("https://google.com");
        if (searchPage.isConfirmationButtonDisplayed()) {
            searchPage.closeConfirmationDialog();
        }
    }

    @Test
    @Description("Verify text search")
    public void searchByTextAndButton() {
        //when
        searchPage.searchWithButton("testcontainers");

        //then
        results.checkResultsSizeIsGreaterThan(1);
        //and
        results.checkResultText(0, "Testcontainers");
    }

    @Test
    @Description("Verify calculation in the search input")
    public void calculateInSearchInput() {
        //when
        searchPage.searchWithEnter("2+2");

        //then
        results.checkCalculatorIsVisible();

        //and
        results.getCalcResult().equals('4');
    }

    @Test
    @Description()
    public void verifyYourLuck() {
        //when
        searchPage.feelingLuckySearch("du.co");

        // then
        $(by("alt", "Duco")).should(exist);
    }
}
