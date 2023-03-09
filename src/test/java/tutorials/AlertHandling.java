package tutorials;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.IAssert;

public class AlertHandling {
	WebDriver driver;
	
	public AlertHandling(WebDriver driver) {
		this.driver = driver;
	}
 public void alert()throws InterruptedException{
	 
	 String parentHandle = driver.getWindowHandle();
	    
	    WebElement mouseAction = driver.findElement(By.xpath("(//a[@href='#'])[5]"));
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
	    WebElement clickOnAlert = driver.findElement(By.xpath("//span[text()='Alert']"));
	    clickOnAlert.click();
	    driver.switchTo().window(parentHandle);
	    Thread.sleep(3000);
	    
	    //for click on simple alert
	    WebElement alert1 = driver.findElement(By.xpath("(//span[text()='Show'])[1]"));
	    alert1.click();
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	    
	    WebElement simpleAlert = driver.findElement(By.xpath("//span[@id='simple_result']"));
	    boolean verifySimpleAlert = simpleAlert.isDisplayed();
	    if(verifySimpleAlert == true) {
	    	System.out.println("you have succefully clicked on alert");
	    }else {
	    	System.out.println("you have not succefully clicked on alert");
	    }
	    
	    
	    //for confirm dialogue
	    WebElement alert2 = driver.findElement(By.xpath("(//span[text()='Show'])[2]"));
	    alert2.click();
	    Thread.sleep(3000);
	    driver.switchTo().alert().dismiss();
	    
	    WebElement confirmAlert = driver.findElement(By.xpath("//span[text()='User Clicked : Cancel']"));
	    boolean verifyConfirmAlert = confirmAlert.isDisplayed();
	    if(verifyConfirmAlert == true) {
	    	System.out.println("user clicked on cancel");
	    }else {
	    	System.out.println("you click on ok");
	    }
	    
	    
	    //for sweet alert
//	    WebElement alert3 = driver.findElement(By.xpath("(//span[text()='Show'])[3]"));
//	    alert3.click();
//	    Thread.sleep(3000);

	   
//	    WebElement clickOnAlert1 = driver.findElement(By.xpath("//span[text()='Dismiss']"));
//	    clickOnAlert1.click();
	    
	    //For sweet dialogue box
//	    WebElement alert4 = driver.findElement(By.xpath("(//span[text()='Show'])[4]"));
//	    alert4.click();
//	    WebElement element1 = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
//	    JavascriptExecutor js = (JavascriptExecutor)driver;
//	    js.executeScript("arguments[0].click();", element1);
//	    
//	    Thread.sleep(3000);
	    
	    //alert prompt
	    WebElement alert5 = driver.findElement(By.xpath("(//span[text()='Show'])[5]"));
	    alert5.click();
	    Alert alert = driver.switchTo().alert();
	    alert.sendKeys("fizza");
	    alert.accept();
	    Thread.sleep(3000);
	    
	    WebElement promptDialogue = driver.findElement(By.xpath("//span[text()='User entered name as: fizza']"));
	    boolean verifyPromptDialogue = promptDialogue.isDisplayed();
	    if(verifyPromptDialogue == true) {
	    	System.out.println("user entered fizza");
	    }else {
	    	System.out.println("user entered something else");
	    }
	    
	    //delete alert
	    WebElement delete = driver.findElement(By.xpath("//span[text()='Delete']"));
	    delete.click();
	    
	    driver.findElement(By.id("j_idt88:j_idt108")).click();
	    Thread.sleep(3000);
	    
	    driver.navigate().back();
	    
	    
	    
 }
}
