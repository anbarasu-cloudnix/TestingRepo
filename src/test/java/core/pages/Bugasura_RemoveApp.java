package core.pages;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;
import control.IControl;

public class Bugasura_RemoveApp extends FullPage {

	public Bugasura_RemoveApp(Configuration config, IAgent agent, Map<String, String> testData) throws Exception {
		super(config, agent, testData);
		
	}
	
	/**
	 * Method definition of remove app.
	 * @throws Exception
	 */
	public void removeThisApp() throws Exception{

		List<IControl> selectedApplist=getControls("selectOnApp");
				if(selectedApplist.size()==0){
					getControl("center_addicon").click();
					getControl("second_app").click();
					boolean dotmenu = getControl("three_dot_menu").isVisible();
					if(dotmenu==true){
						  logger.info("three dot menu is diplayed");
						   getControl("three_dot_menu").click();
						   getControl("remove_this_app").click();
						   Assert.assertEquals(selectedApplist.size(),0,"App not Removed");
				   }
					
				}
				else
				{
					List<IControl> selectedApplist1=getControls("selectOnApp");
					int appSize=selectedApplist1.size();
					System.out.println(appSize);
					boolean dotmenu1 = getControl("three_dot_menu").isVisible();
					  if(dotmenu1==true){
						  	logger.info("three dot menu is diplayed");
						  	getControl("three_dot_menu").click();
						  	getControl("remove_this_app").click();
						  	List<IControl> selectedApplist2=getControls("selectOnApp");
							int appSizeAfterremoval=selectedApplist2.size();
						  	System.out.println("List size after app removal"+selectedApplist2.size());
						  	Assert.assertEquals(appSize-1, appSizeAfterremoval,"App not removed");
					 }	
					
				}
		
			
		 			 
		}
	
		  
		  
		  
		 
		  

		

	
	

}
