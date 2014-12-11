package com.parleys.training.solutions.steps;

import com.parleys.training.exercises.pages.ItemDetailsPage;
import com.parleys.training.exercises.pages.SearchResultsPage;
import com.parleys.training.solutions.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by john on 11/12/14.
 */
public class EtsyBuyer extends ScenarioSteps {

  HomePage homePage;
  SearchResultsPage searchResultsPage;
  ItemDetailsPage detailsPage;

  @Step
  public void opens_home_page() {
    homePage.open();
  }

  @Step
  public void should_see_trending_title(String expectedTitle) {
    assertThat(homePage.getTrendingTitle()).isEqualTo(expectedTitle);
  }

  @Step
  public void searches_for_items_containing(String keywords) {
    homePage.searchFor(keywords);

  }

  @Step
  public void should_see_search_header_containing(String keywords) {
    assertThat(searchResultsPage.getSearchHeader()).contains(keywords);

  }

  @Step
  public void refines_search_by_type(String type) {
    searchResultsPage.refineByType(type);
  }

  @Step
  public void should_see_items_related_to(String keywords) {
    List<String> resultTitles = searchResultsPage.getResultTitles();
    resultTitles.stream().forEach(title -> assertThat(title.contains(keywords)));
  }

  String selectedItemDescription;

  @Step
  public void selects_item_number(int number) {
    selectedItemDescription = searchResultsPage.getItemDescription(number);
    searchResultsPage.selectItem(number);
  }

  @Step
  public void should_see_matching_details() {
    assertThat(detailsPage.getItemName()).containsIgnoringCase(selectedItemDescription);
  }
}
