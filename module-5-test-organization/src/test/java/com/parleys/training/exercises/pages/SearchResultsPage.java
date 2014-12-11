package com.parleys.training.exercises.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by john on 18/11/14.
 */
public class SearchResultsPage extends PageObject {

    @FindBy(css=".listing-card")
    List<WebElement> listingCards;

    public void selectItem(int itemNumber) {
        listingCards.get(itemNumber - 1)
                     .findElement(By.tagName("a")).click();
    }

  public String getItemDescription(int itemNumber) {
    return listingCards.get(itemNumber - 1).findElement(By.cssSelector(".title")).getText();
  }

    public List<String> getResultTitles() {
        return listingCards.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

  public String getSearchHeader() {
    return $("#search-header h1").getText();
  }

  public void refineByType(String type) {
     $("#filter-marketplace").then(By.partialLinkText(type)).click();
  }
}
