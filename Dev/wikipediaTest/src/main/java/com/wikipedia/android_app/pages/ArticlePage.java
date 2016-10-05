package com.wikipedia.android_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by amir on 05/10/2016.
 */
public class ArticlePage extends BaseWidget {

    @FindBy(id = "view_article_header_text")
    private WebElement articleHeader;

    public ArticlePage(AppiumDriver driver) {
        super(driver);
    }

    public void waitForArticlePageToLoad() {
        waitForElementToAppear(articleHeader);
    }

    public String getArticleTitle() {
        System.out.println(articleHeader.getText());
        return articleHeader.getText();
    }
}
