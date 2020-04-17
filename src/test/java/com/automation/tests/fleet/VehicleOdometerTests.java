package com.automation.tests.fleet;

import com.automation.pages.fleet.VehicleOdometerPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class VehicleOdometerTests extends AbstractTestBase {

    protected WebDriver driver=Driver.getDriver();
/**
 * Verify that Only truck driver and admin can access to vehicle odometer page
 * 1.Open the URL
 * 2.Enter valid credentials and click LOG IN button
 * 3.Hover over "Fleet " module
 * 4. click "Vehicle Odometer"
 */
@Test
public void verifyTrackUserNavigate(){
    test = report.createTest("Verify truck driver can navigate to vehicle odometer module");

    LoginPage loginPage = new LoginPage();
    VehicleOdometerPage vehicleOdometerPage = new VehicleOdometerPage();
    loginPage.login("user1","UserUser123" );
    test.info("Login as truck driver");
    vehicleOdometerPage.navigateTo("Fleet","Vehicle Odometer");

    String actual=vehicleOdometerPage.getTitleVehicleOdometer();
    String expected="Vehicles Odometers";

    Assert.assertEquals(actual,expected);

    test.pass("Truck driver login successfully");

}

@Test
public void verifySalesManagerNavigate(){
    test = report.createTest("Verify salesmanager  driver can not navigate to vehicle odometer module");

    LoginPage loginPage = new LoginPage();
    VehicleOdometerPage vehicleOdometerPage = new VehicleOdometerPage();
    loginPage.login("salesmanager101","UserUser123" );
    test.info("Login as salesmanager");
    vehicleOdometerPage.navigateTo("Fleet","Vehicle Odometer");

    String actual=vehicleOdometerPage.getWarningMessageNone_AuthorizedUser();
    String expected="You do not have permission to perform this action.";

    Assert.assertEquals(actual,expected);

    test.pass("None_AuthorizedUser not be able to access vehicle odometer page");
}

    @Test
    public void verifyStoreManagerNavigate(){
        test = report.createTest("Verify storemanager  driver can not navigate to vehicle odometer module");

        LoginPage loginPage = new LoginPage();
        VehicleOdometerPage vehicleOdometerPage = new VehicleOdometerPage();
        loginPage.login("storemanager51","UserUser123" );
        test.info("Login as storemanager");
        vehicleOdometerPage.navigateTo("Fleet","Vehicle Odometer");

        String actual=vehicleOdometerPage.getWarningMessageNone_AuthorizedUser();
        String expected="You do not have permission to perform this action.";

        Assert.assertEquals(actual,expected);

        test.pass("None_AuthorizedUser not be able to access vehicle odometer page");
    }

}

