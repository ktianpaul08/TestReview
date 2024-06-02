import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase{
	
	WebDriver driver;
	JavascriptExecutor js;
	
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
	
	
}
