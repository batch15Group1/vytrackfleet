package com.automation.tests.fleet;

import com.automation.pages.fleet.VehiclesFuelLogsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Set;

public class VehiclesFuelLogsTests extends AbstractTestBase {

/*
  US 9.As an authorized user I should be able to access Vehicle Fuel logs
  AC 1.Verify that only authorized user can access Vehicle Fuel logs (Note: authorized user: truck driver )
     2.Verify that non authorized user should not be able to access Vehicle Fuel Logs
 */
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
        vehiclesFuelLogsPage.navigateTo("Fleet", "Vehicles Fuel Logs");

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

    /*
    US  10.As a truck driver I should be able to access Vehicle Fuel Logs
    AC  1.Verify that truck driver should be able to see all Vehicle Fuel information on the grid
        2.Verify that truck driver should be able to create Vehicle Fuel logs or cancel it
        3.Verify that truck driver should be able to Edit , delete Vehicle Fuel Logs or
            add attachment , add event
        4.Verify that truck driver should be able to reset the grid by clicking on Grid setting
     */
    @Test
    public void allVehicleFuelLogInfo(){
        test = report.createTest("Verify all vehicle fuel log grid information");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        test.info("Login as truck driver");

        VehiclesFuelLogsPage vehiclesFuelLogsPage = new VehiclesFuelLogsPage();
        vehiclesFuelLogsPage.navigateTo("Fleet", "Vehicles Fuel Logs");

        vehiclesFuelLogsPage.clickOnGridSettings();
        vehiclesFuelLogsPage.clickSelectAll();

        Set<String> expected = vehiclesFuelLogsPage.getAllVehicleFuelLogInfoFromGrid();
        Set<String> actual = vehiclesFuelLogsPage.getAllVehicleFuelLogTableHeader();
        Assert.assertEquals(actual,expected);

        test.pass("All vehicle fuel log grid information were verified! ");

    }

    @Test
    public void createFuelLogCancel(){
        test = report.createTest("Verify create vehicle fuel logs or cancel ");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();


        VehiclesFuelLogsPage vehiclesFuelLogsPage = new VehiclesFuelLogsPage();
        vehiclesFuelLogsPage.navigateTo("Fleet", "Vehicles Fuel Logs");

        vehiclesFuelLogsPage.clickCreateVehicleFuelLogBttn();
        BrowserUtils.wait(3);
        String expectedTitle = "Create Vehicle Fuel Logs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        BrowserUtils.wait(3);
        Assert.assertEquals(actualTitle, expectedTitle);

        BrowserUtils.waitForPageToLoad(10);
        vehiclesFuelLogsPage.clickCancelBtn();
        BrowserUtils.wait(3);
        String expectedTitle2 = "Vehicle Fuel Logs - Entities - System - Car - Entities - System";
        String actualTitle2 = Driver.getDriver().getTitle();
        BrowserUtils.wait(3);
        Assert.assertEquals(actualTitle2, expectedTitle2);
         test.pass("Create all VFL or cancel is verified ");


    }
    @Test
    public void editDeleteVLPaddAttchAddEvent(){
        //couldn't find add attachment add event part in the page

        test = report.createTest("Verify create vehicle fuel logs or cancel ");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();


        VehiclesFuelLogsPage vehiclesFuelLogsPage = new VehiclesFuelLogsPage();
        vehiclesFuelLogsPage.navigateTo("Fleet", "Vehicles Fuel Logs");

        vehiclesFuelLogsPage.editFuelLog();
        String URL=vehiclesFuelLogsPage.getCurrentURL();
        String targetURL="https://qa2.vytrack.com/entity/update/Extend_Entity_VehicleFuelLogs";
        Assert.assertTrue(URL.startsWith(targetURL));

        Driver.getDriver().navigate().back();

        vehiclesFuelLogsPage.deleteFuelLog();
        String deleteButtonText=vehiclesFuelLogsPage.getDeleteButton();

        Assert.assertEquals(deleteButtonText,"Yes, Delete");

        test.pass("VFL edit and delete functions are verified");





    }
    @Test
    public void resetGrid(){
        test = report.createTest("Verify that reset grid for VFL ");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        VehiclesFuelLogsPage vehiclesFuelLogsPage = new VehiclesFuelLogsPage();
        vehiclesFuelLogsPage.navigateTo("Fleet", "Vehicles Fuel Logs");

        BrowserUtils.wait(2);
        vehiclesFuelLogsPage.resetVFL();

    test.pass("VFL reset grid is verified");

    }


}