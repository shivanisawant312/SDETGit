package pageObjects;

import java.time.Duration;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	By txt_username = By.id("LOGINNAME");
	By txt_password = By.id("PASSWORD");
	By dd_institute = By.id("select2-SelectedInstituteCode-container");
    By txt_searchInstitute = By.cssSelector("input[type='search']");
    By list_institutes = By.cssSelector("li[role='treeitem']");
	By btn_login = By.id("MainFormLogin");
	By lbl_AppListpage = By.xpath("//label[@id='BreadcrumbText']");
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void enterUsername(String username) 
	{
		driver.findElement(txt_username).sendKeys(username);
	}
	public void enterPassword(String password) 
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	public void selectDefaultInstitute() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Click the institute dropdown
	    WebElement instituteDropdown = wait.until(
	        ExpectedConditions.elementToBeClickable(By.id("select2-SelectedInstituteCode-container"))
	    );
	    instituteDropdown.click();

	    // Enter search keyword
	    WebElement searchBox = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']"))
	    );
	    searchBox.sendKeys("Arabia");

	    // Wait for the options to appear and select the correct hospital
	    List<WebElement> optionsElements = wait.until(
	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[role='treeitem']"))
	    );

	    for (WebElement opt : optionsElements) {
	        if (opt.getText().equalsIgnoreCase("Siemens Healthineers Pvt. Ltd. Saudi Arabia")) {
	            opt.click();
	            break;
	        }
	    }
	}
	 public void clickLogin() {
	        driver.findElement(btn_login).click();
	    }
	 public void isAtHomePage() {
			driver.findElement(lbl_AppListpage).isDisplayed();
		}
	 public void UserLogin(String username, String password, String searchKeyword, String instituteName) throws InterruptedException {
		 driver.findElement(txt_username).sendKeys(username);
		 driver.findElement(txt_password).sendKeys(password);
		 selectDefaultInstitute();
		 driver.findElement(btn_login).click();
	}
}






