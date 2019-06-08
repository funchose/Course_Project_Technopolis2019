package ru.mail.polis.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.mail.polis.Checks;
import ru.mail.polis.TestBase;
import ru.mail.polis.model.TestBot;
import ru.mail.polis.pages.LoginPage;
import ru.mail.polis.pages.UserMainPage;

import static org.junit.Assert.assertTrue;

public class AdsButtonTest extends TestBase {
    private static final By ADS_BUTTON = By.xpath(".//a[@data-l='t,youlaAdverts']");
    private static final TestBot BOT = new TestBot("technopolisBot80", "technopolis16");

    @Test
    public void testAdsButtonIsPresent() {
        LoginPage loginPage = new LoginPage(driver);

        UserMainPage userMainPage = loginPage.login(BOT);
        userMainPage.toggleOthers();

        assertTrue("Ads button not found", Checks.isDisplayed(driver, ADS_BUTTON));
    }
}
