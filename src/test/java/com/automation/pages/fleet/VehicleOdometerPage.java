package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class VehicleOdometerPage extends AbstractPageBase {



    @FindBy(xpath = "//div//h1[@class='oro-subtitle']")
    private WebElement vehicleOdometerTitle;

    @FindBy(xpath = "//div[@class='message' and text()='You do not have permission to perform this action.']")
    private WebElement warningMessage;

    @FindBy(className = "grid-header")
    private WebElement gridInformationTable;

    @FindBy(partialLinkText = "Create Vehicle")
    private WebElement  createVehicleOdometerButton;

    @FindBy(xpath = "//input[@name='custom_entity_type[OdometerValue]']")
    private WebElement odometerValue;

    @FindBy(xpath = "//input[@class='datepicker-input hasDatepicker']")
    private WebElement date;
    //select class

    @FindBy(className = "ui-datepicker-month")
    private WebElement monthButton;

    @FindBy(className = "ui-datepicker-year")
    private WebElement yearButton;

    @FindBy(xpath = "//input[@name='custom_entity_type[Driver]']")
    private WebElement driver;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndCloseButton;

    @FindBy(xpath = "//a[text()='Entities']")
    private WebElement entitiesTitle;


   @FindBy(xpath = "//h1[@class='user-name']")
   private WebElement driverName;

   @FindBy(partialLinkText= "Cancel")
   private WebElement cancelButton;

    @FindBy(partialLinkText= "Edit")
    private WebElement editButton;

    @FindBy(partialLinkText= "Delete")
    private WebElement deleteButton;

    @FindBy(partialLinkText= "Yes, Delete")
    private WebElement acceptDeleteButton;

    @FindBy(className = "flash-messages-holder")
    private WebElement deleteAcceptedText;

    public  String getTitleVehicleOdometer() {
        BrowserUtils.wait(3);
        return vehicleOdometerTitle.getText();
    }

    public String getWarningMessageNone_AuthorizedUser(){
         BrowserUtils.wait(6);
        return warningMessage.getText();
    }

    public String getHeaderInformationTable(){
        BrowserUtils.waitForPageToLoad(20);
       return gridInformationTable.getText();
    }

    public void createVehicleOdometer(String milesValue,String driverName,int month,String year,String day){
        String xpathDay="//a[text()='"+day+"']";
        BrowserUtils.wait(5);


        odometerValue.sendKeys(milesValue);

        date.click();


        Select selectMonth=new Select(monthButton);
        selectMonth.selectByIndex(month);

        Select selectYear=new Select(yearButton);
        selectYear.selectByValue(year);

        driver.findElement(By.xpath(xpathDay)).click();
        driver.sendKeys(driverName);
        BrowserUtils.wait(3);

    }

    public void editVehicleOdometer(String newDriverName){
        BrowserUtils.wait(3);
        driver.clear();
        BrowserUtils.wait(3);
        driver.sendKeys(newDriverName);

    }
    public void clickSaveAndCloseButton() {
        BrowserUtils.wait(2);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseButton)).click();
    }

    public String getDriverName(){
        BrowserUtils.wait(5);
        return driverName.getText();
    }

    public void clickCancelButton(){

        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }

    public void clickEditButton(){
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();

    }


    public void clickDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();

    }

    public void clickAcceptDeleteButton(){
        wait.until(ExpectedConditions.elementToBeClickable(acceptDeleteButton)).click();

    }
    public void clickCreateVehicleOdometerButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleOdometerButton)).click();
        BrowserUtils.wait(3);
    }

    public String getDeleteAcceptedMessage(){
        BrowserUtils.wait(3);
        return deleteAcceptedText.getText();
    }
}




