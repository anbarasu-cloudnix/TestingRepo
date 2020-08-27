package core.tests;

import org.testng.annotations.Test;

public class Regression_Scenarios extends SupportTest {

	/**
	 * Verifying Onboarding pages
	 * @throws Exception
	 */
	@Test(priority = 1, description = "Verifying onboardong screens")
	public void onBoardingPageVerification() throws Exception {
		bp.onboard();
	}

	@Test(priority = 2, description = "Signup with right username and right password(RURP) ")
	public void accCreateRURP() throws Exception {
		sp.signupPage();
		sp.accountCreationRURP();
	}

	@Test(priority = 3, description = "Reset password with Wrong username")
	public void ResetPasswordPageRU() throws Exception {
		sp.forgotPassword();
		rp.resetPasswordRU();
	}

	@Test(priority = 4, description = "Login with right username and right password(RURP)")
	public void loginPage_RURP() throws Exception {
		lp.verify_LoginPage_RURP();

	}

	@Test(priority = 5, description = "Launching app to start testing")
	public void launch_AppToTest() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
	}

	@Test(priority = 6, description = "Verifying Bugasura Overlay")
	public void verify_bugasura_Overlay() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlayIcon();
	}

	@Test(priority = 7, description = "Verifying Bugasura ReportBug")
	public void verify_BugasuraOverlay_ReportBug() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
		bo.verify_ReportBug();
	}

	@Test(priority = 8, description = "Verifying Next test in Bugasura Overlay Icon")
	public void verify_BugasuraOverlay_passTest() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_passTest();
	}

	@Test(priority = 9, description = "Verifying Exit test in Bugasura Overlay Icon")
	public void verify_BugasuraOverlay_Exit() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_Exit();
	}

	@Test(priority = 10, description = "Verifying Test reports with WIFI network")
	public void verify_TestsReport_WIFI() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_WIFI();
	}

	@Test(priority = 11, description = "ThreeDotMenu Feedback")
	public void threeDotMenu() throws Exception {
		lp.verify_LoginPage_RURP();
		bt.threeDotMenu_feedback();
	}

	@Test(priority = 12, description = "Validating Report generation")
	public void viewReport() throws Exception {
		lp.verify_LoginPage_RURP();
		bv.bugasurapage_viewReport();
	}

	@Test(priority = 13, description = "Remove app from applist")
	public void remove_ThiSApp() throws Exception {
		lp.verify_LoginPage_RURP();
		br.removeThisApp();
	}
}
