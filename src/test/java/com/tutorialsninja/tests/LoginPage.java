package com.tutorialsninja.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;


    @Parameters("url")
    @BeforeMethod
    public void setUp(String url) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(url);
    }

    @Test(priority = 1)
    public void verifyLoginPageWithValidCredentials(){

        driver.findElement(By.xpath("//span[text()='My Account']")).click();

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("fatemakhushbu9027@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

      Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @Test(priority = 2)
    public void verifyLoginWithValidUserNameAndInvalidPassword(){

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("fatemakhushbu9027@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("98765432101233");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),"Warning: No match for E-Mail Address and/or Password.");


    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidUserNameAndValidPassword(){

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("9876543210");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),"Warning: No match for E-Mail Address and/or Password.");

    }

    @Test(priority = 4)
    public void verifyLoginPageWithInvalidCredentials(){
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("987654321032134");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),"Warning: No match for E-Mail Address and/or Password.");

    }

    @Test(priority = 5)
    public void verifyLoginPageWithEmptyCredentials(){
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("");
        driver.findElement(By.id("input-password")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText(),"Warning: No match for E-Mail Address and/or Password.");

    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
