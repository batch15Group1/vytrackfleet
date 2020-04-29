package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VehicleServicesLogsPage extends AbstractPageBase {

    @FindBy(css="[title='Create Vehicle Services Logs']")
    private WebElement createVehicleServicesLogs;

    @FindBy(css= "[title='Cancel']")
    private WebElement cancelBtn;

    @FindBy(css="[class='btn btn-success action-button']")
    private WebElement saveAndCloseBtn;

    @FindBy(css="[class ='select2-chosen']")
    private WebElement serviceType;

    @FindBy(css="[class ='select2-result-label']")
    private  List<WebElement> allServicesTypes;

    @FindBy(xpath = "//table//tbody//tr[1]//td[2]")
    private WebElement oneOfTheServicesType;

    @FindBy(css= "[title='Edit Vehicle Services Logs']")
    private  WebElement editBtn;

    @FindBy(css = "[title='Delete Vehicle Services Logs']")
    private  WebElement deleteBtn;

    @FindBy(css = "[title='Add an event to this record']")
    private  WebElement addEventBtn;

    @FindBy(xpath = "//div[text()=\"You do not have permission to perform this action.\"]")
    private WebElement warning_Message;

    @FindBy(xpath = "//span[text()=\"Vehicle Services Logs\"]")
        private WebElement vehicleServicesLogsTab;

    @FindBy(css="div[class='flash-messages-holder']")
    private WebElement flashMessage;

    @FindBy(id="select2-drop-mask")
    private WebElement deleteConfirmationMessage;

    @FindBy(linkText = "Yes, Delete")
    private WebElement yesDeleteBtn;

    @FindBy(xpath = "//*[@class='flash-messages-holder']")
    private WebElement deleteFlashMessage;

    @FindBy(css = "a[title*='Grid Settings']")
    private WebElement gridSettingBtn;

    @FindBy(css = "input[name='oro_calendar_event_form[title]']")
    private WebElement addEventTitleInput;

    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement addEventSaveBtn;

    @FindBy(xpath = "//*[@class='flash-messages-holder']")
    private WebElement addEventFlashMessage;


    public String getAddEventFlashMessage(){
        BrowserUtils.waitForPageToLoad(30);
        BrowserUtils.wait(2);
        return addEventFlashMessage.getText();
    }


    public String getDeleteConfirmationMessage(){
        BrowserUtils.wait(3);
        return deleteFlashMessage.getText();
    }

    public String getSaveAndCloseFlashMessage(){
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(3);
        return flashMessage.getText();
    }

    public String getWarningMessageNonAuthorizedUser(){

            return warning_Message.getText();
        }

        public void clickOneOFTheServicesTypeAndClickEditBTn() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(oneOfTheServicesType)).click();
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.waitForPageToLoad(30);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();


    }

    public void clickOneOFTheServicesTypeAndClickDeleteBTn() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(oneOfTheServicesType)).click();
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.waitForPageToLoad(30);
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(yesDeleteBtn)).click();



    }
        public void clickOneOFTheServicesTypeAndClickAddEventBTn(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(oneOfTheServicesType)).click();
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.waitForPageToLoad(30);
        wait.until(ExpectedConditions.elementToBeClickable(addEventBtn)).click();
        BrowserUtils.wait(2);
        addEventTitleInput.sendKeys("Hello World");
        BrowserUtils.wait(2);
        addEventSaveBtn.click();


    }


    public void isDisplayedServiceType(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(serviceType)).click();
        List<WebElement> allServiceTypes =driver.findElements(By.className("select2-results"));
        for(WebElement servicetype : allServiceTypes){
            if(servicetype.isDisplayed()){
                //servicetype.click();
            }
        }

    }

    public void getTitleDisplayedAllServiceType() {
        BrowserUtils.waitForPageToLoad(30);
        BrowserUtils.wait(3);
        for (WebElement each : allServicesTypes) {
            if (each.isDisplayed()) {
                System.out.println(each.getText());
            }
        }
    }


    public void clickSaveAndCloseBtn(){
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(4);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
    }

    public void clickCancelBtn(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
    }


    public void clickCreateVehicleServicesLogs(){
    BrowserUtils.waitForPageToLoad(20);
    BrowserUtils.wait(3);
    wait.until(ExpectedConditions.elementToBeClickable(createVehicleServicesLogs)).click();

}

public void clickOnGridSettings() {
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(4);
        wait.until(ExpectedConditions.elementToBeClickable(gridSettingBtn)).click();
    }

    public String Gettextgridsetting(){
        BrowserUtils.wait(3);
        return gridSettingBtn.getText();
    }

}
