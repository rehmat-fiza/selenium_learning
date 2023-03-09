package tutorials;

//import java.awt.Color;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class ButtonsHandling {
	WebDriver driver;
	
	public ButtonsHandling(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void buttons() throws InterruptedException{
	
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
	    driver.findElement(By.xpath("//span[text()='Button']")).click();
	    driver.switchTo().window(parentHandle);
	    Thread.sleep(3000);
	    
	    
	    WebElement button1 = driver.findElement(By.id("j_idt88:j_idt90"));
	    button1.click();
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
	    WebElement button2 = driver.findElement(By.id("j_idt88:j_idt92"));
	   // button2.isEnabled();
	    boolean verifyButton2 = button2.isEnabled();
	    if(verifyButton2 == true) {
	    	System.out.println("Button is not disabeled");
	    }else {
	    	System.out.println("Button is disabeled");
	    }
	    Thread.sleep(3000);
	    
	    
	    WebElement button3 = driver.findElement(By.id("j_idt88:j_idt92"));
	    //button3.click();
	    System.out.println("Size of button is" +button3.getSize());
	    Thread.sleep(3000);
	    
	    WebElement t = driver.findElement(By.xpath("//span[text()='Save']"));
	   // t.click();
	    String s = t.getCssValue("color");
	      // convert rgba to hex
	      String c = Color.fromString(s).asHex();
	      System.out.println("Color is :" + s);
	      System.out.println("Hex code for color:" + c);
	      Thread.sleep(3000); 
	      
	      WebElement searchBox = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
	        Dimension dim = searchBox.getSize();
	         
	        System.out.println(dim);
	        Thread.sleep(3000);
	        
	        
	        WebElement t1 = driver.findElement(By.xpath("(//span[text()='Success'])[1]"));

	        //WebElement t1 = driver.findElement(By.tagName("h1"));
	        //obtain color in rgba
	        String s1 = t1.getCssValue("color");
	        // convert rgba to hex
	        String c1 = Color.fromString(s).asHex();
	        System.out.println("Color is first time:" + s1);
	        System.out.println("Hex code for color first time :" + c1);
	        
	        
	       WebElement ele = driver.findElement(By.xpath("(//span[text()='Success'])[1]"));

	      //Creating object of an Actions class
	      Actions action = new Actions(driver);

	      //Performing the mouse hover action on the target element.
	      action.moveToElement(ele).perform();
	      
	      String s2 = t1.getCssValue("color");
	        // convert rgba to hex
	        String c2 = Color.fromString(s).asHex();
	        System.out.println("Color is second time:" + s2);
	        System.out.println("Hex code for color second time :" + c2);
	        
	        WebElement button4 = driver.findElement(By.xpath("//span[text()='Image']"));
	        button4.click();
	        
	        driver.navigate().back();
	    
	    
	}

}
