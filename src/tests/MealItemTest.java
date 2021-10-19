package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasicPage;

public class MealItemTest extends BasicTest {
	
	@Test
	
	public void addMealToCartTest() throws InterruptedException {		
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopupPage.clickGetCloseElement();
		mealPage.addToBasket(2);
		String expectedErrorMessage = "The Following Errors Occurred: Please Select Location";
		Assert.assertTrue(mealPage.getLocationErrorText().contains(expectedErrorMessage));
		mealPage.waitUntilElementNotPresent();
		locationPopupPage.setLocation("City Center - Albany");
		mealPage.addToBasket(2);
		String expectedAddMealMessage = "Meal Added To Cart";
		Assert.assertTrue(mealPage.getAddedMealText().contains(expectedAddMealMessage));
	}
		
		@Test
		
		public void addMealToFavouriteTest() throws InterruptedException {	
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopupPage.clickGetCloseElement();
		mealPage.addToFavourite();
		String expectedAtenntionMessage = "Please login first!";
		Assert.assertTrue(mealPage.getAttentionText().contains(expectedAtenntionMessage));
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPopupPage.clickGetCloseElement();
		loginPage.login(username, password);
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addToFavourite();
		String expectedAddedToFavouritesMessage = "Product has been added to your favorites.";
		Assert.assertTrue(mealPage.getAddedToFavouritesText().contains(expectedAddedToFavouritesMessage));
		
		
	}
		
		@Test
		
		public void clearCartTest() throws InterruptedException {	
			driver.get("http://demo.yo-meals.com/meals");
			locationPopupPage.getLocationItem("City Center - Albany");
			
			
			// UBACITI xlsx FAJL!!!!!
			
			
			cartSummaryPage.clearCart();
			String expectedEmptyCartMessage = "All meals removed from Cart successfully";
			Assert.assertTrue(cartSummaryPage.getEmptyCartText().contains(expectedEmptyCartMessage));
			
	
	}

}
