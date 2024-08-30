package practice_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import comComCastCRMGenericBaseTest.BaseClass;

//@Listeners(comComCastCRMGenericListenerUtility.ListenerImpClass.class)
public class Practice_ListenerInvoiceTest extends BaseClass {
	@Test
    public void createInvoiceTest() {
    	System.out.println("execute createInvoiceTest");
    	String actTitle=driver.getTitle();
    //	Assert.assertEquals(actTitle, "Login");
    	SoftAssert sa=new SoftAssert();
    	sa.assertEquals(actTitle, "Login");
    	
    	System.out.println("Step_1");
    	System.out.println("Step_2");
    	System.out.println("Step_3");
    	System.out.println("Step_4");
    	sa.assertAll();

    }
    @Test
    public void createInvoiceWithContactTest() {
    	System.out.println("execute createInvoiceWithContactTest");
    	System.out.println("Step_1");
    	System.out.println("Step_2");
    	System.out.println("Step_3");
    	System.out.println("Step_4");

    }
}
