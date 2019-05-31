package Pages;

import com.sun.istack.internal.NotNull;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private static final By REGISTRATION_BUTTON = By.xpath("//a[contains(@href,'anonymRegistrationEnter')]");
    private static final By LOGIN_BUTTON = By.xpath(".//input[@value='Войти']");
    private static final By EMAIL_FIELD = By.xpath(".//input[@id='field_email']");
    private static final By PASSWORD_FIELD = By.xpath(".//input[@type='password']");

    private String email;
    private String password;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void check() {
        Assert.assertTrue("No 'forgot password' button",
                new WebDriverWait(driver, 5).until(
                        new ExpectedCondition<Boolean>() {
                            @NotNull
                            @Override
                            public Boolean apply(@NullableDecl WebDriver driver) {
                                return isElementVisible(REGISTRATION_BUTTON);
                            }
                        }
                ));
    }

    private void submitEntry(){
        WebElement field_email = driver.findElement(EMAIL_FIELD);
        WebElement field_password = driver.findElement(PASSWORD_FIELD);
        clear(field_email);
        field_email.sendKeys(email);
        clear(field_password);
        field_password.sendKeys(password);
        click(LOGIN_BUTTON);
    }

    public UserMainPage login(String email, String password){
        this.email = email;
        this.password = password;
        submitEntry();
        return new UserMainPage(driver);
    }
}
