package StepDefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class POMLoginStepDefination {

	static WebDriver driver;
    LoginPage login;
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.manage().window().maximize();
	   driver.get("http://localhost/RIS_SH");
	 
	}

	//@When("user enters valid username and password")
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) throws InterruptedException {
	//public void user_enters_valid_username_and_password() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectDefaultInstitute();
		
	}

	@And("clicks on Login Button")
	public void clicks_on_login_button() {
		login.clickLogin();
	}

	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
		login.isAtHomePage();
	    //Assert.assertTrue(driver.findElements(By.xpath("//label[@id='BreadcrumbText']")).size()>0, "User have been navigated to appointment list");
		//For navigating to BookView  
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdownhover-bottom']//li[@id='liSchedulingBookView']")).click();
	}

	@And("Close the browser")
	public void close_the_browser() {
         driver.close();   
	}

}
