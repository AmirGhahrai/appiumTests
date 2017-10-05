package com.wikipedia.android_app.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;

/**
 * Created by amir on 04/10/2016.
 */
public class BaseScenario {

    protected AppiumDriver driver;

    @BeforeTest
    protected void setup() throws Exception {

        File filePath = new File(System.getProperty("user.dir"));
        File appDir = new File(filePath, "/app");
        File app = new File(appDir, "app-alpha-debug.apk");

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "TestAvd");
        dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
