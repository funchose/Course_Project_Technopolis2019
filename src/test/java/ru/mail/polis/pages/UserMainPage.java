package ru.mail.polis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.mail.polis.Checks;

import static org.junit.Assert.assertTrue;

public class UserMainPage extends BasePage {
    private static final By OTHER_TOGGLE = By.xpath(".//div[@data-l='t,toggler']");
    private static final By ADS_BUTTON = By.xpath(".//a[@data-l='t,youlaAdverts']");
    private static final By FRIENDS_BUTTON = By.xpath("//*[@class='tico']//*[text()='Друзья']");
    private static final By USER_AVATAR = By.xpath("//div[@class='entity-avatar']");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void check() {
        assertTrue("User avatar not found", Checks.isDisplayed(driver, USER_AVATAR));
    }

    public void toggleOthers() {
        assertTrue("Other menu items toggle not found", Checks.isDisplayed(driver, OTHER_TOGGLE));
        click(OTHER_TOGGLE);
    }

    public AdsPage clickAdsButton() {
        assertTrue("Ads menu button not found", Checks.isDisplayed(driver, ADS_BUTTON));
        click(ADS_BUTTON);
        return new AdsPage(driver);
    }
}
