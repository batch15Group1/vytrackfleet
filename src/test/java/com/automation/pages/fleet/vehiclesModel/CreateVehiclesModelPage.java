package com.automation.pages.fleet.vehiclesModel;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateVehiclesModelPage extends AbstractPageBase {
    @FindBy(css = "[id^='custom_entity_type_ModelName-uid']")
    private WebElement modelName;

    @FindBy(css = "[name='custom_entity_type[Make]']")
    private WebElement make;

    @FindBy(css = "[name='custom_entity_type[Canberequested]']")
    private WebElement canBeRequested;

    @FindBy(xpath = "//*[@type='file' and @name='custom_entity_type[Logo][file]']")
    private WebElement logo;

    @FindBy(css = "[name='custom_entity_type[CatalogValue]']")
    private WebElement catalogValue;

    @FindBy(css = "[name='custom_entity_type[CO2Fee]']")
    private WebElement co2Fee;

    @FindBy(css = "[name='custom_entity_type[Cost]']")
    private WebElement cost;

    @FindBy(css = "[name='custom_entity_type[TotalCost]']")
    private WebElement totalCost;

    @FindBy(css = "[name='custom_entity_type[CO2Emissions]']")
    private WebElement co2Emission;

    @FindBy(css = "[name='custom_entity_type[FuelType]']")
    private WebElement fuelType;

    @FindBy(css = "[name='custom_entity_type[Vendors]']")
    private WebElement vendors;

    @FindBy(css = "[class='btn btn-success action-button']")
    private WebElement saveAndCloseBtn;

    public void clickOnSaveAndCloseBtn(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
    }
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
        Select slctCanBeRequested = new Select(canBeRequested);
        slctCanBeRequested.selectByVisibleText(yesNo);
    }

    public void uploadLogo(String filePath) {
        wait.until(ExpectedConditions.visibilityOf(logo)).sendKeys(filePath);
    }

    public void enterCatalogValue(String catalogValueVal){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(catalogValue)).sendKeys(catalogValueVal);
    }

    public void enterCo2Fee(String co2FeeValue){
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

