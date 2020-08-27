package core.tests;

import org.testng.annotations.Test;

public class Scenarios_viewReports extends SupportTest {
	
	@Test(description="Validating Report generation")
	public void viewReport() throws Exception{
		lp.verify_LoginPage_RURP();
		bv.bugasurapage_viewReport();
		
	}
}
