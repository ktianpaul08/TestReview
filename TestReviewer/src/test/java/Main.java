

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main extends TestBase{

	Locators locators = new Locators();
	
	
	@BeforeSuite
	public void DriverSetup() {
		WebDriver driver = super.setDriver("Edge");
	}
	
	@BeforeTest
	public void setUrl() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
//		String sheetName = "Sheet Name";
//		String testCase = "TestCase-Rowname";
//		test = excelUtil.getData(sheetName, testCase);		
	}
	
	@Test
	public void Testing()
	{
		WebElement email = driver.findElement(By.xpath(locators.email));
		WebElement login = driver.findElement(By.xpath(locators.login));
//		email.sendKeys("Paul");

//		js.executeScript("arguments[0].value='paul'", email);
		super.javascriptEnter("paul", email);
		super.javascriptClick(login);
		
//		System.out.println(super.getTestData());
//		super.javascriptEnter(test.get("columnName"), email);
		
	}
}
