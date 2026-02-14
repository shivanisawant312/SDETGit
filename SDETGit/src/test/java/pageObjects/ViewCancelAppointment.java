package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCancelAppointment {
	
	WebDriver driver;

By searchField = By.id("txtSearch");
By appointmentRows = By.cssSelector("table#tblAppointments tbody tr");
By cancelBtn = By.xpath("//a[text()='Cancel']");

public ViewCancelAppointment(WebDriver driver) {
    this.driver = driver;
}

public void openAppointmentList() {
    driver.findElement(By.linkText("Appointment List")).click();
}

public void searchAppointment(String patientName) {
    driver.findElement(searchField).clear();
    driver.findElement(searchField).sendKeys(patientName);
}

public boolean isListDisplayed() {
    return driver.findElements(appointmentRows).size() > 0;
}

public void cancelAppointment() {
    driver.findElement(cancelBtn).click();
    driver.switchTo().alert().accept();
}

public String getStatus() {
    return driver.findElement(By.xpath("//table[@id='tblAppointments']//tr[1]/td[5]")).getText();
}
}