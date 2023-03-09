package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagesHandling {
	
	WebDriver driver;
	
	public MessagesHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void messages()throws InterruptedException{
	 String parentHandle = driver.getWindowHandle();
	    
	    WebElement mouseAction = driver.findElement(By.xpath("(//a[@href='#'])[9]"));
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
	    driver.findElement(By.xpath("//span[text()='Message']")).click();
	    driver.switchTo().window(parentHandle);
	    Thread.sleep(3000);
	    
	    WebElement info = driver.findElement(By.xpath("(//span[text()='Info'])[1]"));
	    info.click();
	    
	    WebElement infoMessage = driver.findElement(By.xpath("//li[@role='alert']"));
	    boolean verifyInfoMsg = infoMessage.isDisplayed();
	    if(verifyInfoMsg == true) {
	    	System.out.println("info message is showing ");
	    }else {
	    	System.out.println("info message is not showing ");
	    }
	    Thread.sleep(3000);
	    
	    WebElement warn = driver.findElement(By.xpath("(//span[text()='Warn'])[1]"));
	    warn.click();
	    WebElement warnMessage = driver.findElement(By.xpath("//li[@role='alert']"));
	    boolean verifyWarnMsg = warnMessage.isDisplayed();
	    if(verifyWarnMsg == true) {
	    	System.out.println("warn message is showing ");
	    }else {
	    	System.out.println("warn message is not showing ");
	    }
	    Thread.sleep(3000);
	    WebElement error = driver.findElement(By.xpath("(//span[text()='Error'])[1]"));
	    error.click();
	    WebElement errorMessage = driver.findElement(By.xpath("//li[@role='alert']"));
	    boolean verifyErrorMsg = errorMessage.isDisplayed();
	    if(verifyErrorMsg == true) {
	    	System.out.println("warn message is showing ");
	    }else {
	    	System.out.println("warn message is not showing ");
	    }
	    
	    Thread.sleep(3000);
	    WebElement firstName = driver.findElement(By.xpath("//input[@id='j_idt100:firstname']"));
	    firstName.sendKeys("rehmat");
	    Thread.sleep(1000);

	    WebElement lastName = driver.findElement(By.xpath("//input[@id='j_idt100:lastname']"));
	    lastName.sendKeys("fiza");
	    Thread.sleep(1000);
	    

	    WebElement email = driver.findElement(By.xpath("//input[@id='j_idt100:email']"));
	    email.sendKeys("sample@gmail.com");
        Thread.sleep(1000);
        
        
	    WebElement inlineSubmit = driver.findElement(By.xpath("//span[text()='Submit']"));
	    inlineSubmit.click();
	    
	    
	    driver.navigate().back();
	    
	    
	    
	    
	}
}
