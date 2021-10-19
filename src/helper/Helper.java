package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public static void clickOnElementJS (WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click();", element);
	}
	
	public static void scrollToElementJS (WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollIntoView();", element);
	}
	

}

// Helper nam pomaze u laksem koriscenju/izvlacenju potrebnih elemenata koje cemo cesto koristiti, kao sto su u ovom slucaju klikovi i postavljanje potrebnih
//elemenata u vidno polje.