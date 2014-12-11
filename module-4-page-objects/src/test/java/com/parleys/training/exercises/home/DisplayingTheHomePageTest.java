package com.parleys.training.exercises.home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayingTheHomePageTest {

  WebDriver driver;

  @Before
  public void openEtsyHomePage() {
    driver = new FirefoxDriver();
    driver.get("http://www.etsy.com");
  }

  public void shouldShowRecentFavoritesSection() {
    // TODO: Refactor this to use a Serenity Page Object

    String trendingTitle = driver.findElement(By.cssSelector("#trending h2")).getText();
    assertThat(trendingTitle).isIn("Recent Favourites", "Recent Favorites");
  }

  @After
  public void closeDriver() {
    driver.quit();
  }

}
