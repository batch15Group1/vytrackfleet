package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPage extends AbstractPageBase {

    /**
     * 1_) As a truck driver I should be able to access Vehicle under Fleet module."
     * <p>
     * 1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
     * 2.Verify that when user click on any car on the grid , system should display general information
     * about the car
     * 3.Verify that truck driver can add Event and it should display under Activity tab and General
     * information page as well .
     * 4.Verify that Truck driver can reset the Grid by click on Grid setting"
     * <p>
     * <p>
     * 2_) As a store manager and Sales manager I should be able to create Vehicle"
     * <p>
     * "1.Verify that Store manager or sales manager should be able to see all vehicle information once
     * navigate to Vehicle page
     * 2.Verify that Store manager or sales manager should be able to create and cancel car
     * 3.Verify that Store manager or sales manager should be able to add Vehicle Module and Vehicle Make
     * 4.Verify that Store manager or sales manager should be able to edit or delete the car
     * 5.Verify that Store manager or sales manager should be able to add event
     * 6.Verify that Store manager or sales manager should be able reset Grid by click on Grid setting"
     */

    /*
    1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page
    login -go to fleet - vehicles page
    click on grid settings
    select all checkboxes if not selected
    collect all names as list under grid settings
    then collect all cars information's in a list
    compare 2 list, if equals test pass
     */

    @FindBy(css = "[class='column-manager dropdown']")
    private WebElement gridSettingsBtn;

    @FindBy(css = "[class='renderable']")
    private List<WebElement> vehicleInfoNameAndCheckboxes;

    @FindBy(css = "[class='grid-header-row']>th[class^='grid']")
    private List<WebElement> vehicleInfoColumn;

    public void clickOnGridSettings() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(gridSettingsBtn)).click();
    }

    public List<String> clickAllVehicleInfoCheckboxes() {
        List<String> vehicleInfoNames = new ArrayList<>();
        for (WebElement checkbox : vehicleInfoNameAndCheckboxes) {
            wait.until(ExpectedConditions.elementToBeClickable(checkbox));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }else {
                continue;
            }
            vehicleInfoNames.add(checkbox.getText());
        }
        return vehicleInfoNames;
    }


    public List<String> getVehicleInfoColumnNames() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='grid-header-row']>th[class^='grid']")));
        return BrowserUtils.getTextFromWebElements(vehicleInfoColumn);
    }
}