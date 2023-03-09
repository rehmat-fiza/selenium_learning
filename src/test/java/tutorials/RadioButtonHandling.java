package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonHandling {
	WebDriver driver;
	 
	public RadioButtonHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void radio()throws InterruptedException{
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
	    driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
	    driver.switchTo().window(parentHandle);
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("(//label[text()='Chrome'])[1]")).click();
	    
	    WebElement unselectable = driver.findElement(By.xpath("//label[text()='Bengaluru']"));
	    unselectable.click();
	    unselectable.click();
	    
	    WebElement radioElement = driver.findElement(By.xpath("(//label[text()='Safari'])[1]"));
	    boolean selectState = radioElement.isDisplayed();
	    		
	    //performing click operation only if element is not selected
	    if(selectState == true) {
	    	System.out.println("Radio button was already selected");
	    }
	    
	    WebElement radioElement2 = driver.findElement(By.xpath("//label[text()='21-40 Years']"));
	    boolean selectState1 = radioElement2.isDisplayed();
	    		
	    //performing click operation only if element is not selected
	    if(selectState1 == true) {
	    	System.out.println("age Radio button was already selected");
	    }
	    
	    driver.navigate().back();
	}

}
