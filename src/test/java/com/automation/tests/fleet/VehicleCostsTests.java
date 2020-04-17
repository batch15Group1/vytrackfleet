package com.automation.tests.fleet;

import com.automation.pages.fleet.VehicleCostsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VehicleCostsTests extends AbstractTestBase {
    //UserStory #5 /AC #1 /Test Case #1
    //1.Verify that truck driver should be able to see all cars' cost informations on the Vehicle Costs page.
    //Test Case #1 Truck driver can see cost information
//    5.Click  Create Vehicle Cost button
//    6.Put the informations
//    7. Click Save button
    @Test
    public void testCreateVehicleCost() {
        LoginPage loginPage = new LoginPage();
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

        loginPage.login("User1", "UserUser123");
        vehicleCostsPage.navigateTo("Fleet", "Vehicle Costs");
        String actualResult = Driver.getDriver().findElement(By.className("oro-subtitle")).getText();
        String expectedResult = "Vehicle Costs";

        Assert.assertEquals(actualResult, expectedResult);

    }

    //US2/AC2/TC1
    @Test
    public void createNewCost() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

        loginPage.login("User1", "UserUser123");
        vehicleCostsPage.navigateTo("Fleet", "Vehicle Costs");

        wait();
        vehicleCostsPage.clickToCreateVehicleCost();
        wait();
        vehicleCostsPage.putTheCostInfo();
    }

    /**
     * verify that list of costs visible to managers
     * */
    @Test(description = "US6/AC1", dataProvider = "managerCredentials")
    public void getCostsList(String userName, String password){
        LoginPage loginPage = new LoginPage();
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

        loginPage.login(userName, password);
        BrowserUtils.waitForPageToLoad(5);
        vehicleCostsPage.navigateTo("Fleet", "Vehicle Costs");
        BrowserUtils.waitForPageToLoad(5);

        Assert.assertFalse(vehicleCostsPage.costsList().isEmpty(), "Cannot see vehicle costs");
    }
    @DataProvider
    public Object[][] managerCredentials(){
        return new Object[][]{
                {"storemanager51", "UserUser123"},
                {"storemanager52", "UserUser123"},
                {"salesmanager101", "UserUser123"},
                {"salesmanager102", "UserUser123"},
                {"salesmanager103", "UserUser123"}
        };
    }

}

