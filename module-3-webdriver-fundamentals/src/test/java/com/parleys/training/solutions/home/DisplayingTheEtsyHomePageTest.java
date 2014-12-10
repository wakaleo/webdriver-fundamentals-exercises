package com.parleys.training.solutions.home;

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
    assertThat(trendingTitle).isEqualTo("Recent Favourites");
  }

  @Test
  public void shouldBeAbleToSearchByKeyword() {
    driver.findElement(By.id("search-query")).sendKeys("shoes");
    driver.findElement(By.cssSelector(".btn-primary[value='Search']")).click();

    String summaryText = driver.findElement(By.cssSelector("#search-header h1")).getText();
    assertThat(summaryText).contains("shoes");
  }

  @Test
  public void shouldBeAbleToSearchByKeywordAndRefineByItemType() {
    driver.findElement(By.id("search-query")).sendKeys("shoes");
    driver.findElement(By.cssSelector(".btn-primary[value='Search']")).click();

    driver.findElement(By.id("filter-marketplace")).findElement(By.partialLinkText("Vintage")).click();

    String summaryText = driver.findElement(By.cssSelector("#search-header h1")).getText();
    assertThat(summaryText).contains("shoes");
  }

  @After
  public void closeDriver() {
    driver.quit();
  }

}
