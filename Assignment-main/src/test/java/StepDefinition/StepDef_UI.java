package StepDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import Pages.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class StepDef_UI {
	public static WebDriver driver;
	public static String NewNum = ""+(int)(Math.random()*Integer.MAX_VALUE);
	public static String EmailAddress = "EmailTest"+NewNum+"@test.io";
	
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver","..\\..\\Assignment-main\\Assignment-main\\chromedriver.exe");
		driver= new ChromeDriver();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("resolution", "1024x768");
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	@Given("^User navigate to facebook web$")
	public void user_navigate_to_facebook_web() throws IOException {
		HomePage hpage = new HomePage(driver);
		hpage.SetUpChrome();
	}
	@When("^Click on Create new account button$")
	public void clickOnCreateNewAccountButton() throws Exception {
		HomePage hpage= new HomePage(driver);
		hpage.CreateNewAccount();
	}

	@And("^User Fill the required fields with valid data$")
	public void user_Fill_the_required_fields_with_valid_data(DataTable dt) throws Exception  {
		HomePage hpage= new HomePage(driver);
		hpage.FillingForm(dt);
	}

	@Then("^the text of enter the code will be displayed$")
	public void theTextOfEnterTheCodeWillBeDisplayed(){
		Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
	}
	
	@After
	public void tearDown() {
    driver.close();
	}



}