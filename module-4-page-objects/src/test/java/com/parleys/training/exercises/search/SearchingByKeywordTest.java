package com.parleys.training.exercises.search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchingByKeywordTest {

  WebDriver driver;

  @Before
  public void openEtsyHomePage() {
    driver = new FirefoxDriver();
    driver.get("http://www.etsy.com");
  }

  @Test
  public void shouldBeAbleToSearchByKeyword() {
    // TODO: Refactor this to use two Serenity Page Objects

    driver.findElement(By.id("search-query")).sendKeys("shoes");
    driver.findElement(By.cssSelector(".btn-primary[value='Search']")).click();

    String summaryText = driver.findElement(By.cssSelector("#search-header h1")).getText();
    assertThat(summaryText).contains("shoes");
  }

  @Test
  public void shouldBeAbleToSearchByKeywordAndRefineByItemType() {
    // TODO: Refactor this to use two Serenity Page Objects

    driver.findElement(By.id("search-query")).sendKeys("shoes");
    driver.findElement(By.cssSelector(".btn-primary[value='Search']")).click();

    driver.findElement(By.id("filter-marketplace")).findElement(By.partialLinkText("Vintage")).click();

    String summaryText = driver.findElement(By.cssSelector("#search-header h1")).getText();
    assertThat(summaryText).contains("shoes");
  }

  @Test
  public void shouldOnlyDisplayRelatedItemsInSearchResults() {
    // TODO: Refactor this to use two Serenity Page Objects

    driver.findElement(By.id("search-query")).sendKeys("shoes");
    driver.findElement(By.cssSelector(".btn-primary[value='Search']")).click();

    driver.findElements(By.cssSelector(".listing-card")).stream()
      .forEach(element -> assertThat(element.getText().contains("shoes")));
  }

  @After
  public void closeDriver() {
    driver.quit();
  }

}
