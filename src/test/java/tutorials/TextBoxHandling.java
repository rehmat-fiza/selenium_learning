package tutorials;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextBoxHandling {
	
	WebDriver driver;
	
	public TextBoxHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement()throws InterruptedException{

		
		 String parentHandle = driver.getWindowHandle();
		    
		    WebElement mouseAction = driver.findElement(By.className("pi-server"));
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
		    driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		    driver.switchTo().window(parentHandle);
		    Thread.sleep(3000);
		    
		  //for entering the Name
		   WebElement name =  driver.findElement(By.id("j_idt88:name"));
		   name.sendKeys("Rehmat");
		   Thread.sleep(3000);
		   
		   //for append the text
		   WebElement appendText =  driver.findElement(By.id("j_idt88:j_idt91"));
		 
		   //appendText.sendKeys(Keys.HOME,", India");
		   appendText.sendKeys(", India");
		   Thread.sleep(3000);
		   
		   //verify element is disabled
		   boolean textField = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
		   if(textField){
			   System.out.println("Element is not disabled");
		   }else {
			   System.out.println("Element is disabled");
		   }
		   Thread.sleep(3000);
		   
		   //for clearing the typed text
		   WebElement clearText = driver.findElement(By.id("j_idt88:j_idt95"));
		   clearText.clear();
		   Thread.sleep(3000);
		   
		   //for retrieving the text
		   WebElement retrieveText = driver.findElement(By.id("j_idt88:j_idt97"));
		   System.out.println(retrieveText.getText());
//		   retrieveText.getText();
//		   System.out.println(retrieveText);
//		   
		   
		   //for entering the email and press tab
		   WebElement enterEmail = driver.findElement(By.id("j_idt88:j_idt99"));
		   enterEmail.sendKeys("sample@yopmail.com");
		   String press = Keys.chord(Keys.TAB);
		   enterEmail.sendKeys(press);
		   
		   //enter text 
		   WebElement text = driver.findElement(By.id("j_idt88:j_idt101"));
		   text.sendKeys("Hi...This is rehmat here");
		   
		   //press enter and found error 
		   WebElement pressEnter = driver.findElement(By.id("j_idt106:thisform:age"));
		   String press1 = Keys.chord(Keys.ENTER);
		   pressEnter.sendKeys(press1);
		   Thread.sleep(3000);
		   
		   //Back to home page 
		  // driver.navigate().back();
		   
		   //for verifying lable position
		   WebElement labelPos = driver.findElement(By.xpath("//input[@id='j_idt106:float-input']"));
		   labelPos.click();
		   Point p = labelPos.getLocation();
		   System.out.println("x-chord " +p.x+"  "+p.getX());
		   System.out.println("x-chord " +p.y+"  "+p.getY());
		   
		   //type name and choose third option 
//		   WebElement enterName = driver.findElement(By.id("j_idt106:auto-complete_input"));
//		   enterName.sendKeys("rehmat01");
		   
		   
//		  enterName.sendKeys(Keys.ARROW_DOWN);
//		  enterName.sendKeys(Keys.ARROW_DOWN);
//		  enterName.sendKeys(Keys.ARROW_DOWN);
//		  enterName.sendKeys(Keys.ENTER);
//		  enterName.click();
		   
//		   List<WebElement> elements = driver.findElements(By.id("j_idt106:auto-complete_panel"));
//		   System.out.println(elements.size());
//		   for(WebElement b : elements) {
//			   String element = b.getText();
//			   System.out.println(element);
//			   if(element.equalsIgnoreCase("rehmat012")) {
//				   b.click();
//				   break;
//			   }
//		   }
		  
		   
		  
		  //for picking the date from the calendar
		  WebElement datePicker = driver.findElement(By.id("j_idt106:j_idt116_input"));
		  datePicker.sendKeys("01/01/2000");
		  WebElement clickOnCal = driver.findElement(By.xpath("//a[text()='26']"));
		  clickOnCal.click();
		  
		  //spin the number
		  WebElement enterNum = driver.findElement(By.id("j_idt106:j_idt118_input"));
		  enterNum.sendKeys("30");
		  
		  //for arrow up
		  WebElement arrowUp = driver.findElement(By.className("ui-icon-triangle-1-n"));
		  arrowUp.click();
		  WebElement arrowDown = driver.findElement(By.className("ui-spinner-down"));
		  arrowDown.click();
		  
		  //for checking slider functionality
		  WebElement EnterNumber = driver.findElement(By.id("j_idt106:slider"));
		  EnterNumber.sendKeys("50");
		  
//		  WebElement slider = driver.findElement(By.className("ui-slider-handle"));
//		  int xwidth = slider.getSize().width;
		  
		  
		
		  
//		  Actions actions = new Actions(driver);
//		  actions.dragAndDropBy(slider, 0, xwidth*50);
//		  
//		  actions.build().perform();
		  
		  JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,500)");
		  
		  //for confirming keyboard is visible
		  WebElement click = driver.findElement(By.id("j_idt106:j_idt122"));
		  click.click();
		  
		  WebElement keyboardPopup = driver.findElement(By.cssSelector("div[class*='keypad-popup']"));
		  boolean verifyKeyboard = keyboardPopup.isDisplayed();
	        if(verifyKeyboard == true) {
	        	System.out.println("Keyboard  is displaying ");
	        }
	        
	        driver.navigate().back();
		   
	}

}
