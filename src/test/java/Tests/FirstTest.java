package Tests;

import Pages.LoginPage;
import Pages.UserMainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class FirstTest extends TestBase {

    private StringBuilder verificationErrors = new StringBuilder();

    @Before
    public void setUp(){
        setDriver();
    }

    @Test
    public void testCase(){
        driver.get(baseURL + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
        LoginPage lp = new LoginPage(driver);
        UserMainPage ump = lp.login("technopolisBot68", "technopolis16");
    }

    @After
    public void tearDown(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
