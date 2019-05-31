package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    WebDriver driver;

    BasePage(WebDriver driver) {

        this.driver = driver;
        check();
    }

    public abstract void check();

    void clear(WebElement element){
        element.clear();
    }

    boolean isElementVisible(By locator) {
        boolean isVisible = false;
        try{
            isVisible = driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }

        return isVisible;
    }

    void click(By locator){
        Assert.assertTrue(isElementVisible(locator));
        driver.findElement(locator).click();
    }

}
