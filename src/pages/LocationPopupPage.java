package pages;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class LocationPopupPage extends BasicPage {

		public LocationPopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
			this.driver = driver;
			this.wait = wait;
			this.js = js;
			this.actions = actions;
		}

	
		// Elements -Elementi koji su na potrebni i koji se nalaze u okviru zahtevane funkcionalnosti
		
		
		public WebElement getSelectLocationHeader() {
			return this.driver.findElement(By.xpath("//*[@class='location-selector']"));
		}
		
		public WebElement getCloseElement() {
			return driver.findElement(By.xpath("//*[@class='close-btn close-btn-white']"));
		}

		public WebElement getKeyword() {
			return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
		}
		
		public WebElement getLocationItem(String locationName) {
			return this.driver.findElement(By.xpath("//li/a[contains(text(),'" + locationName + "')]/.."));
		}
		
		public WebElement getLocationInput() {
			return this.driver.findElement(By.xpath("//*[@id='location_id']"));
		}
		
		public WebElement getSubmit() {
			return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
		}
		
		
		
			//Methods / Clicks - Metode koje nam koriste samo za jednu operaciju tj. za klikove u okviru slozenijih metoda (ispod)
		
	
		public void clickGetSubmit() {
			this.getSubmit().click();
		}
		
		public void clickGetCloseElement() {
			this.getCloseElement().click();
		}
		
		public void clickGetLocationItem() {
			this.getSubmit().click();
		}
		
		// Methods  - Metode koje koristimo kao deo rseavanja iliispunjavanja neke funkcionalnosti,zbog toga je i u zaglavlju js executor, koji se ovde ne koristi.
		
		public void setLocation(String locationName) {
			this.getKeyword().click();
			String dataValue = getLocationItem(locationName).getAttribute("data-value");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value=arguments[1];", getLocationInput(), dataValue);

			js.executeScript("arguments[0].click();", getSubmit());
			
			//Ovo ispod je prva verzija kao sam pokusao da resim 
			//JavascriptExecutor js = (JavascriptExecutor) driver;	
			//js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), getLocationItem(locationName));
			//js.executeScript("arguments[0].click()", getSubmit());
			
	}
		}
	


