package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling {
	WebDriver driver;
	
	public DropdownHandling(WebDriver driver) {
		this.driver=driver;
	}
	
	public void dropdown()throws InterruptedException{
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
		    driver.findElement(By.xpath("//span[text()='Dropdown']")).click();
		    driver.switchTo().window(parentHandle);
		    Thread.sleep(3000);
		    
		    Select automationTool = new Select(driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")));
		    automationTool.selectByVisibleText("Selenium");
		    
		    Select country = new Select(driver.findElement(By.id("j_idt87:country_label")));
		    country.selectByVisibleText("Brazil");
		    
//		    Select automationTool = new Select(driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")));
//		    automationTool.selectByVisibleText("Brazil");
		    
		    driver.navigate().back();
//		
	}

}
