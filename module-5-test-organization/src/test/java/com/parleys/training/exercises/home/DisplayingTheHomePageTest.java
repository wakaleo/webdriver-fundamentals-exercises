package com.parleys.training.exercises.home;

import com.parleys.training.solutions.pages.HomePage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class DisplayingTheHomePageTest {

  @Managed
  WebDriver driver;

  HomePage homePage;

  @Test
  public void shouldShowRecentFavoritesSection() {
    homePage.open();
    assertThat(homePage.getTrendingTitle()).isIn("Recent Favorites","Recent Favourites");
  }

}
