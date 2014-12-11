package com.parleys.training.solutions.search;

import com.parleys.training.solutions.pages.HomePage;
import com.parleys.training.solutions.pages.ItemDetailsPage;
import com.parleys.training.solutions.pages.SearchResultsPage;
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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SearchingByKeywordTest {

  @Managed
  WebDriver driver;

  HomePage homePage;
  SearchResultsPage searchResultsPage;
  ItemDetailsPage detailsPage;

  @Steps
  EtsyBuyer buyer;

  @Before
  public void openEtsyHomePage() {
    buyer.opens_home_page();
  }

  @Test
  public void shouldBeAbleToSearchByKeyword() {
    buyer.searches_for_items_containing("shoes");
    buyer.should_see_search_header_containing("shoes");
  }

  @Test
  public void shouldBeAbleToSearchByKeywordAndRefineByItemType() {
    buyer.searches_for_items_containing("shoes");
    buyer.refines_search_by_type("Vintage");
    buyer.should_see_search_header_containing("shoes");
  }

  @Test
  public void shouldOnlyDisplayRelatedItemsInSearchResults() {
    buyer.searches_for_items_containing("shoes");
    buyer.should_see_items_related_to("shoes");
  }


  @Test
  public void shouldOpenCorrespondingItemFromSearchListUsingPageObjects() {
    buyer.searches_for_items_containing("shoes");
    buyer.selects_item_number(1);
    buyer.should_see_matching_details();
  }

}
