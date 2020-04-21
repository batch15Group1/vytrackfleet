package com.automation.tests.fleet;

import com.automation.pages.fleet.VehicleOdometerPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;



public class VehicleOdometerTests extends AbstractTestBase {


/**
 * Verify that Only truck driver and admin can access to vehicle odometer page
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


    /**
     * Verify that Only truck driver can access to vehicle odometer page
     * with invalid password
     */

@Test
public void verifyTrackUserNavigateWithInvalidPassword(){
    test=report.createTest("Verify truck driver can not navigate page with invalid password");
    LoginPage loginPage = new LoginPage();
    loginPage.login("user1","wrong" );
    String actual=loginPage.getWarningMessageText();
    String expected="Invalid user name or password.";
    Assert.assertEquals(actual,expected);

    test.pass("User con not navigate with invalid password");
}

    /**
     * Verify that non autorized user Not able to access Vehicle odometer page
     * as a sales manager
     */

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

    /**
     * Verify that non autorized user Not able to access Vehicle odometer page
     * as a store manager
     */

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

    /**
     * Verify that truck driver should be able to see all vehicle odometer informations
     * on the grid.
     */
    @Test
    public void verifyDriverSeeInformationOnGrid(){
    LoginPage loginPage=new LoginPage();
    VehicleOdometerPage vehicleOdometerPage=new VehicleOdometerPage();
    loginPage.loginAsDriver();
    vehicleOdometerPage.navigateTo("Fleet","Vehicle Odometer");

    String actual= vehicleOdometerPage.getHeaderInformationTable();
    String expected="ODOMETER VALUE\n" +
            "DATE\n" +
            "DRIVER\n" +
            "UNIT\n" +
            "MODEL";
    Assert.assertEquals(actual,expected);



    }

    /**
     * Verify that Truck driver should be able to create Vehicle odometer
     */

    @Test
    public void verifyDriverCreateVehicleOdometer(){
        test=report.createTest("Verify Truck driver create vehicle odometer");

        LoginPage loginPage=new LoginPage();
        VehicleOdometerPage vehicleOdometerPage=new VehicleOdometerPage();
        loginPage.loginAsDriver();

        vehicleOdometerPage.navigateTo("Fleet","Vehicle Odometer");
        BrowserUtils.wait(3);

        vehicleOdometerPage.createVehicleOdometer("120","newdriver",5,"2020","25");

        String actual=vehicleOdometerPage.getEntitiesText();
        String expected="Entities";

        Assert.assertEquals(actual,expected);

        test.pass("Truck driver created vehicle successfully ");

    }
}

