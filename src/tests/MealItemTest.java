package tests;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.BasicPage;

public class MealItemTest extends BasicTest {
	
	@Test (priority = 0)
	
	public void addMealToCartTest() throws InterruptedException {		
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopupPage.clickGetCloseElement();
		mealPage.addToBasket("1");
		String expectedErrorMessage = "The Following Errors Occurred: Please Select Location";
		Assert.assertTrue(mealPage.getLocationErrorText().contains(expectedErrorMessage), "ERROR, no element");
		mealPage.waitUntilElementNotPresent();
		locationPopupPage.setLocation("City Center - Albany");
		Thread.sleep(1200);
		mealPage.addToBasket("1");
		String expectedAddMealMessage = "Meal Added To Cart";
		Assert.assertTrue(mealPage.getAddedMealText().contains(expectedAddMealMessage), "ERROR, no element");
	}
		
		@Test (priority = 1)
		
		public void addMealToFavouriteTest() throws InterruptedException {	
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopupPage.clickGetCloseElement();
		mealPage.addToFavourite();
		String expectedAtenntionMessage = "Please login first!";
		Assert.assertTrue(mealPage.getAttentionText().contains(expectedAtenntionMessage), "ERROR, no element");
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPopupPage.clickGetCloseElement();
		loginPage.login(username, password);
		Thread.sleep(1500);
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addToFavourite();
		String expectedAddedToFavouritesMessage = "Product has been added to your favorites.";
		Assert.assertTrue(mealPage.getAddedToFavouritesText().contains(expectedAddedToFavouritesMessage), "ERROR, no element");
		
		
	}
		
		@Test (priority = 2)
		
		public void clearCartTest() throws InterruptedException, AWTException{	
			driver.get("http://demo.yo-meals.com/meals");
			locationPopupPage.getLocationItem("City Center - Albany");
			Thread.sleep(1200);
			
			
			File file = new File("data/Data.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet meals = wb.getSheet("Meals");

			for (int i = 1; i <= meals.getLastRowNum(); i++) {

				String mealUrl = meals.getRow(i).getCell(0).getStringCellValue();
				
				// za soft assert mi je trebao neki jar fajl koji nisam uspeo da pronadjam medju 
				// element has no attached javadoc
				
				driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
				mealPage.addToBasket("3");
				softAssert.assertTrue(notificationSystemPage.getNotificationMessageText().contains("Meal Added To Cart"), "ERROR, no element");
				notificationSystemPage.waitUntilElementNotPresent();

			}
			softAssert.assertAll();
			Thread.sleep(1000);
			cartSummaryPage.clearCart();
			Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains("All meals removed from Cart successfully"), "ERROR, no element");
			notificationSystemPage.waitUntilElementNotPresent();
			wb.close();
			
			
		}
}
