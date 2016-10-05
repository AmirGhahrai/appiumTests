package com.wikipedia.android_app.tests;

import com.wikipedia.android_app.pages.ArticlePage;
import com.wikipedia.android_app.pages.SearchWidget;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by amir on 02/10/2016.
 */
public class SearchTest extends BaseScenario {

    private static final String SEARCH_TERM = "Software testing";
    private static final String INVALID_SEARCH = "klhsdkalsf";

    @BeforeMethod
    public void startingPoint() throws Exception {
        driver.navigate().to("http://0.0.0.0:4723/wd/hub");
    }

    @Test(priority = 2)
    public void search_topic_should_return_relevant_article() throws Exception {
        SearchWidget searchWidget = new SearchWidget(driver);
        searchWidget.searchForTopic(SEARCH_TERM);

        Assert.assertTrue(searchWidget.getNumberOfSearchResults() > 0);
        Assert.assertTrue(searchWidget.SearchResultContains(SEARCH_TERM));

        ArticlePage articlePage = searchWidget.selectFirstResult();
        Assert.assertTrue(articlePage.getArticleTitle().contains(SEARCH_TERM));
    }

    @Test(priority = 1)
    public void invalid_search_should_return_no_results() {
        SearchWidget searchWidget = new SearchWidget(driver);
        searchWidget.searchForInvalid(INVALID_SEARCH);

        Assert.assertTrue(searchWidget.searchResultsIsEmpty());
        searchWidget.closeSearch();
    }
}
