package com.group12.vanPool;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig() {

        Capabilities capabilities = DesiredCapabilities.firefox();
        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    static {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tanner\\IdeaProjects\\Team12\\.idea\\libraries\\GeckoDriver\\geckodriver.exe");
    }

    public WebDriver getDriver() {return this.driver;}

}
