package practice_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import comComCastCRMGenericBaseTest.BaseClass;

public class Practice_RetryAnalyzer_Test extends BaseClass {
	@Test(retryAnalyzer = comComCastCRMGenericListenerUtility.RetryAnalyzerImpClass.class)
    public void acticeSimTest() {
    	System.out.println("execute acticeSimTest");
    	String actTitle=driver.getTitle();
    	Assert.assertEquals(actTitle, "Login");
    	System.out.println("Step_1");
    	System.out.println("Step_2");
    	System.out.println("Step_3");
    	System.out.println("Step_4");

    }

}
