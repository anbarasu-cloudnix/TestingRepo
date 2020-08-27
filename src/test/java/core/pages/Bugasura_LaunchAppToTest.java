package core.pages;
import java.util.List;
import java.util.Map;

import agent.IAgent;
import central.Configuration;
import control.IControl;;

public class Bugasura_LaunchAppToTest extends FullPage {
	
	
	public Bugasura_LaunchAppToTest(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
		
	}
    /**
	 * Method definition of App Permissions
	 * @throws Exception
	 */
	public void permission() throws Exception{
		if(getControls("launchApp_Bugasura_permission").size()>0){
			
			if(getControl("launchApp_Bugasura_permission").isVisible())
			{
				getControl("launchApp_Bugasura_permission").click();
				mobileDriver.navigate().back();
			}
			getControl("Dialog_StartNow").click();
			Thread.sleep(3000);
			if(getControls("Accessability_Bugasura").size()==0){
				swipeDown(4);
			}
			getControl("Accessability_Bugasura").click();
			getControl("enableApp").click();
			getControl("Dialog_StartNow").click();
			mobileDriver.navigate().back();
			mobileDriver.navigate().back();
		}
		else{
			getControl("Dialog_StartNow").click();
			
		}
		takeSnapShot();
		takeSnapShot();
		Thread.sleep(2000);
	}

	/**
	 * Method to launch App to test
	 * @return 
	 * @throws Exception
	 */
	public void testApp() throws Exception{
		
		List<IControl> appTextList=getControls("app_name");
		int apnameSize=getControls("app_name").size();
		String appname=appTextList.get(8).getText();
		System.out.println(appname);
		appTextList.get(8).click();
		System.out.println("startingtesting button apps:"+getControls("startTesting").size());
		getControls("startTesting").get(getControls("startTesting").size()-1).click();
		getControl("functionalTesting").click();
		Thread.sleep(5000);
		System.out.println(getControls("createNewReportCenter").size());
		System.out.println(getControls("createNewReportCorner").size());
		/*Validating reports size to click on createButton, when there is empty list in page*/ 
		if(getControls("createNewReportCenter").size()==0) {
			getControl("createNewReportCorner").click();
			getControl("enter_New_Report_txt").enterText("Bugasura"+generateRandomNumber(3));
			getControl("start_Button").click();
			permission();
		
		}
		/*Validating reports size to click on createButton,When there is existing reports.*/
		else{
			
			getControl("createNewReportCenter").click();
			getControl("enter_New_Report_txt").enterText("Bugasura"+generateRandomNumber(3));
			getControl("start_Button").click();
			permission();
	}
	
}
	
	/**
	 * Method define select an app and launch app to start testing.
	 * @return 
	 * @throws Exception
	 */
	public void launchAppToTest() throws Exception{
		
		if(getControls("addNewApp").size()>0){
			getControl("addNewApp").click();
				/*calling testApp method to launch app to test*/
			 testApp();
			
		}
		else
		{
			getControl("showAppList").click();
				/*calling testApp method to launch app to test*/
			testApp();
			
		}	
	}

}
		

