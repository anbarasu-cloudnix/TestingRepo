package core.tests;

import org.testng.annotations.Test;

public class Scenarios_LaunchAppToTest extends SupportTest {
	
	@Test(priority=1, description="Launching app to start testing")
	public void launch_AppToTest() throws Exception{
		lp.verify_LoginPage_RURP();
		at.launchAppToTest();
				
	}
}
