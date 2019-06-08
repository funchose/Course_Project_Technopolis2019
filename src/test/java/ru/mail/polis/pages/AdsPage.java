package ru.mail.polis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.mail.polis.Checks;

import static org.junit.Assert.assertTrue;

public class AdsPage extends BasePage {
    private static final By CREATE_AD_BUTTON = By.xpath(".//button[@class='sc-gjAXCV kXpJmD sc-gqjmRU KgNrl']");
    private static final By PRICE_FROM_INPUT = By.xpath(".//input[@name='price.from']");
    private static final By PRICE_TO_INPUT = By.xpath(".//input[@name='price.to']");
    private static final By APPLY_BUTTON = By.xpath(".//button[contains(@class,'filter__button_submit')]");
    private static final By FRAME = By.xpath(".//iframe[@id='appMain_Div']");

    public AdsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void check() {
        driver = driver.switchTo().frame(driver.findElement(FRAME));
        assertTrue("Create ad button not found", Checks.isDisplayed(driver, CREATE_AD_BUTTON));
        assertTrue("Price from input not found", Checks.isDisplayed(driver, PRICE_FROM_INPUT));
        assertTrue("Price to input not found", Checks.isDisplayed(driver, PRICE_TO_INPUT));
        assertTrue("Apply button not found", Checks.isDisplayed(driver, APPLY_BUTTON));
    }

    public void setPriceFrom(int price) {
        WebElement priceFrom = driver.findElement(PRICE_FROM_INPUT);
        clear(priceFrom);
        priceFrom.sendKeys(String.valueOf(price));
    }

    public void setPriceTo(int price) {
        WebElement priceTo = driver.findElement(PRICE_TO_INPUT);
        clear(priceTo);
        priceTo.sendKeys(String.valueOf(price));
    }

    public void applyFilter() {
        WebElement applyButton = driver.findElement(APPLY_BUTTON);
        applyButton.click();
    }
}
