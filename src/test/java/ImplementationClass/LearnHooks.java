package ImplementationClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class LearnHooks {
	
@Before
public void beforeScenario(Scenario sc)
{
	System.out.println("Before");
	/*CreateLeadSteps cL = new CreateLeadSteps();
	cL.loginTheLeafTaps();
	cL.navigateToCreateLeadPage();*/
}

@After
public void afterScenario(Scenario sc)
{
System.out.println("After");
CreateLeadSteps.driver.close();

}
}

