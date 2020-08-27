package core.pages;

import java.util.Map;

import org.testng.Assert;

import agent.IAgent;
import central.Configuration;

public class Bugasura_OnboardingScreen extends FullPage {

	public Bugasura_OnboardingScreen(Configuration config, IAgent agent, Map<String, String> testData)
			throws Exception {
		super(config, agent, testData);

	}

	/**
	 * Verifying Onboarding pages when app launch
	 * 
	 * @throws Exception
	 */

	public void onboard() throws Exception {
		for (int i = 1; i <= 9; i++) {
			String onboardingTxt = "txtExpOnBoarding" + i;
			String expectedOnBoardingTxt = getTestData().get(onboardingTxt);
			String actualOnBoardingText = getControl("onBoardingtxt").getText();
			System.out.println("expected: " + expectedOnBoardingTxt);
			System.out.println("Actual: " + actualOnBoardingText);
			Assert.assertEquals(expectedOnBoardingTxt, actualOnBoardingText, "OnBoarding Text is not as Expected");
			getControl("swipeButton").click();
		}
		Thread.sleep(2000);
		System.out.println(getControl("email_Login").isVisible()); /*this button is removed from build 1.14.0411*/
		Assert.assertTrue(getControl("email_Login").isVisible(), "Not Navigated to login page");
//		getControl("VerifyLoginPage").waitUntilVisible();
//		System.out.println(getControl("VerifyLoginPage").getText());
	}

}
