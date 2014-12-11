package com.parleys.training.exercises.home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayingTheEtsyHomePageTest {

  WebDriver driver;

  @Before
  public void openEtsyHomePage() {
    driver = new FirefoxDriver();
    driver.get("http://www.etsy.com");
  }

  @Test
  public void shouldShowRecentFavoritesSection() {
    String trendingTitle = driver.findElement(By.cssSelector("#trending h2")).getText();
    assertThat(trendingTitle).isIn("Recent Favorites", "Recent Favourites");
  }

  @Test
  public void shouldBeAbleToSearchByKeyword() {
    // TODO: 1) Implement a search that enters 'shoes' into the search field and clicks on the search button
    // TODO: 2) Check that the word "shoes" appears in the 'Show results for:' text
  }

  @Test
  public void shouldBeAbleToSearchByKeywordAndRefineByItemType() {
    // TODO: 1) Implement a search that enters 'shoes' into the search field and clicks on the search button
    // TODO: 2) On the results page, filter by Item Type 'Vintage'
    // TODO: 3) Check that the word "shoes" appears in the 'Show results for:' text
  }

  @Test
  public void shouldOnlyDisplayRelatedItemsInSearchResults() {
    // TODO: 1) Implement a search that enters 'shoes' into the search field and clicks on the search button
    // TODO: 2) Ensure that each item in the search results contains the word 'shoes' in the title
  }

  @After
  public void closeDriver() {
    driver.quit();
  }

}
