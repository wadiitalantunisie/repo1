package mavenserenity.draganddrop;

import javax.xml.ws.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

		
	
	
		
import  java.sql.SQLException;


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
	     System.out.println("----------------------------------Test Of Data dispalyed by cvs File -------------------");
	         	
	         	//load csv file 
	         	CSVReader reader = new CSVReader(new FileReader("C:\\Nouveau_dossier\\demo.csv"));
	         	 
	         	//create new list (input reader)
	         	  List<String[]> li=reader.readAll();
	         	  
	         	  //display size of list
	         	  System.out.println("Total rows which we have is "+li.size());
	         	            
	         	//create new iterator 
	         	  Iterator<String[]>i1= li.iterator();
	         	    
	         	 
	         	 while(i1.hasNext()){
	         	     
	         	 String[] str=i1.next();
	         	 
	         	 
	         	 //display the value of each row
	         	   
	         	 System.out.print(" Values are ");
	         	 
	         	 for(int i=0;i<str.length;i++)
	         	{
	         	 
	         	   System.out.print(" "+str[i]);
	         	 
	         	}
	         	   System.out.println("   ");
	         	     
	         	    
	         	}	
	         	 
}
	
	
	@Given("^Tool_Tip$")
	public void Tool_Tip() throws Throwable {
		
		
		
	  	 
        baseUrl = "http://demo.guru99.com/test/social-icon.html";					
 				
        	    				
        driver.get(baseUrl);					
         String expectedTooltip = "Github";	
        	    
        	    // Find the Github icon at the top right of the header		
        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));	
        	    
        
        	    //get the value of the "title" attribute of the github icon		
         String actualTooltip = github.getAttribute("title");	
        System.out.println(actualTooltip);
         
         
        	    //Assert the tooltip's value is as expected 		
        	    System.out.println("Actual Title of Tool Tip"+actualTooltip);							
        	    if(actualTooltip.equals(expectedTooltip)) {							
        	        System.out.println("Test Case Passed");					
        	    }		
        	    else 
        	    	System.out.println("Test Failed");	
        	    driver.get("http://demo.guru99.com/test/table.html");
            	//To locate table.
            	WebElement mytable =driver.findElement(By.xpath("/html/body/table/tbody"));
            	//To locate rows of table. 
            	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
            	//To calculate no of rows In table.
            	int rows_count = rows_table.size();
            	//Loop will execute till the last row of table.
            	for (int row = 0; row < rows_count; row++) {
            	    //To locate columns(cells) of that specific row.
            	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            	    //To calculate no of columns (cells). In that specific row.
            	    int columns_count = Columns_row.size();
            	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
            	    //Loop will execute till the last cell of that specific row.
            	    for (int column = 0; column < columns_count; column++) {
            	        // To retrieve text from that specific cell.
            	        String celtext = Columns_row.get(column).getText();
            	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
            	    }
            	    System.out.println("-------------------------------------------------- ");
            	}

          /*  	String dbUrl = "jdbc:mysql://localhost:3036//testselenuim";

				//Database Username		
				String username ="root";	
                
				//Database Password		
				String password ="";				

				//Query to Execute		
				String query = "select *  from test";
                //Load mysql jdbc driver		
           	    Class.forName("com.mysql.jdbc.Driver");			
           
           		//Create Connection to DB		
            	Connection con = DriverManager.getConnection(dbUrl,username,"");
          
          		//Create Statement Object		
        	   Statement stmt = con.createStatement();					
       
       			// Execute the SQL Query. Store results in ResultSet		
         		ResultSet rs= stmt.executeQuery(query);							
         
         		// While Loop to iterate through all data and print results		
         			while (rs.next()){
	        		String myName = rs.getString(1);								        
                    String myAge = rs.getString(2);					                               
                    System. out.println(myName+"  "+myAge);		
            }
         			
			 // closing DB Connection		
		con.close();	
			
      	    
        	*/    
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
          /*
            	String username = ""; 
            	String password = "";
            	driver.navigate().to("https://www.flipkart.com");
            	driver.findElement(By.partialLinkText("Login")).click();
            	
            	
            	/*
            		driver.findElement(
            				By.cssSelector(".fk-input.login-form-input.user-email"))
            				.sendKeys(username);
            		driver.findElement(
            				By.cssSelector(".fk-input.login-form-input.user-pwd"))
            				.sendKeys(password);
            		driver.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click();
       
            		driver.findElement(By.id("fk-top-search-box")).sendKeys("moto g3");
            		driver.findElement(
            				By.cssSelector("search-bar-submit.fk-font-13.fk-font-bold"))
            				.click();

            		// select the first item in the search results
            		String css = ".gd-row.browse-grid-row:nth-of-type(1) > div:nth-child(1)>div>div:nth-child(2)>div>a";
            		driver.findElement(By.cssSelector(css)).click();
    
            		driver.findElement(
            				By.cssSelector(".btn-express-checkout.btn-big.current"))
            				.click();
            		driver.findElement(By.cssSelector(".remove.fk-inline-block")).click();
            		Alert a = driver.switchTo().alert();
            		a.accept();
            
            		Actions s = new Actions(driver);
            		WebElement user = driver.findElement(By.partialLinkText(username));
            		s.moveToElement(user).build().perform();
            		driver.findElement(By.linkText("Logout")).click();
      
            	
            	*/
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
}
	}
