package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EditAppointment {
	WebDriver driver;

    By editBtn = By.xpath("//a[text()='Edit']");
    By ageField = By.id("txtAge");
    By mobileField = By.id("txtMobile");
    By registrationType = By.id("ddlRegistrationType");
    By saveBtn = By.id("btnSave");

    public EditAppointment(WebDriver driver) {
        this.driver = driver;
    }

    public void openEditForm() {
        driver.findElement(editBtn).click();
    }

    public void updateDetails(String age, String mobile, String regType) {
        driver.findElement(ageField).clear();
        driver.findElement(ageField).sendKeys(age);

        driver.findElement(mobileField).clear();
        driver.findElement(mobileField).sendKeys(mobile);

        new Select(driver.findElement(registrationType)).selectByVisibleText(regType);
        driver.findElement(saveBtn).click();
    }

    public boolean isUpdated() {
        return driver.getPageSource().contains("Appointment updated");
    }
}