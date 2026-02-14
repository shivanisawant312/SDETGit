package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchedulingBookView {

    WebDriver driver;
    WebDriverWait wait;

    public SchedulingBookView(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Click the 'Open' link for the given time slot
     * and then select the option from the dropdown menu.
     */
    public void selectOptionAtTime(String time, String optionText) {
        // 1. Click the 'Open' link at the specified time slot
        WebElement openLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//tbody[@id='tbody1']//tr[td[contains(text(), '" + time + "')]]//a[contains(@class,'HYPERLINKOPEN')]")
        ));
        openLink.click();

        // 2. Wait for the dropdown menu to appear
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("ul.dropdown-menu.addMenuRightClick")
        ));

        // 3. Click the desired option in the dropdown menu
        WebElement option = dropdownMenu.findElement(By.xpath(".//a[text()='" + optionText + "']"));
        option.click();
    }

    /**
     * Search and select an existing patient by name.
     */
    public void searchAndSelectPatient(String patientName) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPatientSearch")));
        searchField.clear();
        searchField.sendKeys(patientName);

        WebElement searchBtn = driver.findElement(By.id("btnSearchPatient"));
        searchBtn.click();

        WebElement patientRow = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//table[@id='tblPatients']//tr[td[contains(text(),'" + patientName + "')]]")
        ));
        patientRow.click();
    }

    /**
     * Add a new patient to the system.
     */
    public void addNewPatient(String patientID, String title, String firstName, String middleName,
                              String lastName, String gender, String dob, String age,
                              String mobile, String regType) {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAddPatient"))).click();

        driver.findElement(By.id("txtPatientID")).sendKeys(patientID);
        new Select(driver.findElement(By.id("ddlTitle"))).selectByVisibleText(title);
        driver.findElement(By.id("txtFirstName")).sendKeys(firstName);
        driver.findElement(By.id("txtMiddleName")).sendKeys(middleName);
        driver.findElement(By.id("txtLastName")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name='gender'][@value='" + gender + "']")).click();
        driver.findElement(By.id("txtDOB")).sendKeys(dob);
        driver.findElement(By.id("txtAge")).sendKeys(age);
        driver.findElement(By.id("txtMobile")).sendKeys(mobile);
        new Select(driver.findElement(By.id("ddlRegistrationType"))).selectByVisibleText(regType);
    }

    /**
     * Save newly added patient.
     */
    public void savePatient() {
        driver.findElement(By.id("btnSavePatient")).click();
        // Wait for patient save confirmation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Patient saved successfully')]")));
    }

    /**
     * Fill exam/appointment details.
     */
    public void fillAppointmentDetails(String category, String examName, String examDate,
                                       String startTime, String endTime, String modality,
                                       String status, String radiologist1, String radiologist2) {

        new Select(driver.findElement(By.id("ddlExamCategory"))).selectByVisibleText(category);
        new Select(driver.findElement(By.id("ddlExamName"))).selectByVisibleText(examName);
        driver.findElement(By.id("txtExamDate")).sendKeys(examDate);
        driver.findElement(By.id("txtStartTime")).sendKeys(startTime);
        driver.findElement(By.id("txtEndTime")).sendKeys(endTime);
        new Select(driver.findElement(By.id("ddlModality"))).selectByVisibleText(modality);
        new Select(driver.findElement(By.id("ddlStatus"))).selectByVisibleText(status);
        new Select(driver.findElement(By.id("ddlRadiologist1"))).selectByVisibleText(radiologist1);
        new Select(driver.findElement(By.id("ddlRadiologist2"))).selectByVisibleText(radiologist2);
    }

    /**
     * Save appointment/exam details.
     */
    public void saveExamDetails() {
        driver.findElement(By.id("btnSaveExam")).click();
        // Wait for confirmation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Appointment saved successfully')]")));
    }

    /**
     * Verify appointment saved.
     */
    public boolean isAppointmentSaved() {
        return driver.getPageSource().contains("Appointment saved successfully");
    }
}
