package com.automation.tests.fleet;

import com.automation.pages.fleet.VehiclesFuelLogsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VehiclesFuelLogsTests extends AbstractTestBase {


    @Test(dataProvider = "credentialsForAuthorizedUser")
    public void accessVehicleFuelLog(String userName, String password) {

        test = report.createTest("Reaching \"Vehicle Fuel Log Page \" : " + userName);

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

        test.info("Login as " + userName);
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");

        test.pass("Page title Dashboard was verified");

        VehiclesFuelLogsPage vehiclesFuelLogsPage = new VehiclesFuelLogsPage();
      //  vehiclesFuelLogsPage.navigateTo("Fleet", "Vehicles Fuel Logs");

        String expectedTitle = "Vehicle Fuel Logs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        BrowserUtils.wait(3);
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @DataProvider
    public Object[][] credentialsForAuthorizedUser() {
        return new Object[][]{
                {ConfigurationReader.getProperty("driver"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("driver2"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("driver3"), ConfigurationReader.getProperty("password")}
        };
    }


    @Test(dataProvider="credentialsForUnauthorizedUser")
    public void unAuthorizedUser(String userName, String password) {
        test = report.createTest("Unauthorized user test for Vehicles Fuel Log page");

        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

        VehiclesFuelLogsPage vehiclesFuelLogsPage = new VehiclesFuelLogsPage();
        vehiclesFuelLogsPage.navigateTo("Fleet", "Vehicles Fuel Logs");
        String actual = vehiclesFuelLogsPage.alertUnauthorizedUser();
        String expected = "You do not have permission to perform this action.";
        Assert.assertEquals(actual, expected);

        test.pass("An unauthorized user can not reach the Vehicles Fuel Log page");

    }

    @DataProvider
    public Object[][] credentialsForUnauthorizedUser() {
        return new Object[][]{
                {ConfigurationReader.getProperty("store_manager"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("sales_manager"), ConfigurationReader.getProperty("password")}

        };

    }
}