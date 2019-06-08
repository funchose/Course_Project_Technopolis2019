package ru.mail.polis.tests;

import org.junit.Test;
import ru.mail.polis.TestBase;
import ru.mail.polis.model.TestBot;
import ru.mail.polis.pages.AdsPage;
import ru.mail.polis.pages.LoginPage;
import ru.mail.polis.pages.UserMainPage;

public class PriceFilterTest extends TestBase {
    private static final TestBot BOT = new TestBot("technopolisBot80", "technopolis16");
    private static final int PRICE_FROM = 500;
    private static final int PRICE_TO = 1500;

    @Test
    public void testPriceFilter() {
        LoginPage loginPage = new LoginPage(driver);
        UserMainPage userMainPage = loginPage.login(BOT);
        userMainPage.toggleOthers();
        AdsPage adsPage = userMainPage.clickAdsButton();

        adsPage.setPriceFrom(PRICE_FROM);
        adsPage.setPriceTo(PRICE_TO);
        adsPage.applyFilter();
    }
}
