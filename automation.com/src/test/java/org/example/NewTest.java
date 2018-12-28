package org.example;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	
	public String baseUrl = "https://www.salesforce.com/fr/";
	public static WebDriver driver;
	
	
	

  @BeforeMethod
  public void beforeMethod() {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Nouveau_dossier\\chromedriver.exe"); 
		//	driver=new FirefoxDriver();
		driver=new ChromeDriver();

  }
  
  @Test(priority=2)
  public void f() {
	

	 System.out.println("Test OK");
	  
  }
  
  
  @Test(priority=1)
  public void f2() {
	

	     driver.get(baseUrl);
	      driver.manage().window().maximize();
	  
  }
  
  
  

}
