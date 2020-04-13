package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleCostsPage extends AbstractPageBase {
//    5.Click  Create Vehicle Cost button
//    6.Put the informations
//    7. Click Save button
    @FindBy(className = "btn main-group btn-primary pull-right ")
    private WebElement createVehicleCost;

    @FindBy(className = "select2-chosen")
    private WebElement selectType;
    @FindBy(id = "custom_entity_type_TotalPrice-uid-5e93dcd32021f")
    private WebElement totalPrice;
    @FindBy(id = "date_selector_custom_entity_type_Date-uid-5e93dcd32030c")
    private WebElement date;
    @FindBy(id = "custom_entity_type_CostDescriptions-uid-5e93dcd3203f2")
    private WebElement costDescription;

    public void clickToCreateVehicleCost(){
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleCost)).click();
    }
public void setActualResult() {
}



}

