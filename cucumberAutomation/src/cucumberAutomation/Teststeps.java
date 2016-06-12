package cucumberAutomation;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Liabrary.Utility;

import org.junit.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Teststeps {

	WebDriver driver;

	@Given("^I am on QA Home Page$")
	public void i_am_on_QA_Home_Page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://secure-qa2.int.capitalone360qa.com/myaccount/banking/login.vm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I enters \"([^\"]*)\" and \"([^\"]*)\" I navigate to summary page$")
	public void i_enters_and_I_navigate_to_summary_page(String username, String password) throws Throwable {

		driver.findElement(By.id("ACNID")).sendKeys(username);

		driver.findElement(By.id("btn_continue")).click();

		driver.findElement(By.id("currentPassword_TLNPI")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id='PasswordForm']/div[3]/div[2]/div[2]/div/div/span/a")).click();

	}

	@Then("^I clicks on Transfer&Deposits \"([^\"]*)\"$")
	public void i_clicks_on_Transfer_Deposits(String Tab) throws Throwable {

		Thread.sleep(5000);
		
		Utility.robotClass(driver, "User has been Naviagted to summary Page");
		
		driver.findElement(By.xpath("//*[@id='tab_Transfer Money']/span")).click();

	}

	@Then("^I clicks on Image Upload \"([^\"]*)\"$")
	public void i_clicks_on_Image_Upload(String Link) throws Throwable {

		driver.findElement(By.xpath("//*[@id='tab_mega_UploadCheck']")).click();
	}

	@Then("^I enters Check Info$")
	public void i_enters_Check_Info() throws Throwable {
		driver.findElement(By.id("amount")).sendKeys("1");

		driver.findElement(By.xpath("//*[@id='accountNumber']")).sendKeys("360 Checking");

		driver.findElement(By.id("memo")).sendKeys("ImageUpload");

		driver.findElement(By.xpath("//*[@id='PageForm']/div[3]/div/div/span/a")).click();

		Thread.sleep(5000);
	}

	@Then("^I click on the continue button$")
	public void i_click_on_the_continue_button() throws Throwable {

		driver.findElement(By.xpath("//*[@id='lb_modalContinue']/a")).click();
	}

	@Then("^I Upload the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_Upload_the_and(String fimage, String bimage) throws Throwable {

		driver.findElement(By.id("frontFile")).sendKeys(fimage);

		Thread.sleep(5000);

		driver.findElement(By.id("backFile")).sendKeys(bimage);

		Thread.sleep(5000);
		
		Utility.robotClass(driver, "Images Uploaded Successfully");
		

		driver.findElement(By.id("continueButton")).click();
	}

	@Then("^I validate the\"([^\"]*)\"$")
	public void i_validate_the(String Message) throws Throwable {
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='content']/div[5]/div/span[2]/b")).getText().contains(Message));

	}

}
