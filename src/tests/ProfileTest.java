package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.BasicPage;

public class ProfileTest extends BasicTest {
	
	
	@Test
	
	public void editProfileTest() throws InterruptedException {		
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPopupPage.clickGetCloseElement();
		loginPage.login(username, password);
		String expectedLoginMessage = "Login Successfull";
		Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLoginMessage));
		
		driver.get("http://demo.yo-meals.com/member/profile");
		profilePage.changeAllBasicUserInputs("Drazen", "Gajic", "Ulica Neka 22", 060323444, 22408, "Serbia", "Serbia", "Ruma");
		String expectedSaveMessage = "Setup Successful";
		Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedSaveMessage));
		authPage.userLogout();
		String expectedLogoutMessage = "Logout Successfull!";
		Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLogoutMessage));
	}
	
		@Test
		
		public void changeProfileImage() throws InterruptedException {		
			driver.get("http://demo.yo-meals.com/guest-user/login-form");
			locationPopupPage.clickGetCloseElement();
			loginPage.login(username, password);
			String expectedLoginMessage = "Login Successfull";
			Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLoginMessage));
			driver.get("http://demo.yo-meals.com/member/profile");
			
			// ovde treba UBACITI SLIKU!!!!!!!!!!
			
			String expectedSavedImageMessage = "Profile Image Uploaded Successfully";
			Assert.assertTrue(profilePage.getUploadImageText().contains(expectedSavedImageMessage));
			profilePage.waitUntilElementNotPresent();
			
			profilePage.deleteProfilePicture();
			String expectedDeletedImageMessage = "Profile Image Deleted Successfully";
			Assert.assertTrue(profilePage.getDeletedImageText().contains(expectedDeletedImageMessage));
			profilePage.waitUntilElementNotPresent();
			
			authPage.userLogout();
			String expectedLogoutMessage = "Logout Successfull!";
			Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLogoutMessage));
		
}

}
