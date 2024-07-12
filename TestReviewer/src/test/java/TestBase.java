import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Utility.ExcelUtil;

public class TestBase{
	
	WebDriver driver;
	JavascriptExecutor js;
	
	ExcelUtil excelUtil = new ExcelUtil();
	
	public HashMap<String, String> test;
	
	public WebDriver setDriver(String browser) {
		switch(browser){
			
			case "Edge":
			System.setProperty("webdriver.edge.driver","D:\\OneDrive\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();	
			
			break;
			case "Chrome":
				//System.setProperty("webdriver.edge.driver","D:\\OneDrive\\edgedriver_win64\\msedgedriver.exe");
//				driver = new ChromeDriver();
				System.out.println("asdasd");
			break;
		}
		return driver;
		
	}
	
//	public WebDriver setDriver2() {
//		System.setProperty("webdriver.edge.driver","D:\\OneDrive\\edgedriver_win64\\msedgedriver.exe");
//		driver = new EdgeDriver();
//		return driver;
//		
//	}
	public void javascriptEnter(String text, WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+ text + "'", element);
	}
	
	public void javascriptClick(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
//	public String getTestData(String text) {
//		test = excelUtil.getData("Sheet1", "tc1" );
//		return test.get(text);
//	}
	
	
	
}
