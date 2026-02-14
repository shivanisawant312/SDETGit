package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory {

	WebDriver driver;
	
	@FindBy(id="LOGINNAME")
	WebElement txt_loginnamElement;
	@FindBy(id="PASSWORD")
	WebElement txt_passwordElement;
	@FindBy(id="MainFormLogin")
	WebElement btn_loginElement;
	
	
	public void enterLoginname(String username) {
		txt_loginnamElement.sendKeys(username);
	}
	public void enterPassword(String password) {
		txt_passwordElement.sendKeys(password);
	}
	public void clickOnLogin() {
		btn_loginElement.click();
	}
	
	public loginPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
