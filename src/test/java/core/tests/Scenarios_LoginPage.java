package core.tests;

import org.testng.annotations.Test;

public class Scenarios_LoginPage extends SupportTest{
	
	@Test(priority=2,description="Verifying login page")
	public void loginPage_Verification() throws Exception{
		lp.verify_LoginPage();		
	}
	
	@Test(priority=2,description="Verifying login page with Wrong username and wrong  password")
	public void loginPage_WUWP() throws Exception{
		lp.verify_LoginPage_WUWP();		
	}
	
	@Test(priority=3,description="Verifying login page with Right username and Wrong  password")
	public void loginPage_RUWP() throws Exception{
		lp.verify_LoginPage_RUWP();
		
	}
	
	@Test(priority=4,description="Verifying login page with No username and No  password")
	public void loginPage_NUNP() throws Exception{
		lp.verify_LoginPage_NUNP();
			
	}
	
	@Test(priority=5,description="Verifying Create account link in loginpage")
	public void loginPage_CreateAccountLink() throws Exception{
		lp.verify_LoginPage_CreateAccountLink();
			
	}
	
	@Test(priority=6,groups={"Verifying forgotPassword link in Login page"})
	public void loginPage_ForgotPasswordLink() throws Exception{
		lp.verify_LoginPage_ForgotPasswordLink();
			
	}
	
	@Test(priority=1,groups={"Regression"},description="Login with right username and right password(RURP)")
	public void loginPage_RURP() throws Exception{
		lp.verify_LoginPage_RURP();
			
	}
	
	
	
	

}
