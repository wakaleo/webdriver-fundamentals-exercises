package com.parleys.training.solutions.search;

import com.parleys.training.solutions.pages.HomePage;
import com.parleys.training.solutions.pages.ItemDetailsPage;
import com.parleys.training.solutions.pages.SearchResultsPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SearchingByKeywordTest {

  @Managed
  WebDriver driver;

  HomePage homePage;
  SearchResultsPage searchResultsPage;
  ItemDetailsPage detailsPage;

  @Before
  public void openEtsyHomePage() {
    homePage.open();
  }

  @Test
  public void shouldBeAbleToSearchByKeyword() {
    homePage.searchFor("shoes");
    assertThat(searchResultsPage.getSearchHeader()).contains("shoes");
  }

  @Test
  public void shouldBeAbleToSearchByKeywordAndRefineByItemType() {

    homePage.searchFor("shoes");
    searchResultsPage.refineByType("Vintage");
    assertThat(searchResultsPage.getSearchHeader()).contains("shoes");
  }

  @Test
  public void shouldOnlyDisplayRelatedItemsInSearchResults() {

    homePage.searchFor("shoes");

    searchResultsPage.getResultTitles().stream()
      .forEach(title -> assertThat(title.contains("shoes")));
  }


  @Test
  public void shouldOpenCorrespondingItemFromSearchListUsingPageObjects() {
    homePage.searchFor("wool");
    searchResultsPage.selectItem(1);
    assertThat(detailsPage.getItemName()).containsIgnoringCase("wool");
  }

}
