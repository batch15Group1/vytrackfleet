package com.automation.pages.fleet.vehiclesModel;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateVehiclesModelPage extends AbstractPageBase {
    private String filePath = "/Users/isikdurmus/Desktop/pic.jpg";
    @FindBy(css = "[id^='custom_entity_type_ModelName-uid']")
    private WebElement modelName;

    @FindBy(css = "[id^='custom_entity_type_make-uid']")
    private WebElement make;

    @FindBy(css = "[id^='select2-drop-mask']")
    private WebElement canBeRequested;

    @FindBy(css = "[id^='custom_entity_type_Logo_file-uid']")
    private WebElement logo;

    @FindBy(css = "[id^='custom_entity_type_CatalogValue-uid']")
    private WebElement catalogValue;

    @FindBy(css = "[id^='custom_entity_type_CO2Fee-uid']")
    private WebElement co2Fee;

    @FindBy(css = "[id^='custom_entity_type_Cost-uid']")
    private WebElement cost;

    @FindBy(css = "[id^='custom_entity_type_TotalCost-uid']")
    private WebElement totalCost;

    @FindBy(css = "[id^='custom_entity_type_CO2Emissions-uid']")
    private WebElement co2Emission;

    @FindBy(css = "[id^='s2id_custom_entity_type_FuelType-uid']")
    private WebElement fuelType;

    @FindBy(css = "[id^='custom_entity_type_Vendors-uid']")
    private WebElement vendors;

    public void enterModelName(String modelNameValue) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(modelName)).sendKeys(modelNameValue);
    }

    public void enterMake(String makeValue) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(make)).sendKeys(makeValue);
    }

    public void selectCanBeRequested(String yesNo) {
        BrowserUtils.waitForPageToLoad(20);
        Select selectCanBeRequested = new Select(canBeRequested);
        selectCanBeRequested.selectByVisibleText(yesNo);
    }

    public void uploadLogo(String filePath) {
        wait.until(ExpectedConditions.visibilityOf(logo)).sendKeys(filePath);
    }

    public void enterCatalogValue(String catalogValueVal){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(catalogValue)).sendKeys(catalogValueVal);
    }

    public void enterco2Fee(String co2FeeValue){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(co2Fee)).sendKeys(co2FeeValue);
    }
    public void enterCost(String costValue){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(cost)).sendKeys(costValue);
    }
    public void enterTotalCost(String totalCostValue){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(totalCost)).sendKeys(totalCostValue);
    }

    public void enterCo2Emission(String co2EmissionValue){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(co2Emission)).sendKeys(co2EmissionValue);
    }

    public void selectFuelType(String fuelTypeValue){
        BrowserUtils.waitForPageToLoad(20);
        Select selectCanBeRequested = new Select(fuelType);
        selectCanBeRequested.selectByVisibleText(fuelTypeValue);
    }


    public void enterVendors(String vendorValue){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(vendors)).sendKeys(vendorValue);
    }


}

