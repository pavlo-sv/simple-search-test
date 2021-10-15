package com.google.simplesearchtest.model;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

  private final ElementsCollection results = $$("#rso .g");
  private final SelenideElement caclulator = $(".card-section");

  public ElementsCollection getResults() {
    return results;
  }

  public SelenideElement getResult(int index) {
    return results.get(index);
  }

  public String getCalcResult() {
    return caclulator.$("#cwos").getText();
  }

  public void checkResultsSizeIsGreaterThan(int expectedSize) {
    getResults().shouldHave(sizeGreaterThan(expectedSize));
  }

  public void checkResultText(int index, String expectedText) {
    getResult(index).shouldHave(text(expectedText));
  }

  public void checkCalculatorIsVisible() {
    caclulator.shouldBe(visible);
  }
}
