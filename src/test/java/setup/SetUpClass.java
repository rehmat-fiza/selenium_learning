package setup;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import tutorials.AlertHandling;
import tutorials.ButtonsHandling;
import tutorials.CalendarHandling;
import tutorials.CheckBoxHandling;
import tutorials.CheckboxesHandling;
import tutorials.DropdownHandling;
import tutorials.FileHandling;
import tutorials.GridHandling;
import tutorials.HyperlinkHandling;
import tutorials.MessagesHandling;
import tutorials.RadioButtonHandling;
import tutorials.TableHandling;
import tutorials.TextBoxHandling;
import tutorials.TextFieldHandling;



public class SetUpClass {
	WebDriver driver;
	CheckBoxHandling objectrepo;
	TextFieldHandling objectrepo1;
	TextBoxHandling objectrepo2;
	AlertHandling objectrepo3;
	ButtonsHandling objectrepo5;
	DropdownHandling objectrepo6;
	CheckboxesHandling objectrepo7;
	RadioButtonHandling objectrepo8;
	MessagesHandling objectrepo9;
	FileHandling objectrepo10;
	TableHandling objectrepo11;
	GridHandling objectrepo12;
	CalendarHandling objectrepo13;
	HyperlinkHandling objectrepo14;
	
	@BeforeTest
	public void setup()throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://leafground.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
//	@Test
//	public void verifyCheckbox()throws InterruptedException{
//		objectrepo = new CheckBoxHandling(driver);
//		objectrepo.checkBox();
//	}
	


////	@Test
////	public void verifyTextField()throws InterruptedException{
////		objectrepo1 = new TextFieldHandling(driver);
////		objectrepo1.textField();
////	}
	
	@Test(priority=2)
	public void verifyMouseHover()throws InterruptedException{
		objectrepo2 = new TextBoxHandling(driver);
		objectrepo2.clickOnElement();
	}
	
	@Test(priority=1)
	public void verifyAlert()throws InterruptedException{
		objectrepo3 = new AlertHandling(driver);
		objectrepo3.alert();
	}
	
	
//	@Test
//	public void verifyIframe() throws InterruptedException{
//		objectrepo4 = new IframeHandling(driver);
//		objectrepo4.iframe();
//	}
	
	@Test(priority=3)
	public void verifyButtons()throws InterruptedException{
		objectrepo5 = new ButtonsHandling(driver);
		objectrepo5.buttons();
				
	}
	
	
	@Test(priority=4)
	public void verifyDropdown() throws InterruptedException{
		objectrepo6 = new DropdownHandling(driver);
		objectrepo6.dropdown();
	}
	
	
	@Test(priority=5)
	public void verifyCheckboxes()throws InterruptedException{
		objectrepo7 = new CheckboxesHandling(driver);
		objectrepo7.checkbox1();
	}
	
	@Test(priority=6)
	public void verifyRadioButton()throws InterruptedException{
		objectrepo8 = new RadioButtonHandling(driver);
		objectrepo8.radio();
	}
	
	@Test(priority=11)
	public void verifyMessages()throws InterruptedException{
		objectrepo9 = new MessagesHandling(driver);
		objectrepo9.messages();
	}
	
	@Test(priority=12)
	public void verifyFile()throws InterruptedException{
		objectrepo10 = new FileHandling(driver);
		objectrepo10.file();
	}
	
	
	@Test(priority=8)
	public void verifyTable()throws InterruptedException{
		objectrepo11 = new TableHandling(driver);
		objectrepo11.table();
	}
	
	
	@Test(priority=9)
	public void verifyGrid()throws InterruptedException{
		objectrepo12 = new GridHandling(driver);
		objectrepo12.grid();
	}
	
	@Test(priority=10)
	public void verifyCalendar()throws InterruptedException{
		objectrepo13 = new CalendarHandling(driver);
		objectrepo13.calendar();
	}
	
	@Test(priority = 7)
	public void verifyHyperlink()throws InterruptedException{
		objectrepo14 = new HyperlinkHandling(driver);
		objectrepo14.hyperlink();
	}
	
	
	
	@AfterTest
	public void afterTest() {
		   driver.quit();
	   }


	
}
