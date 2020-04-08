package com.automation.tests.fleet;

import com.automation.pages.fleet.VehiclesPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VehiclesTests extends AbstractTestBase {

    @Test
    public void verifyAllVehicleInformation(){
        test = report.createTest("Verify all vehicle information");

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();
        loginPage.login("user1","UserUser123" );
        test.info("Login as truck driver");
        vehiclesPage.navigateTo("Fleet","Vehicles");
        vehiclesPage.clickOnGridSettings();
        List<String> expected = vehiclesPage.clickAllVehicleInfoCheckboxes();
        List<String> actual = vehiclesPage.getVehicleInfoColumnNames();

        Assert.assertEquals(actual,expected);


        test.pass("All vehicle information were verified! ");

    }
}
