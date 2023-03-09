package tutorials;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxHandling {
	
	WebDriver driver;

	public CheckBoxHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkBox() {
		//driver.findElement(By.xpath("//input[@id='j_idt107_input']")).click();
		//driver.findElement(By.className("ui-state-hover")).click();
		//driver.findElement(By.cssSelector(".ui-chkbox-box.ui-widget.ui-corner-all.ui-state-default.ui-state-hover")).click();
		
		List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i =0; i<checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
	}
}
