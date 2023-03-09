package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GridHandling {
	WebDriver driver;
	
	public GridHandling(WebDriver driver) {
		this.driver=driver;
	}
	
	public void grid()throws InterruptedException{
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
		    driver.findElement(By.xpath("//span[text()='Grid']")).click();
		    driver.switchTo().window(parentHandle);
		    Thread.sleep(3000);
		    
		    WebElement selectCheckbox = driver.findElement(By.id("form:dt-products_head_checkbox"));
		    selectCheckbox.click();
		    Thread.sleep(3000);
		    
		    WebElement clickOnSelectedPro= driver.findElement(By.xpath("//span[text()='5 products selected']"));
		    clickOnSelectedPro.click();
		    
		    driver.findElement(By.id("form:j_idt160")).click();
		    
		    driver.navigate().back();
		    
		    
		    
	}

}
