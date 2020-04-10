package com.automation.tests.fleet;

import com.automation.pages.fleet.VehiclesModelPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VehiclesModelTests extends AbstractTestBase {


 @Test(dataProvider = "credential")
 public void accessToVehicleModelPage(String module,String subModule){

     LoginPage loginPage=new LoginPage();
     loginPage.login();
     VehiclesModelPage vehiclesModelPage=new VehiclesModelPage();
     vehiclesModelPage.navigateTo("Fleet","Vehicles Model");

     Assert.assertTrue(vehiclesModelPage.getSubTitle().isDisplayed());
 }


 @DataProvider
 public Object[][] credential() {
     return new Object[][]{
             {"storemanager51", "UserUser123"},
             {"salesmanager101", "UserUser123"},
             {"user1", "UserUser123"}
     };
 }




}
