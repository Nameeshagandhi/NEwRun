package com.ParallelRun;

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Base {
    //Declare the driver object for WebDriver class
    public WebDriver driver;
    public JavascriptExecutor jse;
    public Actions actions;
    public ChromeOptions options;

    Properties prop;
    @BeforeClass
    public void initProperty(){
        String pathto=System.getProperty("user.dir")+"/amazon.properties";
        File file = new File(pathto);
        prop= new Properties();
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            //load properties file
            prop.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    options=new ChromeOptions();
    Map<String, Object> prefs=new HashMap<>();
    prefs.put("credentials_enable_service",false);
    prefs.put("profile.password_manager_enabled",false);
    prefs.put("download.default_directory","path");
    options.setExperimentalOption("prefs", prefs);
    options.setExperimentalOption("useAutomationExtension",false);
    options.setExperimentalOption("excludeSwitches",
    Collections.singletonList("enable-automation"));
    options.addArguments("disable-infobars");
    options.addArguments("disable-extensions");
    options.addArguments("disable-browser-side-navigation");
    options.setCapability(ChromeOptions.CAPABILITY, options);

    //Opening up the chrome browser
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    //Go to URL
    driver.get(prop.getProperty("URL"));
        Reporter.log("Amazon URL is used for testing");
    driver.manage().timeouts().implicitlyWait(60, SECONDS);
    actions = new Actions(driver);
    jse = (JavascriptExecutor) driver;

   // Mouse hover sign-in
    WebElement login=driver.findElement(By.xpath(prop.getProperty("login")));
   actions.moveToElement(login).perform();
   //Click on sign-in
    WebElement signin=driver.findElement(By.xpath(prop.getProperty("sign_in")));
    actions.moveToElement(signin).click().build().perform();
    //Enter email id
     WebElement id=driver.findElement(By.id(prop.getProperty("email")));
        id.sendKeys(prop.getProperty("id"));
        //Click on Continue button
        WebElement conti=driver.findElement(By.className(prop.getProperty("button_name")));
        actions.moveToElement(conti).click().build().perform();
        //Enter the password
        WebElement pswd=driver.findElement(By.id(prop.getProperty("pswd")));
        pswd.sendKeys(prop.getProperty("password"));
        //Click on Login button
        WebElement btn=driver.findElement(By.id(prop.getProperty("SIS")));
        actions.moveToElement(btn).click().build().perform();
    }

    @AfterClass
    public void close(){
        driver.close();
        Reporter.log("Driver closed after testing");
    }

}
