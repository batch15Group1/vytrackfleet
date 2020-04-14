package com.automation.pages.fleet;

import com.automation.utilities.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class VehiclesPage extends AbstractPageBase {

    /* User Story 1
      1) As a truck driver I should be able to access Vehicle under Fleet module."
          AC's
          1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
          2.Verify that when user click on any car on the grid , system should display general information about the car
          3.Verify that truck driver can add Event and it should display under Activity tab and General information page as well .
          4.Verify that Truck driver can reset the Grid by click on Grid setting"

      User Story 2
      2) As a store manager and Sales manager I should be able to create Vehicle"
          AC's
          "1.Verify that Store manager or sales manager should be able to see all vehicle information once
          navigate to Vehicle page
          2.Verify that Store manager or sales manager should be able to create and cancel car
          3.Verify that Store manager or sales manager should be able to add Vehicle Module and Vehicle Make
          4.Verify that Store manager or sales manager should be able to edit or delete the car
          5.Verify that Store manager or sales manager should be able to add event
          6.Verify that Store manager or sales manager should be able reset Grid by click on Grid setting" */


    /*  #US1_AC1
    Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page
    login - go to fleet then - vehicles page
    click on grid settings
    click on select all button
    collect all names as list under grid settings
    then collect all cars information's in a list
    compare 2 list, if equals test pass
     */

    /*  #US1_AC2
    Verify that when user click on any car on the grid , system should display general information about the car
    login - go to fleet then - vehicles page
    randomly select a page number from total page number
    then randomly click a car on that page
    and verify that you see "general information" text.
     */

    /* #US1_AC3
    Verify that truck driver can add Event and it should display under Activity tab and General information page as well
    login - go to fleet then - vehicles page
    randomly select a page number from total page number - then randomly click a car on that page (we will use this method from ac 2)
    click on add event
    enter title - description - choose guests - add reminders - choose context - choose owner
    type organizer display name - type organizer email - choose start and end date -
    click on save
    click on general page - verify that you see the event
    click on activity page - verify that you see the event
     */

    /*#US1_AC4
    4.Verify that Truck driver can reset the Grid by click on Grid setting"
    login - go to fleet - then vehicles page
    verify view per page number is 25
    click on view per page choose 100
    then verify the number is 100,
    then click on reset and verify number is 25
     */

    //**** #US1_AC1 ****
    @FindBy(css = "[class='column-manager dropdown']")
    private WebElement gridSettingsBtn;

    @FindBy(linkText = "Select All")
    private WebElement selectAllBtn;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
    private List<WebElement> vehicleInfoNames;

    @FindBy(xpath = "//div[@class='dropdown-menu']//span[@class='close']")
    private WebElement closeBtn;

    @FindBy(css = "[class='grid-header']>tr>th[class^='grid']")
    private List<WebElement> vehicleInfoTableHeader;


    //**** #US1_AC2 ****
    @FindBy(xpath = "//label[@class='dib' and starts-with(text(), 'of')]")
    private WebElement numberOfPages;

    @FindBy(css = "[type='number']")
    private WebElement pageNumberBox;

    @FindBy(tagName = "h5")
    private WebElement generalInfo;


    //**** #US1_AC3 ****

    @FindBy(xpath = "//a[text()=\"Add Event\"]")
    private WebElement addEventBtn;

    @FindBy(css = "[id^=\"oro_calendar_event_form_title-uid\"]")
    private WebElement titleTextBox;

    @FindBy(css = "iframe[id^=\"oro_calendar_event_form_description-uid\"]")
    private WebElement descriptionIframe;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(className = "color")
    private List<WebElement> colors;

    @FindBy(css = "[id^=\"s2id_oro_calendar_event_form_attendees-uid\"]")
    private WebElement guestTextBox;

    @FindBy(id = "oro_calendar_event_form_reminders-uid-5e95fa15e7450_collection")
    private WebElement addRemainderBtn;

    @FindBy(css = "[class=\"btn add-list-item\"]")
    private WebElement addRemainderEmailBtn;

    @FindBy(className = "number inline-field")
    private WebElement numberInlineBox;

    @FindBy(className = "unit inline-field")
    private WebElement unitInlineBox;

    @FindBy(xpath = "//*[text()='Save']")
    private WebElement savebtn;




    //**** #US1_AC1 ****
    public void clickOnGridSettings() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(gridSettingsBtn)).click();
    }

    public void clickSelectAll() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(selectAllBtn)).click();
    }

    /**
     * To get all vehicle information from grid settings to be able to compare, Assertion
     *
     * @return Set<String>
     */
    public Set<String> getAllVehicleInfoNamesFromGrid() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='ui-sortable']/tr")));
        Set<String> allVehicleInfoNamesFromGrid = new HashSet<>();
        for (WebElement vehicleInfoName : vehicleInfoNames) {
            if (vehicleInfoName.getText().equals("Catalog Value (VAT Incl.)")) {
                allVehicleInfoNamesFromGrid.add("CVVI");
            } else {
                allVehicleInfoNamesFromGrid.add(vehicleInfoName.getText().toUpperCase());
            }
        }
        return allVehicleInfoNamesFromGrid;
    }

    public void clickToClose() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
    }

    /**
     * To get all vehicle information from table header
     *
     * @return Set<String> to not have duplicates
     */
    public Set<String> getAllVehicleInfoFromTableHeader() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='grid-header']>tr>th[class^='grid']")));
        Set<String> allVehicleInfoNamesFromHeader = new HashSet<>();
        for (WebElement webElement : vehicleInfoTableHeader) {
            allVehicleInfoNamesFromHeader.add(webElement.getText().toUpperCase());
        }
        return allVehicleInfoNamesFromHeader;
    }

    //**** #US1_AC2 ****
    public void randomlySelectACar() {
        //of 16 => I split of and 16 and will get 16 part
        int totalPageNumber = Integer.parseInt(numberOfPages.getText().split(" ")[1]);
        //  System.out.println("Total pageNumber = " + totalPageNumber);
        //to randomly select a page number
        Random random = new Random();
        int pageNum = random.nextInt(totalPageNumber) + 1;
        //  System.out.println(pageNum);

        //pageNumberBox.clear(); ==> did not worked so i used below code with js executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //to clear page number input box to be able to use send keys method and enter a random page number
        js.executeScript("document.querySelector('[type=\"number\"]').setAttribute('value', '')");
        pageNumberBox.sendKeys(pageNum + "", Keys.ENTER);

        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(1);

        //to get all cars on a chosen page then click on a car randomly
        List<WebElement> carsOnCurrentPage = driver.findElements(By.cssSelector("tbody>tr>td[class$='LicensePlate']"));
        int carIndexNum = random.nextInt(carsOnCurrentPage.size());
        wait.until(ExpectedConditions.elementToBeClickable(carsOnCurrentPage.get(carIndexNum)));
        carsOnCurrentPage.get(carIndexNum).click();
    }

    //to get "General Information" text
    public String getInfoText() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h5")));
        return generalInfo.getText();
    }

    //**** #US1_AC3 ****
    public void clickAddEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(addEventBtn)).click();
    }
    public void enterTitle(String title){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(titleTextBox)).sendKeys(title);
    }
    public void enterDescription(String description){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionIframe));
        descriptionTextArea.sendKeys(description);
        BrowserUtils.wait(3);
        driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
    }
    public void selectARandomColor(){
        Random random = new Random();
        BrowserUtils.wait(2);
        int colorIndex = random.nextInt(colors.size());
        BrowserUtils.wait(2);
        colors.get(colorIndex).click();
        BrowserUtils.wait(3);
    }
    public void addGuestName(){
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(guestTextBox)).sendKeys("test guest", Keys.ENTER);
    BrowserUtils.wait(2);
    }
    public void addRemainder(){
        BrowserUtils.wait(2);
        addRemainderBtn.click();
        Select select = new Select(addRemainderEmailBtn);
        select.selectByVisibleText("Email");
        wait.until(ExpectedConditions.elementToBeClickable(numberInlineBox)).sendKeys("2");

        Select select1 = new Select(unitInlineBox);
        select1.selectByVisibleText("days");
    }
    public void clickToSave(){
        wait.until(ExpectedConditions.elementToBeClickable(savebtn)).click();
    }










}