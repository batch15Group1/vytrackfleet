package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VehicleServicesLogsPage extends AbstractPageBase {

    @FindBy(css ="[class='column-manager dropdown']")
    private WebElement gridSettingsBtn;

    @FindBy(css="[title='Create Vehicle Services Logs']")
    private WebElement createVehicleServicesLogs;

    @FindBy(css= "[title='Cancel']")
    private WebElement cancelBtn;

    @FindBy(css="[class='btn btn-success action-button']")
    private WebElement saveAndCloseBtn;

    @FindBy(css="[class ='select2-chosen']")
    private WebElement serviceType;

    public void clickServiceType(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(serviceType)).click();
        List<WebElement> allServiceTypes =driver.findElements(By.className("select2-results"));
        for(WebElement servicetype : allServiceTypes){
            if(servicetype.isDisplayed()){
                servicetype.click();
            }
        }

    }

    public void clickSaveAndCloseBtn(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
    }

    public void clickCancelBtn(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
    }


    public void clickCreateVehicleServicesLogs(){
    BrowserUtils.waitForPageToLoad(20);
    wait.until(ExpectedConditions.elementToBeClickable(createVehicleServicesLogs)).click();

}

public void clickOnGridSettings() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(gridSettingsBtn)).click();
    }
}
