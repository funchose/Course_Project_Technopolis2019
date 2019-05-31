package Tests;

import Driver.BaseDriver;
import org.openqa.selenium.*;

class TestBase {

    WebDriver driver;
    String baseURL;
    private boolean acceptNextAlert = true;

    void setDriver(){
        BaseDriver bd = new BaseDriver();
        bd.driverSetUp();
        this.driver = bd.getDriver();
        this.baseURL = bd.getBaseURL();
    }

    private boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
