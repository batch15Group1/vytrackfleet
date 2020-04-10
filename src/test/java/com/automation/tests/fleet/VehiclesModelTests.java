package com.automation.tests.fleet;

import com.automation.pages.fleet.VehiclesModelPage;
import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehiclesModelTests extends AbstractTestBase {


 @Test
 public void accessToVehicleModelPage(){
     LoginPage loginPage=new LoginPage();
     loginPage.login();
     VehiclesModelPage vehiclesModelPage=new VehiclesModelPage();
     vehiclesModelPage.navigateTo("Fleet","Vehicles Model");

     Assert.assertTrue(vehiclesModelPage.getSubTitle().isDisplayed());
 }

}
