package com.parleys.training.exercises;

import net.serenity_bdd.core.annotations.findby.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleSearchTest {

  @Test
  public void shouldFindInformationAboutSelenium() {

    WebDriver driver = new FirefoxDriver();
    driver.get("http://www.wikipedia.org");

    driver.findElement(By.name("search")).sendKeys("selenium");
    driver.findElement(By.name("go")).click();

    assertThat(driver.getTitle()).startsWith("Selenium");

    driver.close();
  }

  /**
   * EXERCISE 1
   */
  @Test
  public void shouldFindInformationAboutFireflies() {
    // TODO: Write a test similar to the one above, but that searches for information about fireflies
  }
}
