package core.pages;

import java.util.Map;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;

public class Bugasura_LoginPage extends FullPage {

	public Bugasura_LoginPage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		assertPageLoad();
	}
	
	/**
	 * Verifying Login screen
	 * @throws Exception
	 */
	public void verify_LoginPage() throws Exception {
		getControl("skipButton").click();
		if(getControls("email_Login").size()>0){
			getControl("email_Login").click();/* this is removed from build 1.14.0415*/
		}
		getControl("VerifyLoginPage").waitUntilVisible();
		System.out.println("Actual:"+getControl("VerifyLoginPage").getText() + "|Expected:"+getTestData().get("loginPage_txt"));
		Assert.assertEquals(getControl("VerifyLoginPage").getText(), getTestData().get("loginPage_txt"),"Login screen is not displayed");
		
	}
	
	/**
	 * Login with Wrong username and Wrong Password(WUWP)
	 * @throws Exception
	 */
	public void verify_LoginPage_WUWP() throws Exception {
		verify_LoginPage();
		getControl("Login_email").enterText(getTestData().get("login_email"));
		getControl("login_Password").enterText(getTestData().get("login_password"));
		getControl("Login_LoginButton").click();
		logger.info("Verified with Wrong username and wrong password");
		
		
	}
	
	/**
	 * Login with Right username and Wrong Password(WUWP)
	 * @throws Exception
	 */
	public void verify_LoginPage_RUWP() throws Exception {
		verify_LoginPage();
		getControl("Login_email").enterText(getTestData().get("login_email"));
		getControl("login_Password").enterText(getTestData().get("login_password"));
		getControl("Login_LoginButton").click();
		String actErrorPassTxt=getTestData().get("actPassErrorTxt");
		String expErrorPassTxt=getControl("passErrortxt").getText();
		Assert.assertEquals(expErrorPassTxt,actErrorPassTxt);
		System.out.println("Displayed error msg for password as:"+expErrorPassTxt);
		
	}
	
	/**
	 * Login with No username and No Password(NUNP)
	 * @throws Exception
	 */
	public void verify_LoginPage_NUNP() throws Exception {
		verify_LoginPage();
		getControl("Login_LoginButton").click();
		Assert.assertEquals(getControl("Login_Error_txt").getText(),getTestData().get("error_txt"),"Error msg not displayed");
		logger.info("Verified login without username and password");
			
	}
	
	/**
	 * Verifying createaccount link in Login Page
	 * @throws Exception
	 */
	public void verify_LoginPage_CreateAccountLink() throws Exception {
		verify_LoginPage();
		getControl("Login_CreateAccountLink").click();
		Assert.assertEquals(getControl("txt_CreateAccountLink").getText(), getTestData().get("txt_createAccount"),"Create account link in login page is not verified successfully");
		logger.info("Verified CreateAccountLink in Login page");
		
		
	}
	
	/**
	 * Verifying Forgot password Link in Login page
	 * @throws Exception
	 */
	public void verify_LoginPage_ForgotPasswordLink() throws Exception {
		verify_LoginPage();
		getControl("Login_ForgotPasswordLink").click();
		Assert.assertEquals(getControl("txt_ResetPasword").getText(),getTestData().get("txt_ResetPassword"),"Create account link in login page is not verified successfully");
		logger.info("Verified ForgotPasswordLink in Login Page");
		
	}
	
	/**
	 * This Method defines Right username and Right password(RURP)
	 * @throws Exception
	 */
	public void verify_LoginPage_RURP() throws Exception {
		verify_LoginPage();
		getControl("Login_email").enterText(getTestData().get("login_email"));
		getControl("login_Password").enterText(getTestData().get("login_password"));
		getControl("Login_LoginButton").click();
		appPermission();
		getControl("appToTestPage").waitUntilVisible();
		System.out.println(getControl("appToTestPage").getText());
		Assert.assertEquals(getControl("appToTestPage").getText(), getTestData().get("appToTestPage"),"LogIn is not successfull");
		logger.info("logged into App successfully");
		
	}
	
	public void appPermission() throws InterruptedException, Exception {
		
		if(getControls("launchApp_Bugasura_permission").size()>0){
			
			if(getControl("launchApp_Bugasura_permission").isVisible())
			{
				getControl("launchApp_Bugasura_permission").click();
				mobileDriver.navigate().back();
			}
			getControl("Dialog_StartNow").click();
			Thread.sleep(3000);
			if(getControls("Accessability_Bugasura").size()==0){
				swipeDown(4);
			}
			getControl("Accessability_Bugasura").click();
		}
		else{
			getControl("Dialog_StartNow").click();
			Thread.sleep(3000);
			if(getControls("Accessability_Bugasura").size()==0){
				swipeDown(4);
			}
			getControl("Accessability_Bugasura").click();	
		}
		
		getControl("enableApp").click();
		getControl("Dialog_StartNow").click();
		mobileDriver.navigate().back();
		mobileDriver.navigate().back();
		
	}

	
	
}
