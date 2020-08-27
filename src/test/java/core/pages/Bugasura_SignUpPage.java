package core.pages;

import java.util.Map;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;

public class Bugasura_SignUpPage extends FullPage {

	public Bugasura_SignUpPage(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);

	}

	/**
	 * Below Method defines with right username and right password(RURP) 
	 * @throws Exception
	 */
	public void accountCreationRURP() throws Exception {
		String email = "bugasura";
		getControl("emailId").enterText(email + generateString(3) + "_int@appachhi.com");
		String password = getTestData().get("password4");
		getControl("password").enterText(password);
		getControl("createButton").click();
		if (getControls("launchApp_Bugasura_permission").size() > 0) {

			if (getControl("launchApp_Bugasura_permission").isVisible()) {
				getControl("launchApp_Bugasura_permission").click();
				mobileDriver.navigate().back();
			}
			getControl("Dialog_StartNow").click();
			Thread.sleep(3000);
			if (getControls("Accessability_Bugasura").size() == 0) {
				swipeDown(4);
			}
			getControl("Accessability_Bugasura").click();
		} else {
			getControl("Dialog_StartNow").click();
			Thread.sleep(3000);
			if (getControls("Accessability_Bugasura").size() == 0) {
				swipeDown(4);
			}
			getControl("Accessability_Bugasura").click();
		}
		
		getControl("enableApp").click();
		getControl("Dialog_StartNow").click();
		mobileDriver.navigate().back();
		mobileDriver.navigate().back();
		getControl("appToTestPage").waitUntilVisible();
		System.out.println(getControl("appToTestPage").getText());
		Assert.assertEquals(getControl("appToTestPage").getText(), getTestData().get("appToTestPage"),
				"Account is created successfully");
		logger.info("Signed up and logged into App successfully");
	}
	
	/**
	 * Below Method defines with Wrong username and wrong password(WUWP)
	 * @throws Exception
	 */
	public void accountCreationWUWP() throws Exception {
		String email = getTestData().get("email");
		getControl("emailId").enterText(email);
		String password = getTestData().get("password");
		getControl("pass").enterText(password);
		getControl("createButton").click();
		String actErrorTxt = getTestData().get("actErrorTxt");
		String expErrorTxt = getControl("errorTxt").getText();
		Assert.assertEquals(expErrorTxt, actErrorTxt);
		System.out.println("Error message:" + expErrorTxt);
		logger.info("Not signed up with Wrong username and password and displayed error msg:" + expErrorTxt);

	}
	
	/**
	 * Below Method defines with right username and Wrong password(RURP)
	 * @throws Exception
	 */
	public void accountCreationRUWP() throws Exception {
		String email = getTestData().get("email1");
		getControl("emailId").enterText(email);
		String password = getTestData().get("password1");
		getControl("pass").enterText(password);
		getControl("createButton").click();
		String actErrorPassTxt = getTestData().get("actPassErrorTxt");
		String expErrorPassTxt = getControl("passErrortxt").getText();
		Assert.assertEquals(expErrorPassTxt, actErrorPassTxt);
		System.out.println("Displayed error msg for password as:" + expErrorPassTxt);
		logger.info("Not signed up with Right username and Wrong password and displayed error msg:" + expErrorPassTxt);

	}
	
	/**
	 * Below Method defines with no username and no password(NUNP)
	 * @throws Exception
	 */
	public void accountCreationNUNP() throws Exception {
		getControl("createButton").click();
		String actErrorTxt = getTestData().get("actErrorTxt1");
		String expErrorTxt = getControl("errorTxt").getText();
		Assert.assertEquals(expErrorTxt, actErrorTxt);
		logger.info("Not singed up");

	}
	
	/**
	 * Below Method defines with Exists username and password(EUP)
	 * @throws Exception
	 */
	public void accountCreationEUP() throws Exception {
		String email = getTestData().get("email3");
		getControl("emailId").enterText(email);
		String password = getTestData().get("password3");
		getControl("pass").enterText(password);
		getControl("createButton").click();
		String expTxtCreatAccount = getControl("txtCreateAcc").getText();
		String actTxtCreatAccount = getTestData().get("actTxtAccCreate");
		Assert.assertEquals(expTxtCreatAccount, actTxtCreatAccount);
		System.out.println("displays existing account msg");

	}
	
	/**
	 * Below Method defines loginLink in Singup page
	 * @throws Exception
	 */
	public void signupPageLoginLink() throws Exception {
		getControl("loginLink").click();
		Assert.assertEquals(getTestData().get("loginLink_Page_Verification"), getControl("loginLink_Page").getText());
		System.out.println("Verified login link in signup page");
		
	}
	
	/**
	 * Below Method defines forgotPassword in Singup page
	 * @throws Exception
	 */
	public void forgotPassword() throws Exception {
		getControl("skipButton").click();
		getControl("forgotPass").click();
		getControl("ResetPassword_signup_Page").waitUntilVisible();
		System.out.println(getControl("ResetPassword_signup_Page").getText());
		Assert.assertEquals(getControl("ResetPassword_signup_Page").getText(), getTestData().get("resetPassword_Page"),
				"Not navigated to Reset Password Page");
		logger.info("Navigated to Reset Password Page");
	}

	/**
	 * Signup page verification
	 * @throws Exception
	 */
	public void signupPage() throws Exception {
		getControl("skipButton").click();
		getControl("signUp").click();
		if (getControls("email_Signup").size() > 0) {
			getControl("email_Signup").click();
		}
		getControl("txtCreateAcc").waitUntilVisible();
		System.out.println(getControl("txtCreateAcc").getText());
		System.out.println(getTestData().get("verify_CreateAccount"));
		Assert.assertEquals(getControl("txtCreateAcc").getText(), getTestData().get("verify_CreateAccount"),
				"Not Navigated to Create Account Page");
		logger.info("Navigated to create Account page");

	}
}
