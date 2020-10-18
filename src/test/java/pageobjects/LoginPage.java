package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static WebElement element = null;
   
    public static WebElement log(WebDriver Driver) {
        element = Driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        if (element.isDisplayed()) {
            return element;
        }
        return null;
    }

    public static WebElement signIn(WebDriver driver) {
        element = driver.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
        return element;
    }

    public static WebElement btn_LogIn(WebDriver driver) {
        element = driver.findElement(By.id("ap_email"));
        return element;

    }

    public static WebElement cont(WebDriver driver) {
        element = driver.findElement(By.className("a-button-input"));
        return element;
    }

    public static WebElement password(WebDriver driver) {
        element = driver.findElement(By.id("ap_password"));
        return element;
    }

    public static WebElement login(WebDriver driver) {
        element = driver.findElement(By.id("signInSubmit"));
        return element;
    }

    public static String getText(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[text()='Hello, Nameesha']"));
        return element.getText();
    }

    public static WebElement signout(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[text()='Sign Out']"));
        if (element.isDisplayed()) {
            return element;
        }
        return null;
    }

}
