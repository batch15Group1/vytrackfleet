package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleCostsPage extends AbstractPageBase {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement seeAllVehicleCosts;

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    private WebElement createVehicleCost;

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    private WebElement cancelCreateVehicleCostBtn;

    @FindBy(id = "select2-drop-mask")
    private WebElement selectType;

    @FindBy(xpath = "//input[contains(@id,'TotalPrice')]")
    private WebElement totalPrice;

    @FindBy(id = "date_selector_custom_entity_type_Date-uid-5e93dcd32030c")
    private WebElement date;

    @FindBy(id = "custom_entity_type_CostDescriptions-uid-5e93dcd3203f2")
    private WebElement costDescription;

    @FindBy(xpath = "*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")
    private WebElement selectDate;

    @FindBy(xpath = "*[@id='select2-drop']/ul[2]/li[1]/div")
    private WebElement costType;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement saveAndCloseBtn;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    private WebElement addEventBtn;

    @FindBy(xpath = "//input[@name='oro_calendar_event_form[title]']")
    private WebElement addEventTitle;

    @FindBy(xpath = "//a[@href='#scroll-2-61'][1]")
    private WebElement activity;



    public void clickToCreateVehicleCost() {
        //WebDriverWait wait =new WebDriverWait(driver,10);
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleCost)).click();
    }

    public void clickCancelCreateCostBtn() {
        // WebDriverWait wait =new WebDriverWait(driver,10);
         BrowserUtils.waitForPageToLoad(10);
         wait.until(ExpectedConditions.elementToBeClickable(cancelCreateVehicleCostBtn)).click();
        }

    @FindBy(css = "[name='custom_entity_type[Canberequested]']")
    private WebElement canBeRequested;

    public void selectCostType(String text) {
        BrowserUtils.waitForPageToLoad(20);
        driver.findElement(By.className("select2-chosen")).click();
        Select slctCanBeRequested = new Select(costType);
        slctCanBeRequested.selectByVisibleText("Tax Roll");
    }
    public void putTheCostInfo(){
        WebDriverWait wait =new WebDriverWait(driver,10);
        //selectCostType().click();
        totalPrice.sendKeys("2020");
//        date.click();
//        selectDate.click();
//        costDescription.sendKeys("Test Cost Created");
    }

    public void clickSaveAndClose(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
    }

    public void clickAddEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(addEventBtn)).click();
    }
    public void clickAddEventTitle() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(addEventTitle)).sendKeys("onuralp");
        addEventTitle.sendKeys(Keys.ENTER);
        activity.click();
    }

}

