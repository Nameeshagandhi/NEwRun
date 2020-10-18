package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EchoPage {
    private static WebElement element;
    private static String title;
    private static String productTitle;

    public static WebElement getEcho(WebDriver driver) {

        element = driver.findElement(By.xpath("//div[text()='Echo & Alexa']"));
        if (element.isDisplayed()) {
            return element;// Condition passed
        }
        return null;
    }

    public static WebElement getEcho8(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[text()=' Echo Show 8']"));
        if (element.isDisplayed()) {
            return element;// Condition passed
        }
        return null;
    }

    public String getTitle(WebDriver driver) {
        title = driver.getCurrentUrl();
        return title;
    }

    public static String verifyTitle(WebDriver driver) {
        productTitle = driver.findElement(By.id("productTitle")).getText();
        if (productTitle.contains("Introducing Echo Show 8")) {
            return productTitle;
        }
        return null;

    }

    public static WebElement productTitle(WebDriver driver) {
        element = driver.findElement(By.id("productTitle"));
        return element;
    }

}
