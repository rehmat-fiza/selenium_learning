package tutorials;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TableHandling {
	WebDriver driver;
	
	public TableHandling(WebDriver driver) {
		this.driver = driver;
	}
  
	public void table()throws InterruptedException{
      String parentHandle = driver.getWindowHandle();
	    
	    WebElement mouseAction = driver.findElement(By.xpath("(//a[@href='#'])[7]"));
	    mouseAction.click();
	    Thread.sleep(3000);
	   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Set<String> handles = driver.getWindowHandles();
	    for(String handle : handles) {
	    	System.out.println(handle);
	    	if(!handle.equals(parentHandle)) {
	    		driver.switchTo().window(handle);
	    		Thread.sleep(3000);
	    //		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    		driver.close();
	    		
	    	}
	    	
	    	
	    }
	    driver.findElement(By.xpath("(//span[text()='Table'])[2]")).click();
	    driver.switchTo().window(parentHandle);
	    Thread.sleep(3000);
	    
	    
	    //for the first column 
	    List<WebElement> allHeaders = driver.findElements(By.xpath("//tbody[@id='form:j_idt89_data']//td[1]"));
	    System.out.println(allHeaders.size());
	    
	    Assert.assertEquals(allHeaders.size(), 10, "column count not matched");
	    
	   
	    
	    for(WebElement ele:allHeaders) {
	    	String value = ele.getText();
	    	System.out.println(value);
	    	
	    	
	    }
	  
	    
	    //for the rows
	    List<WebElement> numberOfRows = driver.findElements(By.xpath("//tbody[@id='form:j_idt89_data']//tr"));
	    System.out.println("Total Number of rows:" +numberOfRows.size());
	    
	    for(WebElement ele1: numberOfRows) {
	    	String value1 = ele1.getText();
	    	System.out.println(value1);
	    	
	    	
	    }
	    
	    Assert.assertEquals(numberOfRows.size(), 10, "rows count not matched" );
	    
	    driver.navigate().back();
	}
}
