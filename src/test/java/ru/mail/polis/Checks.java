package ru.mail.polis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checks {

    public static boolean isDisplayed(WebDriver webDriver, By locator) throws AssertionError {
        return new WebDriverWait(webDriver, 10)
                .until(driver -> driver.findElement(locator).isDisplayed());
    }
}
