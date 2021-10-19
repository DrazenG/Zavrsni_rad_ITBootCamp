package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
	
	
	public  NotificationSystemPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Elements -Elementi koji su na potrebni i koji se nalaze u okviru zahtevane funkcionalnosti
	
	
	public WebElement getNotification() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}
	
	// Methods  - Metode koje koristimo kao deo resavanja ili ispunjavanja neke funkcionalnosti
	
	public String getNotificationMessageText() {
	return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]/div/div/ul/li")).getText();        
	}
	
	
	public void waitUntilElementNotPresent() {
		wait.until(ExpectedConditions.attributeContains(getNotification(), "hidden", "hidden"));
		System.out.println("Element vise nije prisutan.");
	}
	}
