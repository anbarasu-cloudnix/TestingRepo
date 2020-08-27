package core.tests;

import org.testng.annotations.Test;

public class Scenarios_BugasuraOverlayicon extends SupportTest {

	@Test(description = "Verifying Bugasura Overlay")
	public void verify_bugasura_Overlay() throws Exception {
		sp.signupPage();
		sp.accountCreationRURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlayIcon();

	}

	@Test(description = "Verifying Bugasura ReportBug")
	public void verify_BugasuraOverlay_ReportBug() throws Exception {
		sp.signupPage();
		sp.accountCreationRURP();
		at.launchAppToTest();
		bo.verify_ReportBug();
	}

	@Test(description = "Verifying Next test in Bugasura Overlay Icon")
	public void verify_BugasuraOverlay_passTest() throws Exception {
		sp.signupPage();
		sp.accountCreationRURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_passTest();
	}

	@Test(description = "Verifying Exit test in Bugasura Overlay Icon")
	public void verify_BugasuraOverlay_Exit() throws Exception {
		sp.signupPage();
		sp.accountCreationRURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_Exit();
	}

	@Test(description = "Verifying Test reports with WIFI network")
	public void verify_TestsReport_WIFI() throws Exception {
		sp.signupPage();
		sp.accountCreationRURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_WIFI();
	}

	@Test(description = "Verifying Test reports with WIFI network")
	public void verify_TestsReport_4g() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_4g();
	}

	@Test(description = "Verifying Test reports with WIFI network")
	public void verify_TestsReport_3g() throws Exception {
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
		bo.verify_BugasuraOverlay_3g();
	}

}
