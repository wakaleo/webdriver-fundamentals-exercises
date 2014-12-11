package com.parleys.training.solutions.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DefaultUrl("http://www.etsy.com")
public class HomePage extends PageObject {

  @CacheLookup
  @FindBy(id = "search-query")
  WebElement searchQuery;

  @FindBy(css = "button[value='Search']")
  WebElement searchButton;

  public void searchFor(String keywords) {
    searchQuery.sendKeys(keywords);
    searchButton.click();
    waitFor("#search-header");
  }

  public String getTrendingTitle() {
    return $("#trending h2").getText();
  }
}
