package tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.BasicPage;

public class ProfileTest extends BasicTest {
	
	
	@Test (priority = 3)
	
	public void editProfileTest() throws InterruptedException {		
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPopupPage.clickGetCloseElement();
		loginPage.login(username, password);
		String expectedLoginMessage = "Login Successfull";
		Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLoginMessage), "ERROR, no element");
		
		driver.get("http://demo.yo-meals.com/member/profile");
		profilePage.changeAllBasicUserInputs("Drazen", "Gajic", "Ulica Neka 22", 060323444, 22408, "Serbia", "Serbia", "Ruma");
		String expectedSaveMessage = "Setup Successful";
		Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedSaveMessage), "ERROR, no element");
		authPage.userLogout();
		String expectedLogoutMessage = "Logout Successfull!";
		Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLogoutMessage), "ERROR, no element");
	}
	
		@Test (priority = 4)
		
		public void changeProfileImage() throws InterruptedException, IOException, AWTException {		
			driver.get("http://demo.yo-meals.com/guest-user/login-form");
			locationPopupPage.clickGetCloseElement();
			loginPage.login(username, password);
			String expectedLoginMessage = "Login Successfull";
			Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLoginMessage), "ERROR, no element");
			driver.get("http://demo.yo-meals.com/member/profile");
			notificationSystemPage.waitUntilElementNotPresent();
			
			
			profilePage.UploadPhoto();
			
			String expectedSavedImageMessage = "Profile Image Uploaded Successfully";
			Assert.assertTrue(profilePage.getUploadImageText().contains(expectedSavedImageMessage), "ERROR, no element");
			profilePage.waitUntilElementNotPresent();
			
			profilePage.removePhoto();
			String expectedDeletedImageMessage = "Profile Image Deleted Successfully";
			Assert.assertTrue(profilePage.getDeletedImageText().contains(expectedDeletedImageMessage), "ERROR, no element");
			profilePage.waitUntilElementNotPresent();
			
			authPage.userLogout();
			String expectedLogoutMessage = "Logout Successfull!";
			Assert.assertTrue(notificationSystemPage.getNotificationMessageText().contains(expectedLogoutMessage), "ERROR, no element");
		
}

}
