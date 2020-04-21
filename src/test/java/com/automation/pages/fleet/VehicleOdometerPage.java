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

    @FindBy(xpath = "//div//button [@class='btn btn-success action-button']")
    private WebElement saveAndCloseButton;

    @FindBy(xpath = "//a[text()='Entities']")
    private WebElement entitiesTitle;








    public  String getTitleVehicleOdometer() {
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
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleOdometerButton)).click();
        BrowserUtils.wait(10);
        odometerValue.sendKeys(milesValue);

        date.click();


        Select selectMonth=new Select(monthButton);
        selectMonth.selectByIndex(month);

        Select selectYear=new Select(yearButton);
        selectYear.selectByValue(year);

        driver.findElement(By.xpath(xpathDay)).click();

        driver.sendKeys(driverName);
        BrowserUtils.wait(2);
        saveAndCloseButton.submit();

    }

    public String getEntitiesText(){
        return entitiesTitle.getText();
    }
}




