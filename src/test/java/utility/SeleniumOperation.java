package utility;


import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumbermap.ConfigReader;

public class SeleniumOperation
{
	public static ConfigReader config;
	
	public static WebDriver driver=null;
	
	public static Hashtable<String,Object> outputparamerters=new Hashtable<String,Object>();	  	 		 
	
	public static Hashtable<String,Object>  openbrowser(Object[]inputparametrs)
	{
		try {
		String bname=(String) inputparametrs[0];
		if(bname.equalsIgnoreCase("Chrome"))
		{
			config=new ConfigReader();	
		
		System.setProperty("webdriver.chrome.driver",config.getDriverPathChrome());
		  driver = new ChromeDriver();
		 driver.manage().window().maximize();	
		 //driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		 
		}
		else if(bname.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver",config.getDriverPathFF());
			  driver = new FirefoxDriver();
			 driver.manage().window().maximize();
	
		}
		 outputparamerters.put("STATUS","PASS");
		 outputparamerters.put("MESSAGE","methodUsed:openbrowser,input Given: "+inputparametrs[0].toString());
		}
		catch(Exception e)
		{
			outputparamerters.put("STATUS","FAIL");
			 outputparamerters.put("MESSAGE","methodUsed:openbrowser,input Given: "+inputparametrs[0].toString());
			
		}
		return outputparamerters;
	} 

	public static Hashtable<String,Object> openapplication() 
	{
		try {		
		driver.get(config.getApplicationUrl()); 
		//driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		outputparamerters.put("STATUS","PASS");
		outputparamerters.put("MESSAGE","methodUsed:openapplication,input Given: "+config.getApplicationUrl().toString());
		}
		catch(Exception e)
		{
			outputparamerters.put("STATUS","FAIL");
			 outputparamerters.put("MESSAGE","methodUsed:openapplication,input Given: "+config.getApplicationUrl().toString());
		}
		return outputparamerters;
	}
	
	
	public static Hashtable<String,Object> clickonelements(Object[]inputparameters)
	{
		try {
			driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		String input1=(String) inputparameters[0];
		//driver.findElement(By.xpath(input1)).click();
	    outputparamerters.put("STATUS","PASS");
		 outputparamerters.put("MESSAGE","methodUsed:clickonelements,input Given: "+inputparameters[0].toString());
		}
		catch(Exception e)
		{
			outputparamerters.put("STATUS","FAIL");
			 outputparamerters.put("MESSAGE","methodUsed:clickonelements,input Given: "+inputparameters[0].toString());
		}
		return outputparamerters;
	}
	public static Hashtable<String,Object>  mouseOver(Object[]inputparameters)
	{
		try {
		//driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		String Xpath2=(String) inputparameters[0];
		Actions act=new Actions(driver);
		WebElement abc=driver.findElement(By.xpath(Xpath2));
		act.moveToElement(abc).build().perform();
		outputparamerters.put("STATUS","PASS");
		 outputparamerters.put("MESSAGE","methodUsed:mouseOver,input Given: "+inputparameters[0].toString());
		}
		catch(Exception e)
		{
			outputparamerters.put("STATUS","FAIL");
			 outputparamerters.put("MESSAGE","methodUsed:mouseOver,input Given: "+inputparameters[0].toString());
			
		}
		return outputparamerters;
	}
	
	
	public static Hashtable<String,Object>  sendkey(Object[]inputparameters)
	{
		try {
		String Xpath3=(String) inputparameters[0];
	    String value12=(String) inputparameters[1];
	    //driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		driver.findElement(By.xpath(Xpath3)).sendKeys(value12);
		outputparamerters.put("STATUS","PASS");
		 outputparamerters.put("MESSAGE","methodUsed:sendkey,input Given: "+inputparameters[0].toString());
		}
		catch(Exception e)
		{
			outputparamerters.put("STATUS","FAIL");
			 outputparamerters.put("MESSAGE","methodUsed:sendkey,input Given: "+inputparameters[0].toString());
			
		}
		return outputparamerters;
	}
	public static Hashtable<String,Object> validationwithvalid (Object[]inputparameters)
	{
		try   {
		String Xpath4=(String) inputparameters[0];
	    String text=(String) inputparameters[1];
	    //driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
		String actualText=driver.findElement(By.xpath(Xpath4)).getText();
		if(actualText.equalsIgnoreCase(text))
		{
			System.out.println("Test case pass");
		}
		else
		{
			System.out.println("Test case fail");
		}
		outputparamerters.put("STATUS","PASS");
		 outputparamerters.put("MESSAGE","methodUsed:validationwithvalid,input Given: "+inputparameters[0].toString());
		}
		catch(Exception e)
		{
			outputparamerters.put("STATUS","FAIL");
			 outputparamerters.put("MESSAGE","methodUsed:validationwithvalid,input Given: "+inputparameters[0].toString());
			
		}
		return outputparamerters;
	}
		public static Hashtable<String,Object> validationwithinvalid (Object[]inputparameters)
		{
			try {
			String Xpath4=(String) inputparameters[0];
		    String text=(String) inputparameters[1];
		    //driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(),TimeUnit.SECONDS);
			String actualText=driver.findElement(By.xpath(Xpath4)).getText();
			if(actualText.equalsIgnoreCase(text))
			{
				System.out.println("Test case pass");
			}
			else
			{
				System.out.println("Test case fail");
			}
			outputparamerters.put("STATUS","PASS");
			 outputparamerters.put("MESSAGE","methodUsed:validationwithinvalid,input Given: "+inputparameters[0].toString());
			}
			catch(Exception e)
			{
				outputparamerters.put("STATUS","FAIL");
				 outputparamerters.put("MESSAGE","methodUsed:validationwithinvalid,input Given: "+inputparameters[0].toString());
				
			}
			return outputparamerters;
	
	        }
}
			