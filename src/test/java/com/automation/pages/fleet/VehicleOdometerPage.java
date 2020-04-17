package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleOdometerPage extends AbstractPageBase {



    @FindBy(xpath = "//div//h1[@class='oro-subtitle']")
    private WebElement vehicleOdometerTitle;

    @FindBy(xpath = "//div[@class='message' and text()='You do not have permission to perform this action.']")
    private WebElement warningMessage;


    public  String getTitleVehicleOdometer() {

        return vehicleOdometerTitle.getText();
    }

    public String getWarningMessageNone_AuthorizedUser(){

        return warningMessage.getText();
    }
}




