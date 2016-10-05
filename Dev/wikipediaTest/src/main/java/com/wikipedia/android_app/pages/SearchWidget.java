package com.wikipedia.android_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by amir on 05/10/2016.
 */
public class SearchWidget extends BaseWidget {

    @FindBy(id = "search_container")
    private WebElement searchContainer;

    @FindAll(@FindBy(id = "page_list_item_container"))
    private List<WebElement> results;

    @FindBy(id = "search_results_empty")
    private WebElement emptyResults;

    @FindBy(id = "search_close_btn")
    private WebElement closeSearch;

    public SearchWidget(AppiumDriver driver) {
        super(driver);
    }

    public SearchWidget searchForTopic(String topic) {
        waitForElementToAppear(searchContainer);
        searchContainer.sendKeys(topic);
        waitForElementToAppear(results.get(0));
        return this;
    }

    public void closeSearch() {
        closeSearch.click();
    }

    public SearchWidget searchForInvalid(String invalid) {
        waitForElementToAppear(searchContainer);
        searchContainer.sendKeys(invalid);
        waitForElementToAppear(emptyResults);
        return this;
    }

    public int getNumberOfSearchResults() {
        System.out.println("Results: " + results.size());
        return results.size();
    }

    public boolean SearchResultContains(String text) {
        boolean found = false;
        for(WebElement element : results) {
            if(element.findElement(By.id("page_list_item_title")).getText().contains(text)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public ArticlePage selectFirstResult() {
        results.get(0).click();
        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.waitForArticlePageToLoad();
        return articlePage;
    }

    public boolean searchResultsIsEmpty() {
        return emptyResults.isDisplayed();
    }
}
