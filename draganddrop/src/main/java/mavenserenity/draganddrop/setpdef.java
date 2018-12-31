package mavenserenity.draganddrop;

import javax.xml.ws.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;

public class setpdef {
	
	
public String baseUrl = "http://demo.guru99.com/test/drag_drop.html";
	//String driverPath = "C:\\SeleniumGecko.exe";
	public static WebDriver driver;
	
	@Given("^drag_drop$")
	public void drag_drop() throws Throwable {
		
		
	 // Write code here that turns the phrase above into concrete actions
		
		System.setProperty("webdriver.chrome.driver", "C:\\Nouveau_dossier\\chromedriver.exe"); 
		
		
		
	        driver=new ChromeDriver();
	        driver.get(baseUrl);
	        driver.manage().window().maximize();
	        WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
	         
	     	//Element(DEBIT SIDE) on which need to drop.		
	     	WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));					
	      
		//Element(SALES) which need to drag.		
	     	WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));
	        
		//Element(CREDIT SIDE) on which need to drop.  		
	     	WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));					
	     
	     	//Element(500) which need to drag.		
	        WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
	        
	        //Element(DEBIT SIDE) on which need to drop.		
	     	WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));					
	         
		//Element(500) which need to drag.		
	        WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));					
	        
	        //Element(CREDIT SIDE) on which need to drop.		
	     	WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));
	        
	        
	        
	     	Actions act=new Actions(driver);					

	    	//BANK drag and drop.		
	         	act.dragAndDrop(From1, To1).build().perform();
	            
	    	//SALES drag and drop.		
	         	act.dragAndDrop(From2, To2).build().perform();
	            
	    	//500 drag and drop debit side.		
	         	act.dragAndDrop(From3, To3).build().perform();	
	            
	    	//500 drag and drop credit side. 		
	         	act.dragAndDrop(From4, To4).build().perform();		
	          
	    	//Verifying the Perfect! message.		
	        
	        
	         	if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())							
	         	{		
	             	System.out.println("Perfect Displayed !!!");					
	         	}
	    		else
	         	{
	            	System.out.println("Perfect not Displayed !!!");					
	         	}		

	        
	}
	
	
	

}
