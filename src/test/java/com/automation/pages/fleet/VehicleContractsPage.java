package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VehicleContractsPage extends AbstractPageBase {

    @FindBy(css = ".pull-right.title-buttons-container > a")
    private WebElement  createVehicleContractButton;

    @FindBy (css = "#s2id_custom_entity_type_Type-uid-5e8dfe2b8ffea > a")
    private WebElement typeOptionsClick;

    @FindBy (css = ".select2-result-label")
    private WebElement optionsForType;

    @FindBy (css = ".user-name")
    private WebElement isCreateVehicleDisplayed;

    @FindBy (xpath = "//div[@class='flash-messages-holder']//div[2]//div")
    private WebElement alertMessageforUnauthorizedUser;

    public String createNewVehicle(){
       wait.until(ExpectedConditions.elementToBeClickable(createVehicleContractButton)).click();
       return wait.until(ExpectedConditions.visibilityOf(isCreateVehicleDisplayed)).getText();
    }

    public String createNewVehicleforUnauthorizedUser(){
        return wait.until(ExpectedConditions.visibilityOf(alertMessageforUnauthorizedUser)).getText();
    }


}
