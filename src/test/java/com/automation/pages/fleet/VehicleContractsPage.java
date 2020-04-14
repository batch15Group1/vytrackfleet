package com.automation.pages.fleet;

import com.automation.pages.login.LoginPage;
import com.automation.utilities.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class VehicleContractsPage extends AbstractPageBase {


    /**
     * US1##
     * 1. Verify that only authorized user should be able to access vehicle contract. (Note: authorized users: store manager
     * and sales manager)
     *
     * 2. Verify that non authorized user should not be able to access vehicle contract. (Note: Truck driver is unauthorized)
     */


    @Test
    public void verifyStoreManagerLogin(){

        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager51", "UserUser123");

        driver.quit();
    }






}
