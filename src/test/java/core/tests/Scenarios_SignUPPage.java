package core.tests;

import org.testng.annotations.Test;

public class Scenarios_SignUPPage extends SupportTest {
	
	@Test(priority=1,description="Signup page verification")
	public void signUPPageVerification() throws Exception{
		sp.signupPage();
	}
	
	@Test(priority=2,groups={"Regression"},description="Signup with right username and right password(RURP) ")
	public void accCreateRURP() throws Exception{
		sp.signupPage();
		sp.accountCreationRURP();
	}
	
	@Test(priority=3,description="Signup with wrong username and wrong password(WUWP) ")
	public void accCreateWUWP() throws Exception{
		sp.signupPage();
		sp.accountCreationWUWP();
	}
	
	@Test(priority=4,description="Signup with right username and wrong password(RUWP) ")
	public void accCreateRUWP() throws Exception{
		sp.signupPage();
		sp.accountCreationRUWP();
	}
	
	@Test(priority=5,description="Signup with No username and No password(NUNP) ")
	public void accCreateNUNP() throws Exception{
		sp.signupPage();
		sp.accountCreationNUNP();
	}
	
	@Test(priority=6,description="Signup with Existing username and password(EUP) ")
	public void accCreateEUP() throws Exception{
		sp.signupPage();
		sp.accountCreationEUP();
	}
	
	@Test(priority=7,description="Verifying Login Link in signup page")
	public void loginLinkSignUp() throws Exception{
		sp.signupPage();
		sp.signupPageLoginLink();
	}
	
	@Test(priority=8,description="Verifying forgot password link in Signup page")
	public void forgotPasswordSignUP() throws Exception{
		sp.signupPage();
		sp.forgotPassword();
	}


}
