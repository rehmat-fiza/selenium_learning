package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileHandling {
	
	WebDriver driver;
	
	public FileHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void file() throws InterruptedException{
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
	    driver.findElement(By.xpath("//span[text()='File']")).click();
	    driver.switchTo().window(parentHandle);
	    Thread.sleep(3000);
	    
	    WebElement fileUpload = driver.findElement(By.id("j_idt88:j_idt89_input"));
	    fileUpload.sendKeys("C:\\Users\\rehma\\Pictures\\Screenshots\\screenshot.png");
	    Thread.sleep(3000);
	    
	    WebElement fileDownload = driver.findElement(By.xpath("//span[text()='Download']"));
	    fileDownload.click();
	    Thread.sleep(3000);
	    
//	    WebElement onlyPictures = driver.findElement(By.id("j_idt97:j_idt98_label"));
//	    onlyPictures.sendKeys("C:\\Users\\rehma\\Pictures\\Screenshots\\screenshot.png");
	}

}
