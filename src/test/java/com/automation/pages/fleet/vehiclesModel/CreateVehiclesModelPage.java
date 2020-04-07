package com.automation.pages.fleet.vehiclesModel;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateVehiclesModelPage extends AbstractPageBase {
    @FindBy(css = "[id^='custom_entity_type_ModelName-uid']")
    private WebElement modelName;

    @FindBy(css = "[id^='custom_entity_type_make-uid']")
    private WebElement make;


    public void enterModelName(String modelNameValue) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(modelName)).sendKeys(modelNameValue);
    }

    public void enterMake(String makeValue) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(make)).sendKeys(makeValue);
    }
}

