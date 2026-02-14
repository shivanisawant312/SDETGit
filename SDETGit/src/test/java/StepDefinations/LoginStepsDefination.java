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

public class LoginStepsDefination {
	/*
	static WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   driver.get("http://localhost/RIS_SH");
	}

	//@When("user enters valid username and password")
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) throws InterruptedException {
	//public void user_enters_valid_username_and_password() throws InterruptedException {
		driver.findElement(By.id("LOGINNAME")).sendKeys(username);
		driver.findElement(By.id("PASSWORD")).sendKeys(password);
		driver.findElement(By.id("select2-SelectedInstituteCode-container")).click();
		  driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Arabia");
		  Thread.sleep(3000);
		  List<WebElement> optionsElements = driver.findElements(By.cssSelector("li[role= 'treeitem']"));
		  Thread.sleep(3000);
		  for(WebElement opt :optionsElements)
		  {
			  if(opt.getText().equalsIgnoreCase("Siemens Healthineers Pvt. Ltd. Saudi Arabia"))
					  {
				        opt.click();
				        break;
					  }
		  }
	}

	@And("clicks on Login Button")
	public void clicks_on_login_button() {
		driver.findElement(By.id("MainFormLogin")).click();
	}

	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
	    Assert.assertTrue(driver.findElements(By.xpath("//label[@id='BreadcrumbText']")).size()>0, "User have been navigated to appointment list");
	}

	@And("Close the browser")
	public void close_the_browser() {
         driver.close();   
	}

*/
}
