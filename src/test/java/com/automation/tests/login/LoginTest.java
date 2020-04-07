package com.automation.tests.login;

import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTestBase {

    @Test
    public void verifyPageTitle() {
        //test --> ExtentTest object (comes from ExtentTest variable in AbstractTestBase class)
        //we must add to every test at the beginning
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed
        test.pass("Page title Dashboard was verified");
    }

    @Test
    public void verifyWarningMessage() {
        test = report.createTest("Verify warning message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");

        BrowserUtils.getScreenshot("warning_message");// take a screenshot

        test.pass("Warning message is displayed"); //if all assertions pass
    }
}
