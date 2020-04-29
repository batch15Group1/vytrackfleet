package com.automation.tests.fleet;

import com.automation.pages.fleet.VehicleCostsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleCostsTests extends AbstractTestBase {

    //1.Verify that truck driver should be able to see all cars' cost informations on the Vehicle Costs page.
    @Test
    public void seeCostInfo() {
        LoginPage loginPage = new LoginPage();
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
        loginPage.login("User1", "UserUser123");
        vehicleCostsPage.navigateTo("Fleet", "Vehicle Costs");
        String actualResult = Driver.getDriver().findElement(By.className("oro-subtitle")).getText();
        System.out.println(actualResult);
        String expectedResult = "Vehicle Costs";
        Assert.assertEquals(actualResult, expectedResult);
    }


    //2.Verify that truck driver should be able to create and cancel Vehicle cost.
    //#1 cancel
    @Test
    public void testCreateVehicleCostCancellation () {
        LoginPage loginPage = new LoginPage();
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
        loginPage.login("User1", "UserUser123");
        vehicleCostsPage.navigateTo("Fleet", "Vehicle Costs");
        vehicleCostsPage.clickToCreateVehicleCost();
        vehicleCostsPage.clickCancelCreateCostBtn();
        String actualResult = Driver.getDriver().findElement(By.linkText("Vehicle Costs")).getText();
        String expectedResult = "Vehicle Costs";
        Assert.assertEquals(actualResult, expectedResult);
    }


    //2.Verify that truck driver should be able to create and cancel Vehicle cost.
    //#1 create
    @Test
    public void createNewCost() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

        loginPage.login("User1", "UserUser123");
        vehicleCostsPage.navigateTo("Fleet", "Vehicle Costs");
        vehicleCostsPage.clickToCreateVehicleCost();
        //vehicleCostsPage.putTheCostInfo();
        vehicleCostsPage.clickSaveAndClose();
        //Driver.getDriver().navigate().back();
        String actual = Driver.getDriver().findElement(By.xpath("//h1[@class='user-name']")).getText();
        String expected = "Create Vehicle Costs";
        Assert.assertEquals(actual, expected);
    }
//5.Verify that truck driver should be able to edit or delete Vehicle cost
    @Test
    public void testAddEvent() {
        LoginPage loginPage = new LoginPage();
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
        loginPage.login("User1", "UserUser123");
        vehicleCostsPage.navigateTo("Fleet", "Vehicle Costs");
        vehicleCostsPage.clickToCreateVehicleCost();
        //vehicleCostsPage.putTheCostInfo();
        vehicleCostsPage.clickSaveAndClose();
        vehicleCostsPage.clickAddEvent();
        String actual = Driver.getDriver().findElement(By.xpath("//h1[@class='user-name']")).getText();
        Assert.assertTrue(actual.contains("Item"));
    }

    //4. Verify that truck driver should be able to add Attachement on General information page by click on any of the car on the grid.

}

