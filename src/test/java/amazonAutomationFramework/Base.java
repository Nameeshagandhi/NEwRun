package amazonAutomationFramework;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobjects.LoginPage;
import pageobjects.nav;

import java.util.concurrent.TimeUnit;

public class Base {
    protected static WebDriver driver = null;
    protected static Actions actions;
    protected JavascriptExecutor jse;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @BeforeSuite
    public void reportInit() {
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/TestReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //System config details
        extentReports.setSystemInfo("Application Name", "Amazon");
        extentReports.setSystemInfo("User_Name", "Nameesha");
        extentReports.setSystemInfo("Environment", "Test");

        // HTML level Configuration
        extentHtmlReporter.config().setDocumentTitle("Automation Test Report");
        extentHtmlReporter.config().setReportName("Amazon Automation");
        extentHtmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeClass
    public void init() {

        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in/");
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Checkpoint
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        System.out.println("Welcome to Amazon");
    }

    @BeforeMethod
    public void signIn() {
        // Use page Object library now
        // Mouse hover sign-in
        actions.moveToElement(LoginPage.log(driver)).perform();
        //Click on sign-in
        actions.moveToElement(LoginPage.signIn(driver)).click().build().perform();
        //Enter email id
        LoginPage.btn_LogIn(driver).sendKeys("9871867332");
        //Enter the Continue Button
        LoginPage.cont(driver).click();
        //Enter the password
        LoginPage.password(driver).sendKeys("Krisha@2016");
        //Click on Login Button
        LoginPage.login(driver).click();
        //Checkpoint
        Assert.assertEquals("Hello, Nameesha", LoginPage.getText(driver));
        System.out.println(LoginPage.getText(driver));
    }

    @AfterMethod(alwaysRun = true)
    public void log(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() +
                    "Test Status PASSED", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +
                    "..Test Status Failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() +
                    "Test Status Skipped", ExtentColor.YELLOW));
        }

    }

    @AfterClass(alwaysRun = true)
    public void close() {
        //Let's sign-out from amazon
        //Navigate to nav button on left
        jse.executeScript("window.scrollTo(0,0)");
        actions.moveToElement(nav.getNavElement(driver)).click().build().perform();
        //Scroll to bottom of nav
        //jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        actions.moveToElement(LoginPage.signout(driver)).click().build().perform();
        Assert.assertTrue(true, "Successfully Logged off");
        driver.close();
        extentReports.flush();
    }
}
