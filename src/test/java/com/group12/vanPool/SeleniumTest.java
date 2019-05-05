package com.group12.vanPool;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private static SeleniumExample seleniumExample;
    private String expectedTitle = "Vanpool";

    @BeforeClass
    public static void setUp() {
        seleniumExample = new SeleniumExample();
    }

    @AfterClass
    public static void tearDown() {
       // seleniumExample.closeWindow();
    }

    @Test
    public void testWithSelenium() {
        String title = seleniumExample.getTitle();
        assert title.equals(expectedTitle);
        seleniumExample.clickLogin();
        title = seleniumExample.getTitle();
        assert title.equals("Login");
        seleniumExample.loginToVanpool();
        title = seleniumExample.getTitle();
        assert title.equals("Rider Homepage");
    }






}
