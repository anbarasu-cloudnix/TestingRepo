package core.tests;

import org.testng.annotations.Test;

public class Scenario_ThreeDotMenuFeedback extends SupportTest {
	
	@Test(description="ThreeDotMenu Feedback")
	public void threeDotMenu() throws Exception{
		lp.verify_LoginPage_RURP();
		bt.threeDotMenu_feedback();
			
	}
	

}
