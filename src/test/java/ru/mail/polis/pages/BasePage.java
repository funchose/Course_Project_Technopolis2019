package ru.mail.polis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        check();
    }

    public abstract void check();

    protected void clear(WebElement element) {
        element.clear();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
}
