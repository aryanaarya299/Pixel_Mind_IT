package com.pixelmind.signup;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.Test;

public class VerifySingnUpPage {
	
	
	@Test
  public void validate_signup_page () throws InterruptedException {
		
		
		Logger logger = Logger.getLogger("VerifySingnUpPage");
		PropertyConfigurator.configure("Log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", "../PixelMindIT_Task/SeleniumDrivers/chromedriver.exe");
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.developer-connector-mern.com/");
		//puts an implicit wait for 10 seconds before throwing exceptions     	 
      	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
      	//Click on Sign Up button
		driver.findElement(By.xpath("//a[@id='landing__btn-sign-up']")).click();
		
		//Verify pageTitle
		String actualTitle = driver.getTitle();
		String expectedTitle  = "DevConnector: Social Network for Developers";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			logger.info("Title Matched");
			else
				logger.info("Title didn't match");
		
		//Verify Sign Up label
				 String header_SignUp = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
				 String expectedHeader = "Sign Up";
				 if(expectedHeader.equalsIgnoreCase(header_SignUp) ) {
					 logger.info("Headers label matches as expected");
				 }else {
					 logger.info("Headers label matches not expected");	
				 }
	    // Verify Create your DevConnector account label
				 String createdevheader = driver.findElement(By.xpath("//p[@class='lead text-center']")).getText();
				 String expecteddevheader = "Create your DevConnector account";
				 if(expecteddevheader.equalsIgnoreCase(createdevheader)) {
					 logger.info("Headers matches as expected");
				 }else {
					 logger.info("Headers matches not expected");		 
				 }
				 
		// Verify text box Count
		List<WebElement> totalTextboxes = driver.findElements(By.xpath("//div[@class='bg-light form-generic__container']//div"));	
		int actualInt = totalTextboxes.size();
		int expectedInt = 4;
		if (expectedInt==actualInt) {
			logger.info("Count of text box matches as expected");
		}else {
			logger.info("Count of text box matches not expected");
		}
		
	  //Verify name text field 
		
		              WebElement fillName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		               fillName.sendKeys("AnasA");
		               String fillNameVal = fillName.getAttribute("value");
		               if(fillNameVal.contentEquals("AnasA")){
		               logger.info("Fill Name");
		               }
		               else{
		               logger.info("Not Fill Name" + fillNameVal);
		               }
	 //locate the email field
		               WebElement fillEmail = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		               fillEmail.sendKeys("anas199@gmail.com");
		               String fillEmailVal = fillEmail.getAttribute("value");
		               if(fillEmailVal.contentEquals("anas199@gmail.com")){
		               logger.info("Fill Email Address");
		               }
		               else{
		               logger.info("Not Fill Email Address" + fillEmailVal);
		               }
  //set the password's value
		               WebElement PutPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		               PutPassword.sendKeys("Xyz#12345");
		               String PutPwrd = PutPassword.getAttribute("value");
		               if(PutPwrd.contentEquals("Xyz#12345")){
		               logger.info("Fill Password");
		               }
		               else{
		               logger.info("Not Fill Password" + PutPwrd);
		               }  
  //Verify confirm password
		               
		               WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@placeholder='Verify password']"));
		               ConfirmPassword.sendKeys("Xyz#12345");
		               String PutConfirmPwrd = ConfirmPassword.getAttribute("value");
		               if(PutConfirmPwrd.contentEquals("Xyz#12345")){
		               logger.info("Fill confirm Password");
		               }
		               else{
		               logger.info("Not Fill confirm Password" + PutConfirmPwrd);
		               }    
   //locate and click the submit button
		               driver.findElement(By.xpath("//input[@type='submit']")).click();
		               
		             //puts an implicit wait for 10 seconds before throwing exceptions   
		             	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		               String url = driver.getCurrentUrl();
		               String expectedUrl ="https://www.developer-connector-mern.com/login";
		               if(url.equals(expectedUrl)) {
		            	   logger.info("Successfully signed up the user");
		               }
		               else {
		            	   logger.info("User enter information is not correct");
		               }
		               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Verify Login page

		       		//Verify Log In label
		       				 String header_Log_In = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
		       				 String expectedLog_inHeader = "Log In";
		       				 if(expectedLog_inHeader.equalsIgnoreCase(header_Log_In) ) {
		       					 logger.info("Headers label matches as expected");
		       				 }else {
		       					 logger.info("Headers label matches not expected");	
		       				 }
		       	// Verify Sign in to your DevConnector account label
		    				 String Sign_indevheader = driver.findElement(By.xpath("//p[@class='lead text-center']")).getText();
		    				 String expectedSign_indevheader = "Create your DevConnector account";
		    				 if(expectedSign_indevheader.equalsIgnoreCase(Sign_indevheader)) {
		    					 logger.info("Headers matches as expected");
		    				 }else {
		    					 logger.info("Headers matches not expected");	
		    					 
		    					 
		    				 }
		    				 Thread.sleep(6000);
		               
								/* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */

		   //locate the email field
				               WebElement Login_Email = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
				               Login_Email.sendKeys("anas199@gmail.com");
				               String LoginEmailVal = Login_Email.getAttribute("value");
				               if(LoginEmailVal.contentEquals("anas199@gmail.com")){
				               logger.info("Fill Email Address");
				               }
				               else{
				               logger.info("Not Fill Email Address" + LoginEmailVal);
				               }
	 //set the password's value
				               WebElement LoginPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
				               
				               LoginPassword.sendKeys("Xyz#12345");
				               String LoginPwrd = LoginPassword.getAttribute("value");
				               if(LoginPwrd.contentEquals("Xyz#12345")){
				               logger.info("Fill Password");
				               }
				               else{
				               logger.info("Not Fill Password" + LoginPwrd);
				               } 
				               
								//locate and click the submit button //
								  driver.findElement(By.xpath("//input[@class='btn btn-info btn-block mt-4']")).click(); 
								  
		// wait 6 Second
								  Thread.sleep(6000);
								  
								  
		//Verify Logout Button
								  driver.findElement(By.xpath("//a[@id='navbar__logout-li']")).click();
								  String Url = driver.getCurrentUrl();
					               String expectedlogoutUrl ="https://www.developer-connector-mern.com/login";
					               if(Url.equals(expectedlogoutUrl)) {
					            	   logger.info("Successfully Logout the user");
					               }
					               else {
					            	   logger.info("User can't able to Logout");
					               }
								  
		
	}

}
