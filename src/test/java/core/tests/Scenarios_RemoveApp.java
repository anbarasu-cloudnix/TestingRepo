package core.tests;

import org.testng.annotations.Test;

public class Scenarios_RemoveApp extends SupportTest {
	
	@Test(description="Remove app from applist")
	public void remove_ThiSApp() throws Exception{
		lp.verify_LoginPage_RURP();
		br.removeThisApp();
		
		
	}

}
