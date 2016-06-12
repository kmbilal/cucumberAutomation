package cucumberAutomation;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Liabrary.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ATMTestSteps {

	WebDriver driver;
	String url = "https://secure-qa2.int.capitalone360qa.com/myaccount/banking/login.vm";
	int txtHistorySeq = 0;

	@Given("^I is on QA Home Page$")
	public void i_is_on_QA_Home_Page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^I enter \"([^\"]*)\" I should navigate to summary page$")
	public void i_enter_I_should_navigate_to_summary_page(String CIF) throws Throwable {

		driver.findElement(By.id("ACNID")).sendKeys(CIF);

		driver.findElement(By.id("btn_continue")).click();

		Utility.pinpadContinue(driver);

	}

	@Then("^I Click on the Account link$")
	public void i_Click_on_the_Account_link() throws Throwable {

		driver.findElement(By.partialLinkText("360 Checking - EpsilonJoint360C")).click();
	}

	@Then("^I click on the ATM transaction$")
	public void i_click_on_the_ATM_transaction() throws Throwable {

		WebElement element = Utility.getATMCheckDeposit(driver);
		element.click();
		setTtxtHistorySeq(element.getAttribute("id"));
		Thread.sleep(5000);

	}

	public void setTtxtHistorySeq(String txt) {

		String count = txt.substring(10, txt.length());

		txtHistorySeq = Integer.parseInt(count);
	}

	@Then("^I validate the \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_validate_the(String drawertitle, String amount, String Toaccount) throws Throwable {

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='drawerContent" + txtHistorySeq + "']/div/div[1]/span[1]"))
						.getText().contains(drawertitle));
		Thread.sleep(5000);

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='drawerContent" + txtHistorySeq + "']/div/div[1]/span[2]"))
						.getText().contains(amount));
		Thread.sleep(5000);

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id='drawerContent" + txtHistorySeq + "']/div/div[3]/div[8]"))
						.getText().contains(Toaccount));
		Thread.sleep(5000);
	}

	@Then("^I validate the front and back images of check$")
	public void i_validate_the_front_and_back_images_of_check() throws Throwable {

		WebElement detailElement = driver.findElement(By.id("details" + txtHistorySeq));

		String detailTxt = detailElement.getText();

		boolean errorPresent = detailTxt.contains("Hang on... We're having some difficulties");

		Assert.assertFalse(errorPresent);
	}

	@Then("^I Click on the Print Tranction link$")
	public void i_Click_on_the_Print_Tranction_link() throws Throwable {
		
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Print Transaction")).click();
		
		driver.manage().window().maximize();

		Set<String> wSet = driver.getWindowHandles();

		for (String child : wSet) {

			if (!(child.equals(parent))) {

				driver.switchTo().window(child);
				
				Utility.robotClass(driver, "Print Transaction");
			}
		}
		
	}

	@Then("^I Validate \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
	
	public void i_Validate(String PTtitle, String PTamount, String PTaccount) throws Throwable {
		
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div[5]/div[2]/div/h2")).getText().contains(PTtitle));	
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div[5]/div[2]/div/div[3]")).getText().contains(PTamount));
	
	Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div[5]/div[2]/div/div[6]")).getText().contains(PTaccount));
		
		
	driver.close();	
		
		
		

	}

	
}
