package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nav {

    private static WebElement element=null;

    public static WebElement getNavElement(WebDriver Driver){
        element= Driver.findElement(By.id("nav-hamburger-menu"));
        if (element.isDisplayed()) {
            return element;// Condition passed
        }
        return null;
    }
}
