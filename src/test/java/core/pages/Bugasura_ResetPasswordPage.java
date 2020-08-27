package core.pages;

import java.util.Map;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;

public class Bugasura_ResetPasswordPage extends FullPage{

	public Bugasura_ResetPasswordPage(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
		
		
		}
	
	/**
	 * Below Method defines reset password right username(RU) 
	 * @throws Exception
	 */
	public void resetPasswordRU() throws Exception{
		getControl("reset_emailId").enterText(getTestData().get("reset_email"));
		getControl("reset_Button").click();
		getControl("VerifyLoginPage").waitUntilVisible();
		Assert.assertEquals(getControls("VerifyLoginPage").size(), 1,"App crashes");
		System.out.println(getControl("VerifyLoginPage").getText());
		System.out.println(getTestData().get("loginPage_txt"));
		Assert.assertEquals(getControl("VerifyLoginPage").getText(), getTestData().get("loginPage_txt"),"Toast msg not displayed and not navigated to Login Page");
		logger.info("Verified Login page");
		
	}
	
	/**
	 * Below Method defines reset password Wrong username(WU)
	 * @throws Exception
	 */
	public void resetPasswordWU() throws Exception{
		getControl("reset_emailId").enterText(getTestData().get("reset_email"));
		getControl("reset_Button").click();
		Assert.assertEquals(getTestData().get("actErrorTxt"),getControl("reset_email_err_txt").getText(),"");
		System.out.println("Validated with invalid user emailID");
		logger.info("Validated with invalid user emailID");
		
	}

	/**
	 * Below Method defines LoginLink in Reset Password page
	 * @throws Exception
	 */
	public void reset_Password_loginLink() throws Exception{
		getControl("reset_LoginLink").click();
		Assert.assertEquals(getTestData().get("loginLink_Page_Verification"),getControl("loginLink_Page").getText());
		System.out.println("Verified login link in Reset Password page");
		
	}
	
	/**
	 * Below Method defines LoginLink in Reset Password page
	 * @throws Exception
	 */
	public void reset_Password_CreateAccount() throws Exception{
			
		getControl("reset_CreateAccount").click();
		Assert.assertEquals(getControl("reset_Create_account_page").getText(),getTestData().get("resetPass_CreateAccount"));
		System.out.println("Verified Create account link in Reset Password");
	}

	
}
