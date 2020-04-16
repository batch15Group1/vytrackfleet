package com.automation.tests.fleet;

import com.automation.pages.fleet.vehiclesModel.CreateVehiclesModelPage;
import com.automation.pages.fleet.vehiclesModel.VehiclesModelPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;


public class VehiclesModelTests extends AbstractTestBase {
VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();
CreateVehiclesModelPage createVehiclesModelPage= new CreateVehiclesModelPage();

    @Test(dataProvider = "credential")
    public void accessToVehicleModelPage (String module, String subModule){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();
        vehiclesModelPage.navigateTo("Fleet", "Vehicles Model");

        Assert.assertTrue(vehiclesModelPage.getSubTitle().isDisplayed());
    }

    @DataProvider
    public Object[][] credential () {
        return new Object[][]{
                {"storemanager51", "UserUser123"},
                {"salesmanager101", "UserUser123"},
                {"user1", "UserUser123"}
        };
    }

    @Test
    public void storeManagerCanCreateVehicleModel() {
        LoginPage loginPage= new LoginPage();
        test = report.createTest("Verify store manager can create a vehicle model");
        loginPage.login("storemanager51", "UserUser123");
        vehiclesModelPage.navigateTo("Fleet", "Vehicles Model");
        vehiclesModelPage.clickOnCreateVehiclesModelBtn();
        createVehiclesModelPage.enterModelName("camry");
        createVehiclesModelPage.enterMake("toyota");
        createVehiclesModelPage.selectCanBeRequested("Yes");
//        createVehiclesModelPage.uploadLogo("/Users/isikdurmus/Desktop/pic.jpg");
        createVehiclesModelPage.enterCatalogValue("12000");
        createVehiclesModelPage.enterCo2Fee("200");
        createVehiclesModelPage.enterCost("120");
        createVehiclesModelPage.enterTotalCost("320");
        createVehiclesModelPage.enterCo2Emission("20");
        createVehiclesModelPage.selectFuelType("Diesel");
        createVehiclesModelPage.enterVendors("dealer");
        createVehiclesModelPage.clickOnSaveAndCloseBtn();
        test.pass("Successfully created a new vehicle model");
    }



    }



