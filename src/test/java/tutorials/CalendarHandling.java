package tutorials;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarHandling {
	WebDriver driver;
	
	public CalendarHandling(WebDriver driver){
		this.driver=driver;
	}
	
	public void calendar()throws InterruptedException{
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
	    driver.findElement(By.xpath("//span[text()='Calendar']")).click();
	    driver.switchTo().window(parentHandle);
	    Thread.sleep(3000);
	    
	    new WebDriverWait(driver, Duration.ofSeconds(5))
	    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("fc-scrollgrid-sync-table")));
	    
	    selectDate("1", "November", "2023");
	}
	
   public static String[] getMonthYear(String monthYearVal) {
	   return monthYearVal.split(" ");

   } 
   
   public  void selectDate(String exDay, String exMonth, String exYear) {
	    String monthYearVal = driver.findElement(By.className("fc-toolbar-title")).getText();
	    System.out.println(monthYearVal);
	    
	    
	    
	    while(!(getMonthYear(monthYearVal)[0].equals(exMonth)
	    		&& getMonthYear(monthYearVal)[1].equals(exYear))) {
	    	driver.findElement(By.className("fc-next-button")).click();
	    	
	    	
	    	monthYearVal = driver.findElement(By.className("fc-toolbar-title")).getText();
		   
	    }
	    
	    driver.findElement(By.xpath("(//a[text()='"+exDay+"'])[1]")).click();
	    
	    driver.navigate().back();
		
	}

}
