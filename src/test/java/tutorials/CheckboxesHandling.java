package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesHandling {
	
	WebDriver driver;
	
	public CheckboxesHandling (WebDriver driver) {
		this.driver = driver;
	}
  
	public void checkbox1()throws InterruptedException{
		 String parentHandle = driver.getWindowHandle();
		
		 WebElement mouseAction = driver.findElement(By.xpath("(//a[@href='#'])[6]"));
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
		    driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		    driver.switchTo().window(parentHandle);
		    Thread.sleep(3000);
		    
		    driver.findElement(By.id("j_idt87:j_idt89_input")).click();
		    
		    driver.navigate().back();
	}
}
