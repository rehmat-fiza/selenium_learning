package tutorials;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextFieldHandling {

	WebDriver driver;

	public TextFieldHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void textField()throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		email.sendKeys("sample@gmail.com");
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//1. For erasing data from text filed
		//email.clear();
		
		//2.For erasing data from textfiled
		Actions a = new Actions(driver);
		a.moveToElement(email).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		
		

	    WebElement message = driver.findElement(By.xpath("//textarea[@id='message']"));
	    Thread.sleep(3000);
	    message.sendKeys("No resolution for now...");
	    Thread.sleep(3000);
	    
	    //for erasing data
	    message.clear();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Sample@gmail.com");
	    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("No resolution for now");
	    
		
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		
	}
}
