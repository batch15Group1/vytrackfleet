package com.automation.tests.fleet;

import com.automation.pages.fleet.VehicleServicesLogsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VehicleServicesLogsTests extends AbstractTestBase {
    private WebDriver driver;


    /**
     * US_11
     * 2.Verfity that non authorized user should Not be able to access Vehicle service log (non authorize: Store manager, sales manager
     * 1-1)open url "https://qa2.vytrack.com/user/login"
     * 1-2)login as Store manager and sales manager  with valid credential
     * 1-3)navigate to "Fleet" module and click"Vehicle services Log"
     */
    @Test
    public void verifySalesManegarNotAccessVehicleServicesLog() {
        test = report.createTest("Verify sales manager should not access the Vehicle Services Logs Page");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        test.info("Sales Manegar Login Successfully");
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");

        String expected = "You do not have permission to perform this action.";
        String actual = vehicleServicesLogsPage.getWarningMessageNonAuthorizedUser();
        Assert.assertEquals(expected, actual);
        test.pass("Non-authorized user shouldnt access Vehicle Services logs");

    }

    @Test
    public void verifyStoreManegarNotAccessVehicleServicesLog() {
        test = report.createTest("Verify store manager should not access the Vehicle Services Logs Page");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();
        test.info("Store Manegar Login Successfully");
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");

        String expected = "You do not have permission to perform this action.";
        String actual = vehicleServicesLogsPage.getWarningMessageNonAuthorizedUser();
        Assert.assertEquals(expected, actual);
        test.pass("Non-authorized user shouldnt access Vehicle Services logs");

    }

// * US_11.As a authorized user I should be able to access Vehicle Serviecs Log
//     * 1.Verify that authorized user should be able to access and see all Vehicle serviece log (Note: authorized:Truck driver, admin)

    /**
     * US_12.As a truck driver I should be able to access Vehicle serviece Log
     * 1.Verify truck driver see all Vehicle service logs
     * 1-1)open url "https://qa2.vytrack.com/user/login"
     * 1-2)login as truck driver with valid credential
     * 1-3)navigate to "Fleet" module and click"Vehicle services Login"
     * 1-4)verify that see all vehicle services logs
     */

    @Test
    public void verifyTruckdriverSeeAllVehicleServicesLogs() {
        test = report.createTest("Verify Truck driver See Vehicle Services Logs");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        test.info("Login as Truck driver");
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");

        String expectedTitle = "Vehicle Services Logs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        test.pass("Truck driver can see Vehicle service Logs page");

    }

    /**
     * 2-1-Verify that truck driver should be able to create Vehicle service logs or cancel it
     * "1-User should be access the  URL
     * 2-User enter valid credential and click login button
     * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs"
     * 4-User click the "Create Vehicle Services Logs" button
     * 5-User  click the "Save and Close"
     */
    @Test
    public void verifyTruckDriverCreateVehicleServiceLogsClickSaveAndClose() {
        test = report.createTest("Verify Truck driver can create Vehicle Services Logs");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        test.info("Login as Truck driver");
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
        vehicleServicesLogsPage.clickCreateVehicleServicesLogs();
        vehicleServicesLogsPage.clickSaveAndCloseBtn();

        String expected = "Entity saved";
        Assert.assertTrue(vehicleServicesLogsPage.getSaveAndCloseFlashMessage().contains(expected));
        test.pass("Truck driver can Create Vehicle Services Logs");

    }

    /**
     * 2- 2.Verify that truck driver should be able to create Vehicle service logs or cancel it
     * "1-User should be access the  URL
     * 2-User enter valid credential and click login button
     * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs"
     * 4-User click the "Create Vehicle Services Logs" button
     * 5-User click the "Cancel" button
     */
    @Test
    public void verifyTruckDriverCreateVehicleServiceLogsClickCancel() {
        test = report.createTest("Verify Truck driver can Cancel the create Vehicle Services Logs Page");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        test.info("Login as Truck driver");
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
        vehicleServicesLogsPage.clickCreateVehicleServicesLogs();
        vehicleServicesLogsPage.clickCancelBtn();
        BrowserUtils.wait(3);

        String expectedTitle = "Vehicle Services Logs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        test.pass("Truck driver can cancel the Create Vehicle Services Logs");


    }


    /**
     * "3.Verify that during the creation, the service
     * type drop down should display
     * (Road Assistance .Depreciation and Interests,Tax Roll, Summer Tires,Snow Tires,
     * Repair and Maintenance,Vehicle Insurance,Vehicle Delivery)
     * "1-User should be access the  URL
     * 2-User enter valid credential and click login button
     * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
     * 4-User click "create Vehicle services logs"
     * 5-user click all service type
     **/
    @Test
    public void verifyDuringTheCreationServiceTypeDropDownDisplay() {
        test = report.createTest("Verify During The Creation Service Type DropDown isDisplay");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        test.info("Login as Truck driver");
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
        vehicleServicesLogsPage.clickCreateVehicleServicesLogs();
        vehicleServicesLogsPage.isDisplayedServiceType();
        vehicleServicesLogsPage.getTitleDisplayedAllServiceType();

        test.pass("During the creation Services type DropDown Display");

}

    /**
     * 4.1-Verify that truck driver should be able to Edit or delete Vehicle services log
     * "1-User should be access the  URL
     * 2-User enter valid credential and click login button
     * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
     * 4-user click one of the service type and click
     * 5-user click "edit"
      */
@Test
    public void verifyTruckdriverVehicleServicesLogsClickEdit(){
    test=report.createTest("Verify Truck driver can edit Vehicle Services Logs Page");
    LoginPage loginPage = new LoginPage();
    loginPage.loginAsDriver();
    test.info("Login as Truck driver");
    VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
    vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
     vehicleServicesLogsPage.clickOneOFTheServicesTypeAndClickEditBTn();

    Assert.assertTrue(Driver.getDriver().getTitle().contains("Vehicle Services Logs - Entities - System - Car - Entities - System"));
    test.pass("Truck driver can edit Vehicle Services logs");

    }

    /**
     * 4.2-Verify that truck driver should be able to Edit or delete Vehicle services log
     * "1-User should be access the  URL
     * 2-User enter valid credential and click login button
     * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
     * 4-user click one of the service type and click
     * 5-user click "Delete" button
     */
    @Test
    public void verifyTruckdriverVehicleServicesLogsClickDelete(){
        test=report.createTest("Verify Truck driver can click Vehicle Services Logs Page");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        test.info("Login as Truck driver");
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
        vehicleServicesLogsPage.clickOneOFTheServicesTypeAndClickDeleteBTn();

        Assert.assertTrue(vehicleServicesLogsPage.getDeleteConfirmationMessage().contains("Vehicle Services Logs deleted"));
      test.pass("Truck driver can delete services type ");
    }

/**
 *5.Verify that truck driver should be able to add event
 * "1-User should be access the  URL
 * 2-User enter valid credential and click login button
 * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
 * 4-user choose randomly one of service type and click
 * 5-user click ""add event "" button
 */
@Test
    public void verifyTruckdriverVehicleServicesLogsClickAddEvent(){
    test =report.createTest("Verify Truck driver can click Add Event on Vehicle Services Logs Page");
    LoginPage loginPage = new LoginPage();
    loginPage.loginAsDriver();
    test.info("Login as Truck driver");
    VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
    vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
    vehicleServicesLogsPage.clickOneOFTheServicesTypeAndClickAddEventBTn();

    Assert.assertTrue(vehicleServicesLogsPage.getAddEventFlashMessage().contains("Calendar event saved"));
    test.pass("Truck driver can  add event");


    }

    /**
 * "6.Verify that truck driver should be able to reset grid by click on Grid setting
 * "1-User should be access the  URL
 * 2-User enter valid credential and click login button
 * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
 * 4-user hover the mouse and click setting's logo button
 *  5-user reset grid by grid setting page
 */


@Test
    public void VerifyTruckdriverResetGridByGridSetting(){
    test=report.createTest("Verify Truck driver  should not able to Reset Grid By click on GridSetting");
    LoginPage loginPage = new LoginPage();
    loginPage.loginAsDriver();
    test.info("Login as Truck driver");
    VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
    vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
    vehicleServicesLogsPage.clickOnGridSettings();
    Assert.assertFalse(vehicleServicesLogsPage.Gettextgridsetting().contains("Reset"));
    test.pass("Truck driver can not Reset Grid by click on Grid setting icon ");


}


}