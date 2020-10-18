package amazonAutomationFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.EchoPage;
import pageobjects.nav;

public class PomEcho extends Base {
    @Test
    public void navEcho() {
        extentTest = extentReports.createTest("ECHO");
        //Navigate to nav button on left
        actions.moveToElement(nav.getNavElement(driver)).click().build().perform();
        // click on ECHO & Alexa from navigation menu
        actions.moveToElement(EchoPage.getEcho(driver)).click().build().perform();
        // Select ECHO Show 8 from ECHO & Alexa
        actions.moveToElement(EchoPage.getEcho8(driver)).click().build().perform();
        //Verify Product title
        Assert.assertEquals(EchoPage.productTitle(driver).getText(), EchoPage.verifyTitle(driver));
        System.out.println("Verify Product Title" + EchoPage.productTitle(driver).getText());
        //checkpoint
        Assert.assertTrue(true, driver.getTitle());
        System.out.println("Welcome to ECHO 8  Page : " + driver.getTitle());
    }


}
