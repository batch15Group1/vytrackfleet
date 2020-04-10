package com.automation.tests.fleet;

import com.automation.pages.fleet.vehiclesModel.CreateVehiclesModelPage;
import com.automation.pages.fleet.vehiclesModel.VehiclesModelPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import org.testng.annotations.Test;

public class VehiclesModelTests extends AbstractTestBase {
LoginPage loginPage= new LoginPage();
VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();
CreateVehiclesModelPage createVehiclesModelPage= new CreateVehiclesModelPage();

    @Test
    public void storeManagerAccessVehiclesModel(){
    test = report.createTest("Verify access to VehiclesModel page");
    loginPage.login("storemanager51","UserUser123");
    vehiclesModelPage.navigateTo("Fleet", "Vehicles Model");
    test.pass("Store manager access is verified");
    }

    @Test
    public void salesManagerAccessVehiclesModel(){
        test = report.createTest("Verify access to VehiclesModel page");
        loginPage.login("salesmanager101","UserUser123");
        vehiclesModelPage.navigateTo("Fleet", "Vehicles Model");
        test.pass("Sales manager access is verified");
    }

    @Test
    public void storeManagerCanCreateVehicleModel(){
        test = report.createTest("Verify store manager can create a vehicle model");
        loginPage.login("storemanager51","UserUser123");
        vehiclesModelPage.navigateTo("Fleet", "Vehicles Model");
        vehiclesModelPage.clickOnCreateVehiclesModelBtn();
        createVehiclesModelPage.enterModelName("camry");
        createVehiclesModelPage.enterMake("toyota");
        createVehiclesModelPage.selectCanBeRequested("Yes");
        createVehiclesModelPage.uploadLogo("/Users/isikdurmus/Desktop/pic.jpg");
        createVehiclesModelPage.enterCatalogValue("12000");
        createVehiclesModelPage.enterCo2Fee("200");
        createVehiclesModelPage.enterCost("120");
        createVehiclesModelPage.enterTotalCost("320");
        createVehiclesModelPage.enterCo2Emission("20");
        createVehiclesModelPage.selectFuelType("Diesel");
        createVehiclesModelPage.enterVendors("dealer");
        createVehiclesModelPage.clickOnSaveAndCloseBtn();

    }

}
