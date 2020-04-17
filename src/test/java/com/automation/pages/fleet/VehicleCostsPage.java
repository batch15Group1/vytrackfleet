package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VehicleCostsPage extends AbstractPageBase {

    WebDriverWait wait =new WebDriverWait(driver,10);

    //    5.Click  Create Vehicle Cost button
//    6.Put the informations
//    7. Click Save button
    @FindBy(className = "btn main-group btn-primary pull-right ")
    private WebElement createVehicleCost;

    @FindBy(id = "select2-drop-mask")
    private WebElement selectType;
    @FindBy(id = "custom_entity_type_TotalPrice-uid-5e93dcd32021f")
    private WebElement totalPrice;
    @FindBy(id = "date_selector_custom_entity_type_Date-uid-5e93dcd32030c")
    private WebElement date;
    @FindBy(id = "custom_entity_type_CostDescriptions-uid-5e93dcd3203f2")
    private WebElement costDescription;
    @FindBy(xpath = "*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")
    private WebElement selectDate;
    @FindBy(xpath = "*[@id='select2-drop']/ul[2]/li[1]/div")
    private WebElement selectCostType;

    // locators after signing with manager credentials
    @FindBy(css = "[title='Create Vehicle Costs']")
    private WebElement mCreateVehicleCost;
    @FindBy(xpath = "//select[@name='custom_entity_type[Type]']")
    private WebElement mCostType;
    @FindBy(css = "[class='select2-chosen']")
    private WebElement mChooseAValue;
    @FindBy(xpath = "//*[@class='select2-result-label' and text()='Road Assistance']")
    private WebElement mRoadAssistance;
    @FindBy(css = "[name='custom_entity_type[TotalPrice]']")
    private WebElement mTotalPrice;
    @FindBy(css = "[placeholder='Choose a date']")
    private WebElement mDate;
    @FindBy(css = "[data-handler='today']")
    private WebElement mToday;
    @FindBy(css = "[name='custom_entity_type[CostDescriptions]']")
    private WebElement mCostDescription;
    @FindBy(xpath = "//div/button[@type='submit']")
    private WebElement mSaveAndClose;
    @FindBy(css = "[data-action='cancel']")
    private WebElement mCancel;
    @FindBy(xpath = "//span[text()='General Information']")
    private WebElement mGeneralInformationTitle;


    public void clickToCreateVehicleCost(){
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleCost)).click();

    }
    public void putTheCostInfo(){
        WebDriverWait wait =new WebDriverWait(driver,10);
        selectType.click();
        selectCostType.click();
        totalPrice.sendKeys("1000");
        date.click();
        selectDate.click();
        costDescription.sendKeys("Test Cost Created");
    }


    ///// methods after signing with manager credentials
    /**
     * returning the list of costs from Vehicle Costs page
     * */
    public List<WebElement> costsList(){
        return Driver.getDriver().findElements(   By.cssSelector( "[class='grid-row row-click-action']" )   );
    }

    /**
     * managers clicking on "Create Vehicle Cost"
     * */
    public void mClickCreateVehicleCost(){
        wait.until(ExpectedConditions.elementToBeClickable(mCreateVehicleCost)).click();
    }

    /**
     * managers putting information for new cost
     * */
    public void mPutCostInfo(){
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.wait(3);
        mChooseAValue.click();
        BrowserUtils.wait(3);
        mRoadAssistance.click();
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleCost)).click();
        mTotalPrice.sendKeys("123123");
        mDate.click();
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleCost)).click();
        mToday.click();
        wait.until(ExpectedConditions.elementToBeClickable(createVehicleCost)).click();
        mCostDescription.sendKeys("asdasd asdasd asdasd asdasd");
        mSaveAndClose.click();
    }

    /**
     * managers cancelling the new cost before saving
     * */
    public void mCancelNewCost(){
        BrowserUtils.waitForPageToLoad(10);
        mCancel.click();
    }


}