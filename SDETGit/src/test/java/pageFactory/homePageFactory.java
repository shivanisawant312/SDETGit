package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageFactory {
    WebDriver driver;
	@FindBy(xpath = "//label[@id='BreadcrumbText']")
	WebElement lbl_appintmentlistElement;
	
	public void isappointlistDisplayed() {
	
		lbl_appintmentlistElement.isDisplayed();
		}
	
	public homePageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
