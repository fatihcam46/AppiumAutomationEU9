package com.cydeo.tests;
//1st class
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {

    @Test
    public void calculatorAddTest() throws MalformedURLException, InterruptedException {
        //DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
       // caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk" );

        //set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub");
//http://localhost:4723/wd/hub => Appium server is running in our local computer at port number 4723.
///wd/hub is the path that we add.

        //launch appiumDriver  AppiumDriver driver  is similar to WebDriver driver
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);//if iphone IOS Driver
//(url, caps) -> we are specifying the location/url of appium server and capabilities that describe what we need from appium server.
       // System.out.println(driver.getTitle());
        System.out.println(driver.getDeviceTime());

        Assertions.assertEquals("android", driver.getPlatformName());

        Thread.sleep(4000);
        //locate AC element on calculator using AccessibilityId("clear")
        MobileElement clearElem = driver.findElement(MobileBy.AccessibilityId("clear"));

        System.out.println("Text of elem: " + clearElem.getText());
        Assertions.assertTrue(clearElem.isDisplayed());

        //close the app
        driver.closeApp();

    }
}
