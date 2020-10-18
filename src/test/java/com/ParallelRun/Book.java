package com.ParallelRun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Book extends Base{
    @Test
    public void bookshelf(){
        WebElement nav=driver.findElement(By.id("nav-hamburger-menu"));
        actions.moveToElement(nav).click().build().perform();
        WebDriverWait bookwait=new WebDriverWait(driver,30);
        WebElement book=driver.findElement(By.xpath(prop.getProperty("book")));
        bookwait.until(ExpectedConditions.visibilityOf(book));
        jse.executeScript("arguments[0].scrollIntoView(true)", book);
        actions.moveToElement(book).click().build().perform();
        WebElement allBook=driver.findElement(By.xpath(prop.getProperty("allBook")));
        jse.executeScript("arguments[0].scrollIntoView(true)", allBook);
        actions.moveToElement(allBook).click().build().perform();

      String expectTitle="Book Store Online : Buy Books Online at Best Prices in India | Books Shopping @ Amazon.in";
     // Assert.assertEquals(title,expectTitle);
        String title= driver.getTitle();
        System.out.println("Title of the page : "+title);
      //  Assert.assertEquals(title,expectTitle,title);

    }
}
