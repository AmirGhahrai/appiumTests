package com.wikipedia.android_app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by amir on 05/10/2016.
 */
public class BaseWidget {

    AppiumDriver driver;
    WebDriverWait wait;

    public BaseWidget(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}