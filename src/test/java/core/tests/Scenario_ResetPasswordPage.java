package core.tests;

import org.testng.annotations.Test;

public class Scenario_ResetPasswordPage extends SupportTest {
	
	@Test(description="Reset password with Wrong username")
	public void ResetPasswordPageRU() throws Exception{
		sp.forgotPassword();
		rp.resetPasswordRU();
	}
	@Test(description="Reset password with Wrong username")
	public void ResetPasswordPageWU() throws Exception{
		sp.signupPage();
		sp.forgotPassword();
		rp.resetPasswordWU();
	}
	@Test(description="Verify login link in reset password page")
	public void ResetPassword_LoginLink() throws Exception{
		sp.signupPage();
		sp.forgotPassword();
		rp.reset_Password_loginLink();
	}
	@Test(description="Verify create account link in reset password page")
	public void ResetPassword_CreateAccount() throws Exception{
		sp.signupPage();
		sp.forgotPassword();
		rp.reset_Password_CreateAccount();
	}
	

}
