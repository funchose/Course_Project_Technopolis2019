package ru.mail.polis.tests;

import org.junit.Test;
import ru.mail.polis.TestBase;
import ru.mail.polis.model.TestBot;
import ru.mail.polis.pages.LoginPage;
import ru.mail.polis.pages.UserMainPage;

public class FirstTest extends TestBase {
    private static final TestBot BOT = new TestBot("technopolisBot68", "technopolis16");

    @Test
    public void testCase() {
        LoginPage lp = new LoginPage(driver);
        UserMainPage ump = lp.login(BOT);
    }
}
