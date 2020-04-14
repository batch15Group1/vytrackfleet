package com.automation.tests.fleet;

import com.automation.pages.fleet.VehiclesPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class VehiclesTests extends AbstractTestBase {

    // #US1_AC1
    @Test(description = "driver should be able to see all Vehicle information once navigate to Vehicle page")
    public void verifyAllVehicleInformation(){
        test = report.createTest("Verify all vehicle information");

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        loginPage.loginAsDriver();
        test.info("Login as truck driver");
        vehiclesPage.navigateTo("Fleet","Vehicles");
        vehiclesPage.clickOnGridSettings();
        vehiclesPage.clickSelectAll();

        Set<String> expected = vehiclesPage.getAllVehicleInfoNamesFromGrid();
        Set<String> actual = vehiclesPage.getAllVehicleInfoFromTableHeader();
        Assert.assertEquals(actual,expected);

        test.pass("All vehicle information were verified! ");
    }

    // #US1_AC2
    @Test(description = "when driver click on any car on the grid, system should display general information about the car")
    public void verifyGeneralInfoText(){
        test = report.createTest("Verify general information text");

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        loginPage.loginAsDriver();
        test.info("Login as truck driver");
        vehiclesPage.navigateTo("Fleet","Vehicles");

        vehiclesPage.randomlySelectACar();
        String actual = vehiclesPage.getInfoText();
        String expected = "General Information";
        Assert.assertEquals(actual,expected);

        test.pass("General information is verified! ");
    }
}
