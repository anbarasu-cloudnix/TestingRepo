package core.pages;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import agent.IAgent;
import central.Configuration;
import control.IControl;

public class Bugasura_ThreeDotMenu extends FullPage {

	public Bugasura_ThreeDotMenu(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);

	}

	/**
	 * Method definition of feedback button
	 * 
	 * @throws Exception
	 */
	public void feedback() throws Exception {
		List<IControl> applist = getControls("selectOnApp");
		applist.get(8).click();
		getControl("startTesting").click();
		getControl("ClickOnThreeDot").click();
		getControl("Feedback").click();

		System.out.println(getControls("justOnceButton").size());
		if (getControls("justOnceButton").size() > 0) {
			getControl("justOnceButton").click();
		}
		System.out.println(getControls("composeMail").size());
		if (getControls("composeMail").size() > 0) {
			String str = getControl("composeMail").getText();
			System.out.println(str);
			Assert.assertEquals(getTestData().get("composeMail"), getControl("composeMail").getText(),
					"Log in to your email and go to compose mail");
			logger.info("FeedBack Button Verified");
		}
		takeSnapShot();
		
	}

	/**
	 * Verifying three dot menu button
	 * 
	 * @throws Exception
	 */
	public void threeDotMenu_feedback() throws Exception {
			List<IControl> selectedApplist = getControls("selectOnApp");
			if (selectedApplist.size() == 0) {
				getControl("addNewApp").click();
				feedback();
			} else {
				getControl("showAppList").click();
				feedback();

			}
		}
	

}
