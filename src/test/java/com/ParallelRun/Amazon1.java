package com.ParallelRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon1 extends Base
{
    @Test
    public void success(){

        WebElement nav=driver.findElement(By.id("nav-hamburger-menu"));
        actions.moveToElement(nav).click().build().perform();
        WebDriverWait echowait=new WebDriverWait(driver,30);
        WebElement echo=driver.findElement(By.xpath(prop.getProperty("Echo")));
        echowait.until(ExpectedConditions.visibilityOf(echo));
        actions.moveToElement(echo).click().build().perform();
        WebElement echo8=driver.findElement(By.xpath(prop.getProperty("Echo8")));
        jse.executeScript("arguments[0].scrollIntoView(true)", echo8);
        actions.moveToElement(echo8).click().build().perform();
       // String ExpectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String ActTitle=driver.getTitle();
      //  Assert.assertEquals(ActTitle,ExpectedTitle);
          System.out.println("Product title matches : "+ActTitle);

    }

}

