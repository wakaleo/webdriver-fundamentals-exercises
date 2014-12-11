package com.parleys.training.solutions.home;

import com.parleys.training.solutions.pages.HomePage;
import com.parleys.training.solutions.steps.EtsyBuyer;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class DisplayingTheHomePageTest {

  @Managed
  WebDriver driver;

  HomePage homePage;

  @Steps
  EtsyBuyer buyer;

  @Test
  public void shouldShowRecentFavoritesSection() {
    buyer.opens_home_page();
    buyer.should_see_trending_title("Recent Favourites");
  }

}
