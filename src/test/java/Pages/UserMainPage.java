package Pages;

import com.sun.istack.internal.NotNull;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMainPage extends BasePage {

    private static final By FRIENDS_BUTTON = By.xpath("//*[@class='tico']//*[text()='Друзья']");
    private static final By USER_AVATAR = By.xpath("//div[@class='entity-avatar']");

    UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void check() {
        Assert.assertTrue("No user avater found",
                new WebDriverWait(driver, 5).until(
                        new ExpectedCondition<Boolean>() {
                            @NotNull
                            @Override
                            public Boolean apply(@NullableDecl WebDriver driver) {
                                return isElementVisible(USER_AVATAR);
                            }
                        }
                ));
    }
}
