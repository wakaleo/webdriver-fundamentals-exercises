package com.parleys.training.solutions;

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

  @Test
  public void shouldFindInformationAboutFireflies() {
    WebDriver driver = new FirefoxDriver();
    driver.get("http://www.wikipedia.org");

    driver.findElement(By.name("search")).sendKeys("firefly");
    driver.findElement(By.name("go")).click();

    assertThat(driver.getTitle()).startsWith("Firefly");

    driver.close();
  }
}
