package com.parleys.training.solutions.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by john on 18/11/14.
 */
public class ItemDetailsPage extends PageObject {

    @FindBys({@FindBy(id="listing-page-cart"), @FindBy(tagName = "h1")})
    WebElement itemName;

    @FindBy(css=".add-to-cart-form .btn-transaction")
    WebElement addToCartButton;

    @FindBy(id="description")
    WebElement descriptionTab;

    public String getItemName() {
        return itemName.getText();
    }
}
