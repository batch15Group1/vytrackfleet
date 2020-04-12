package com.automation.tests.fleet;

import com.automation.pages.fleet.VehicleServicesLogsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleServicesLogsTests extends AbstractTestBase {

    /**
     * 1.Verify truck driver see all Vehicle service logs
     * 1-1)open url "https://qa2.vytrack.com/user/login"
     * 1-2)login as truck driver with valid credential
     * 1-3)navigate to "Fleet" module and click"Vehicle services Login"
     * 1-4)verify that see all vehicle services logs
     */

    @Test
    public void verifyTruckdriverSeeAllVehicleServicesLogs() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");

        String expectedTitle = "Vehicle Services Logs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


    }
/**
 * 2.Verify that truck driver should be able to create Vehicle service logs or cancel it
 *"1-User should be access the  URL
 * 2-User enter valid credential and click login button
 * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs"
 * 4-User click the "Create Vehicle Services Logs" button
 * 5-User  click the "Save and Close" button or ""Cancel"" button
 */
    @Test
    public void verifyTruckDriverCreateVehicleServiceLogsORCancel(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
        vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");

        vehicleServicesLogsPage.clickCreateVehicleServicesLogs();

        vehicleServicesLogsPage.clickCancelBtn();

     //   vehicleServicesLogsPage.clickSaveAndCloseBtn();

    }


/**
 "3.Verify that during the creation, the service
 type drop down should display
 (Road Assistance .Depreciation and Interests,Tax Roll, Summer Tires,Snow Tires,
 Repair and Maintenance,Vehicle Insurance,Vehicle Delivery)
 "1-User should be access the  URL
 2-User enter valid credential and click login button
 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
 4-User click "create Vehicle services logs"
 5-user click all service type
 **/
@Test
    public void verifyDuringTheCreationServiceTypeDropDownDisplay(){
    LoginPage loginPage = new LoginPage();
    loginPage.loginAsDriver();

    VehicleServicesLogsPage vehicleServicesLogsPage = new VehicleServicesLogsPage();
    vehicleServicesLogsPage.navigateTo("Fleet", "Vehicle Services Logs");
    vehicleServicesLogsPage.clickCreateVehicleServicesLogs();
    vehicleServicesLogsPage.clickServiceType();


}

    /**
     * 4.Verify that truck driver should be able to Edit or delete Vehicle services log
     * "1-User should be access the  URL
     * 2-User enter valid credential and click login button
     * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
     * 4-user click one of the service type and click
     * 5-user click ""edit"" or ""Delete"" button
      */
@Test
    public void verifyTruckdriverEditORDeleteVehicleServicesLog(){


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
    public void verifyTruckdriverAddEvent(){

    }
/**
 * "6.Verify that truck driver should be able to reset grid by click on Grid setting"
 * "1-User should be access the  URL
 * 2-User enter valid credential and click login button
 * 3-User move to mouse to "Fleet"" menu and  click the "Vehicle Services Logs""
 * 4-user hover the mouse and click setting's logo button
 *  5-user reset grid by grid setting page
 */


@Test
    public void VerifyTruckdriverResetGridByGridSetting(){


    }


}