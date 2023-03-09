package tutorials;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HyperlinkHandling {
	
	WebDriver driver;
	
	public HyperlinkHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void hyperlink()throws InterruptedException{
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
		    driver.findElement(By.xpath("//span[text()='Hyper Link']")).click();
		    driver.switchTo().window(parentHandle);
		    Thread.sleep(3000);
		    
		    WebElement hyperlink1 = driver.findElement(By.xpath("(//a[text()=\"Go to Dashboard\"])[1]"));
		    hyperlink1.click();
		    Thread.sleep(3000);
		    
		    String expectedTitle = "Dashboard";
		    String actualTitle = driver.getTitle();
		    if(actualTitle.equalsIgnoreCase(expectedTitle)) {
				System.out.println("Title Matched");
		    }else
		    
		    {
				System.out.println("Title didn't match");
		    }
		    driver.navigate().back();
		    
		    WebElement hyperlink2 = driver.findElement(By.xpath("//a[text()=\"Find the URL without clicking me.\"]"));
		    hyperlink2.click();
		    
		    WebElement checkboxes = driver.findElement(By.id("form:dt-products_head_checkbox"));
		    checkboxes.click();
		    
		    WebElement deleteProduct = driver.findElement(By.xpath("//span[text()=\"5 products selected\"]"));
		    deleteProduct.click();
		    
		    driver.findElement(By.xpath("(//span[text()=\"No\"])[2]")).click();
		    //driver.switchTo().alert().dismiss();
		    driver.navigate().back();
		    Thread.sleep(3000);
		    
		    WebElement hyperlink3 = driver.findElement(By.xpath("//a[text()=\"Find the URL without clicking me.\"]"));
		    hyperlink3.click();
		    
		    String expectedBrokenTitle = "Error 404 /lists.xhtml Not Found in ExternalContext as a Resource";
		    String actualBrokenTitle = driver.getTitle();
		    if(actualBrokenTitle.equalsIgnoreCase(expectedBrokenTitle)) {
				System.out.println("Title Matched");
		    }else
		    
		    {
				System.out.println("Title didn't match");
		    }
		    driver.navigate().back();
		    
		    driver.navigate().back();
		    
		   // driver.close();
		    
		    
		    
	}

}
