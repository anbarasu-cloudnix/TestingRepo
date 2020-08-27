package core.pages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import agent.IAgent;
import central.Configuration;
import control.IControl;
import io.appium.java_client.TouchAction;

public class Bugasura_OverlayIcon extends FullPage {
	int bugasuraOverlayIconXaxis = 50, bugasuraOverlayIconYaxis, deviceDensity;
	int testFlows, failures, success, failures1, success1, passvalueNumber, failvalueNumber;
	double bugasuraOverlayXaxis, bugasuraOverlayYaxis, MenuClicksXaxis, reportBugYaxis, passTestYaxis, menuOverlayYaxis,
			endTestYaxis, bugasuraMenubuttonsDiff;

	public Bugasura_OverlayIcon(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
	}

	/**
	 * Method to click on BugasuraOverlay
	 * 
	 * @throws Exception
	 */
	public void click_bugasuraOverlay() throws Exception {
		/* Calculation to click on overlay icon using device density, Below command is to get device density */
		process = run.exec("adb -s " + System.getProperty("mobile_udid") + " shell getprop ro.sf.lcd_density");
		/*Get Density value of device display and trim spaces.*/
		int density = Integer.parseInt(
				new BufferedReader(new InputStreamReader(process.getInputStream())).readLine().replaceAll("\\s", ""));
		deviceDensity = density / 160;
		bugasuraOverlayIconYaxis = 200 + (30 * deviceDensity) + 20;
		System.out.println("Y axis for overlay: "+bugasuraOverlayIconYaxis);
		new TouchAction(this.getAgent().getMobileDriver()).press(bugasuraOverlayIconXaxis, bugasuraOverlayIconYaxis)
				.release().perform();
	}

	/**
	 * Method to calculate OverlayPosition
	 * 
	 * @throws Exception
	 */
	public void overlayActions(int bugasuraOverlayIconYaxis) throws Exception {
		click_bugasuraOverlay();
		new TouchAction(mobileDriver).press(bugasuraOverlayIconXaxis, bugasuraOverlayIconYaxis).release().perform();
	}

	/**
	 * Method to verify BugReportPage
	 * 
	 * @throws Exception
	 */
	public void verify_BugReportPage() throws Exception {
		getControl("txtSummary").enterText("bug in image");
		getControl("btnReport").click();
	}

	/**
	 * Method definition of ReportBug
	 * 
	 * @throws Exception
	 */
	public void verify_ReportBug() throws Exception {
		overlayActions(350);
		Assert.assertEquals(getControls("saveReport").size(), 1, "ScreenShot is not captured");
		getControl("saveReport").click();
		if (getControls("report").size() > 0) {
			verify_BugReportPage();
		}

	}

	/**
	 * Method definition of BugasuraOverlay next test option
	 * 
	 * @throws Exception
	 */
	public void verify_BugasuraOverlay_passTest() throws Exception {
		overlayActions(500);
		takeSnapShot();
		System.out.println("Next test clicked");

	}

	/**
	 * Method definition of BugasuraOverlay exit test
	 * 
	 * @throws Exception
	 */
	public void verify_BugasuraOverlay_Exit() throws Exception {
		overlayActions(650);
		Assert.assertEquals(getControl("txtAppToTestPage").getText(), getTestData().get("appToTestPage"),
				"Test not exited");
	}

	public void bugasuraOverlayTestReports() throws Exception {
		verify_ReportBug();
		verify_BugasuraOverlay_passTest();
		verify_BugasuraOverlay_Exit();
		bugasurapage_viewReport();

	}

	/**
	 * Method Definition of Test report with Wifi network
	 * 
	 * @throws Exception
	 */
	public void verify_BugasuraOverlay_WIFI() throws Exception {
		bugasuraOverlayTestReports();
	}

	/**
	 * Method Definition of Test report with 4g network
	 * 
	 * @throws Exception
	 */
	public void verify_BugasuraOverlay_4g() throws Exception {
		bugasuraOverlayTestReports();
	}

	/**
	 * Method Definition of Test report with 3g network
	 * 
	 * @throws Exception
	 */
	public void verify_BugasuraOverlay_3g() throws Exception {
		bugasuraOverlayTestReports();
	}

	/**
	 * Method Definition of Bugasura Overlay Icon Verification
	 * 
	 * @throws Exception
	 */
	public void verify_BugasuraOverlayIcon() throws Exception {
		takeSnapShot();
		click_bugasuraOverlay();

	}

	/**
	 * Method definition of View Report for the different networks
	 * 
	 * @throws Exception
	 */
	public void viewreport() throws Exception {
		List<IControl> selectedApplist = getControls("app_name");
		System.out.println(selectedApplist.size());
		/* Get the Last tested app name from list */
		String app_Name = selectedApplist.get(selectedApplist.size() - 1).getText();
		System.out.println(app_Name);
		getControl("view_icon").click();
		String actual = getControl("reports_text").getText();
		Assert.assertEquals(actual, "Reports", "Not navigated to report page");
		List<IControl> list = getControls("view_report");
		System.out.println("View Reports:" + list.size());
		if (list.size() == 0) {
			logger.info("no lists to click");
		} else {

			for (int i = 0; i < list.size(); i++) {
				String reportname = getControls("app_name").get(i).getText();
				System.out.println(reportname);
				if (app_Name.equals(reportname)) {
					logger.info("clicked on the given report:" + reportname);
					list.get(i).click();
					break;
				}
			}
		}
		List<IControl> viewLists = getControls("report_view");
		System.out.println("ViewLists:" + viewLists.size());
		if (viewLists.size() == 0) {
			logger.info("no view reports available");
		} else {
			/* Click on recent report from view report screen */
			viewLists.get(0).click();
		}

		String textflowvalue = getControl("testFlow").getText();
		System.out.println("TEST FLOW:" + textflowvalue);

		String passvalue = getControl("pass").getText();
		int passvalueNumber = Integer.parseInt(passvalue);
		System.out.println("PASS:" + passvalueNumber);

		String failvalue = getControl("fail").getText();
		int failvalueNumber = Integer.parseInt(failvalue);
		System.out.println("FAIL:" + failvalueNumber);

		getControl("viewDetailedResport").click();

		getControl("reportSummary").waitUntilVisible();
		Assert.assertEquals(getControl("reportSummary").isVisible(), true, "Network is slow");
		swipeDown(4);
		int testFlows = getControls("testFlows").size();
		System.out.println("Total test flows=" + testFlows);
		int failures = getControls("failure").size();
		System.out.println("Failed tests:" + failures);
		int success = getControls("success").size();
		System.out.println("Success:" + success);
		if (failures > 0 && success > 0) {
			Assert.assertEquals(passvalueNumber, success, "Bugasura app report and Platform report are not same");
			Assert.assertEquals(failvalueNumber, failures, "Bugasura app report and Platform report are not same");
		} else {

			failures1 = getControls("failure1").size();
			System.out.println("Failed tests:" + failures1);
			int success1 = getControls("success1").size();
			System.out.println("Success:" + success1);
			Assert.assertEquals(passvalueNumber, success1, "Bugasura app report and Platform report are not same");
			Assert.assertEquals(failvalueNumber, failures1, "Bugasura app report and Platform report are not same");
		}

	}

	/**
	 * Method definition for view report icon
	 * 
	 * @throws Exception
	 */
	public void bugasurapage_viewReport() throws Exception {
		List<IControl> selectedApplist = getControls("selectOnApp");
		System.out.println(selectedApplist.size());
		if (selectedApplist.size() == 0) {
			getControl("center_addicon").click();
			getControl("second_app").click();
			viewreport();
		}

		else {
			viewreport();
		}

	}

}
