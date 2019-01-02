package serenety.automation.com;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class stepdef {
	
public String baseUrl = "https://www.salesforce.com/fr/";
	//String driverPath = "C:\\SeleniumGecko.exe";
	public static WebDriver driver;
	
	
	
	@Given("^I want to connect to  sales force application$")
	public void i_want_to_connect_to_my_sales_force_account() throws Throwable {
		
		
	 // Write code here that turns the phrase above into concrete actions
		
		System.setProperty("webdriver.chrome.driver", "C:\\Nouveau_dossier\\chromedriver.exe"); 
			//driver=new FirefoxDriver();
	        driver=new ChromeDriver();
	        driver.get(baseUrl);
	        driver.manage().window().maximize();
	        
	}

	/*@Given("^some other precondition$")
	public void some_other_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}*/

	@When("^I click on contact link$")
	public void I_click_on_contact_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[contains(text(),'Nous contacter')]")).click();

	}

	@When("^I enter my name$")
public void I_enter_my_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  driver.findElement(By.id("UserFirstName")).sendKeys("wadii");
	  
	}

	@When("^I enter Contact formulaire$")
	
	public void I_enter_Contact_formulaire() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("UserLastName")).sendKeys("hannachi");
	    driver.findElement(By.id("UserTitle")).sendKeys("testeur");
        driver.findElement(By.id("UserEmail")).sendKeys("hannachi_wadia@yahoo.fr");
        driver.findElement(By.id("UserPhone")).sendKeys("+21626884721");
        driver.findElement(By.id("CompanyName")).sendKeys("Talan");
        String time=driver.findElement(By.id("CompanyName")).getAttribute("value");
        System.out.println(time);
        TakesScreenshot ts2=(TakesScreenshot)driver;
        File   source2=ts2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source2,new File("./screenshots/test2.png"));
        System.out.println("screenshot taken");
        driver.findElement(By.className("selectBox-label")).click();
        driver.findElement(By.xpath("/html/body/ul[1]/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form-container\"]/ul/li[8]/div/div[2]/a/span[1]")).click();
       ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        boolean  check=driver.findElement(By.className("selectBox-label")).isSelected();
        System.out.println(check);
        TakesScreenshot ts=(TakesScreenshot)driver;
        File   source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File("./screenshots/test.png"));
        System.out.println("screenshot taken");
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();

 //check screenshot    
   if (check==true)
  System.out.println("Test ok");
   
          else 
         System.out.println("Test KO");
        
 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
 
 
	}
	
	@When("^I navigate Second Page$")
	
	public void I_navigate_Second_Page() throws Throwable 
	{

 driver.findElement(By.xpath("//*[@id=\"form-container\"]/div[2]/div/a")).click();
 
 String expectedtest="Nous vous remercions pour votre intérêt";
  String  actualtext= driver.findElement(By.xpath("//*[@id=\"nous-vous-remercions-pour-votre-interet\"]/a/span")).getText();
 
  
System.out.println(expectedtest);
//System.out.println("x");

if (expectedtest.contentEquals(actualtext))
	
	
	
//-----------------------------------------------------
	
	System.out.println("-----------------------Test OK-----------------------------------------");

else 
	
	System.out.println("-----------------------Test KO-----------------------------------------");
	
	
driver.findElement(By.linkText("gamme de produits salesforce.com")).click();


driver.findElement(By.linkText("Ventes")).click();

driver.findElement(By.linkText("VOIR LA DÉMO")).click();

 
//  driver.quit();
}

	@Then("^I validate the outcomes$")

	public void i_validate_the_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^check more outcomes$")
	
	public void check_more_outcomes() throws Throwable {
		

	   
	}
}