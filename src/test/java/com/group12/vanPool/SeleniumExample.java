package com.group12.vanPool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumExample {

    private SeleniumConfig config;
    private String url = "http://localhost:8080/";

    public SeleniumExample() {
        config = new SeleniumConfig();
        config.getDriver().get(url);
    }

    public String getTitle() {return config.getDriver().getTitle();}

    public void closeWindow() {this.config.getDriver().close();}

    public void clickLogin() {
        this.config.getDriver().findElement(By.id("login")).click();
    }

    public void loginToVanpool() {

        WebElement username = this.config.getDriver().findElement(By.name("username"));
        WebElement password = this.config.getDriver().findElement(By.name("password"));

        username.sendKeys("user");
        password.sendKeys("password");

        this.config.getDriver().findElement(By.id("signUp")).click();
    }
}
