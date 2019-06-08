package ru.mail.polis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.mail.polis.Checks;
import ru.mail.polis.model.TestBot;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    private static final By REGISTRATION_BUTTON = By.xpath("//a[contains(@href,'anonymRegistrationEnter')]");
    private static final By LOGIN_BUTTON = By.xpath(".//input[@value='Войти']");
    private static final By EMAIL_FIELD = By.xpath(".//input[@id='field_email']");
    private static final By PASSWORD_FIELD = By.xpath(".//input[@type='password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void check() {
        assertTrue("No 'forgot password' button", Checks.isDisplayed(driver, REGISTRATION_BUTTON));
    }

    public UserMainPage login(TestBot bot) {
        WebElement fieldEmail = driver.findElement(EMAIL_FIELD);
        WebElement fieldPassword = driver.findElement(PASSWORD_FIELD);
        clear(fieldEmail);
        fieldEmail.sendKeys(bot.getLogin());
        clear(fieldPassword);
        fieldPassword.sendKeys(bot.getPassword());
        click(LOGIN_BUTTON);
        return new UserMainPage(driver);
    }
}
