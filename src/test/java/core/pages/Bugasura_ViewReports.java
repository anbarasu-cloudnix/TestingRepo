package core.pages;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;
import control.IControl;

public class Bugasura_ViewReports extends FullPage {
	int testFlows, failures, success, failures1, success1, passvalueNumber, failvalueNumber;

	public Bugasura_ViewReports(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);

	}

	/**
	 * Method definition to View Report
	 * 
	 * @throws Exception
	 */
	public void viewreport() throws Exception {
		getControl("view_icon").click();
		String actual = getControl("reports_text").getText();
		Assert.assertEquals(actual, "Reports", "Not navigated to report page");
		/* Get Report list size from Reports Screen */
		List<IControl> list = getControls("reports_list");
		System.out.println(list.size());
		if (list.size() == 0) {
			logger.info("no lists to click");
		} else {
			swipeUp();
			/* click on first report view */
			list.get(0).click();
			Assert.assertEquals(actual, "Reports");
			/* Click on first report from view report screen */
			List<IControl> viewLists = getControls("report_view");
			if (viewLists.size() == 0) {
				logger.info("no view reports available");
			} else {
				String reportname = getControls("report_name").get(0).getText();
				logger.info("clicked on the given report:" + reportname);
				viewLists.get(0).click();
			}
			String textflowvalue = getControl("testFlow").getText();
			System.out.println("TEST FLOW:" + textflowvalue);
			passvalueNumber = Integer.parseInt(getControl("pass").getText());
			System.out.println("PASS:" + passvalueNumber);
			failvalueNumber = Integer.parseInt(getControl("fail").getText());
			System.out.println("FAIL:" + failvalueNumber);
			getControl("btnViewDetailedReport").click();
			Thread.sleep(7000);
			getControl("reportSummary").waitUntilVisible();
			swipeDown(4);
			testFlows = getControls("testFlows").size();
			System.out.println("Total test flows=" + testFlows);
			failures = getControls("failure").size();
			System.out.println("Failed tests:" + failures);
			success = getControls("success").size();
			System.out.println("Success:" + success);
			if (failures == failvalueNumber && success == passvalueNumber) {
				Assert.assertEquals(passvalueNumber, success,
						"Report Summary and detailed Report summary are not Same for Success test cases");
				Assert.assertEquals(failvalueNumber, failures,
						"Report Summary and detailed Report summary are not Same for failed test cases");
			} else {

				failures1 = getControls("failure1").size();
				System.out.println("Failed tests:" + failures1);
				int success1 = getControls("success1").size();
				System.out.println("Success:" + success1);
				Assert.assertEquals(passvalueNumber, success1,
						"Report Summary and detailed Report summary are not Same for Success test cases");
				Assert.assertEquals(failvalueNumber, failures1,
						"Report Summary and detailed Report summary are not Same for failed test cases");
			}
		}
	}

	/**
	 * Method definition for view report icon
	 * 
	 * @throws Exception
	 */
	public void bugasurapage_viewReport() throws Exception {
		List<IControl> selectedApplist = getControls("selectOnApp");
		System.out.println(selectedApplist);
		if (selectedApplist.size() == 0) {
			getControl("center_addicon").click();
			getControl("second_app").click();
			viewreport();

		} else {
			viewreport();
		}

	}

}
