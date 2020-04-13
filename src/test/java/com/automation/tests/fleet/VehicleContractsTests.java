package com.automation.tests.fleet;

import com.automation.pages.fleet.VehicleContractsPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import com.automation.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VehicleContractsTests extends AbstractTestBase {

    /**
     * This is the test for authorized user (salemanager and storemanager)
     * to check out whether they are able to
     * access "Create Vehicle Contract" page
     * @param user
     * @param password
     */

    @Test(dataProvider = "credentialsForAuthorizedUser")
    public void authorizedUser(String user,String password){
        test = report.createTest("Reaching \"Create Vehicle Contract\" "+user);


        LoginPage loginPage=new LoginPage();
        loginPage.login(user,password);

        VehicleContractsPage vContractPage=new VehicleContractsPage();
        vContractPage.navigateTo("Fleet","Vehicle Contracts");
        String actual = vContractPage.createNewVehicle();
        String expected="Create Vehicle Contract";
        Assert.assertEquals(actual,expected);

        test.pass("As an authorized user, "+user+" reached the Create Vehicle Contract page");

    }

    @DataProvider
    public Object[][] credentialsForAuthorizedUser(){
        return new Object[][]{
                {ConfigurationReader.getProperty("store_manager"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("sales_manager"), ConfigurationReader.getProperty("password")}
        };
    }

    @Test
    public void unAuthorizedUser(){
        test = report.createTest("Driver - Vehicle Contract page - Alert message");

        LoginPage loginPage=new LoginPage();
        loginPage.login();

        VehicleContractsPage vContractPage=new VehicleContractsPage();
        vContractPage.navigateTo("Fleet","Vehicle Contracts");
        String actual = vContractPage.createNewVehicleforUnauthorizedUser();
        String expected="You do not have permission to perform this action.";
        Assert.assertEquals(actual,expected);

        test.pass("As an unauthorized user, driver is not able to reached the Create Vehicle Contract page");

    }
}
