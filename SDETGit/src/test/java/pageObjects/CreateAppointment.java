package pageObjects;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAppointment {

    WebDriver driver;
    WebDriverWait wait;

    // Patient Fields
    By patientSearchField = By.id("txtPatientSearch");
    By patientSearchResult = By.xpath("//table[@id='tblPatientSearch']//tr[1]");
    By addPatientBtn = By.id("btnAddPatient");

    By patientIDField = By.id("txtPatientID");
    By titleDropdown = By.id("ddlTitle");
    By firstNameField = By.id("txtFirstName");
    By middleNameField = By.id("txtMiddleName");
    By lastNameField = By.id("txtLastName");
    By genderMaleRadio = By.id("rdoMale");
    By genderFemaleRadio = By.id("rdoFemale");
    By dobField = By.id("txtDOB");
    By ageField = By.id("txtAge");
    By mobileField = By.id("txtMobile");
    By regTypeDropdown = By.id("ddlRegistrationType");
    By savePatientBtn = By.id("btnSavePatient");

    // Appointment Fields (Exam/Booking)
    By dateField = By.id("txtDate");
    By categoryDropdown = By.id("ddlCategory");
    By timeSlotCell = By.xpath("//td[contains(text(),'TIME')]");
    By optionBtn = By.xpath("//a[text()='OPTION']");
    By examCategoryDropdown = By.id("ddlExamCategory");
    By examNameDropdown = By.id("ddlExamName");
    By examDateField = By.id("txtExamDate");
    By startTimeField = By.id("txtStartTime");
    By endTimeField = By.id("txtEndTime");
    By modalityDropdown = By.id("ddlModality");
    By statusDropdown = By.id("ddlStatus");
    By radiologist1Dropdown = By.id("ddlRadiologist1");
    By radiologist2Dropdown = By.id("ddlRadiologist2");
    By saveExamBtn = By.id("btnSaveExam");

    By successMessage = By.xpath("//div[contains(text(),'Appointment saved')]");

    public CreateAppointment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ------------------ Existing Patient -------------------
    public void selectExistingPatient(String patientName) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(patientSearchField));
        searchField.clear();
        searchField.sendKeys(patientName);

        // Wait and select first result
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(patientSearchResult));
        firstResult.click();
    }

    // ------------------ Add New Patient -------------------
    public void addNewPatient(String patientID, String title, String firstName, String middleName,
                              String lastName, String gender, String dob, String age, 
                              String mobile, String regType) {

        driver.findElement(addPatientBtn).click();

        driver.findElement(patientIDField).sendKeys(patientID);
        new Select(driver.findElement(titleDropdown)).selectByVisibleText(title);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(middleNameField).sendKeys(middleName);
        driver.findElement(lastNameField).sendKeys(lastName);

        if (gender.equalsIgnoreCase("Male")) {
            driver.findElement(genderMaleRadio).click();
        } else if (gender.equalsIgnoreCase("Female")) {
            driver.findElement(genderFemaleRadio).click();
        }

        driver.findElement(dobField).sendKeys(dob);
        driver.findElement(ageField).sendKeys(age);
        driver.findElement(mobileField).sendKeys(mobile);
        new Select(driver.findElement(regTypeDropdown)).selectByVisibleText(regType);
    }

    public void savePatient() {
        driver.findElement(savePatientBtn).click();
        // Wait until save completes
        wait.until(ExpectedConditions.invisibilityOfElementLocated(savePatientBtn));
    }

    // ------------------ Appointment Details -------------------
    public void selectDate(String date) {
        WebElement dateEl = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        dateEl.clear();
        dateEl.sendKeys(date);
    }

    public void selectCategory(String category) {
        new Select(driver.findElement(categoryDropdown)).selectByVisibleText(category);
    }

    public void selectTimeSlot(String timeSlot) {
        driver.findElement(By.xpath("//td[contains(text(),'" + timeSlot + "')]")).click();
    }

    public void chooseOption(String option) {
        driver.findElement(By.xpath("//a[text()='" + option + "']")).click();
    }

    public void fillAppointmentDetails(String examCategory, String examName, String examDate,
                                       String startTime, String endTime, String modality,
                                       String status, String radiologist1, String radiologist2) {
        new Select(driver.findElement(examCategoryDropdown)).selectByVisibleText(examCategory);
        new Select(driver.findElement(examNameDropdown)).selectByVisibleText(examName);

        driver.findElement(examDateField).clear();
        driver.findElement(examDateField).sendKeys(examDate);

        driver.findElement(startTimeField).clear();
        driver.findElement(startTimeField).sendKeys(startTime);

        driver.findElement(endTimeField).clear();
        driver.findElement(endTimeField).sendKeys(endTime);

        new Select(driver.findElement(modalityDropdown)).selectByVisibleText(modality);
        new Select(driver.findElement(statusDropdown)).selectByVisibleText(status);
        new Select(driver.findElement(radiologist1Dropdown)).selectByVisibleText(radiologist1);
        new Select(driver.findElement(radiologist2Dropdown)).selectByVisibleText(radiologist2);
    }

    public void saveExamDetails() {
        driver.findElement(saveExamBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }

    public boolean isAppointmentSaved() {
        try {
            return driver.findElement(successMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
