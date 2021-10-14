package com.google.simplesearchtest.model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement searchInput = $(byName("q"));
    private final SelenideElement searchButton = $(byName("btnK"));
    private final SelenideElement luckyButton = $(byName("btnI"));
    private final SelenideElement confirmationButton = $(byId("L2AGLb"));

    public void hasSearchInput() {
        searchInput.should(exist);
    }

    public void hasSearchButton() {
        searchButton.should(exist);
    }

    public void hasLuckyButton() {
        luckyButton.should(exist);
    }

    public boolean isConfirmationButtonDisplayed() {
        return confirmationButton.is(visible);
    }

    public void closeConfirmationDialog() {
        confirmationButton.click();
    }

    public void searchWithButton(String textToSearch) {
        searchInput.val(textToSearch);
        searchButton.click();
    }

    public void searchWithEnter(String textToSearch) {
        searchInput.val(textToSearch).pressEnter();
    }

    public void feelingLuckySearch(String textToSearch) {
        searchInput.val(textToSearch);
        luckyButton.click();
    }
}
