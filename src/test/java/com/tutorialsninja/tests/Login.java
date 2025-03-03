package com.tutorialsninja.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class Login {

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("input-email")).sendKeys("fatemakhushbu9027@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("9876543210");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        System.out.println("login btn clicked");
       Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

       driver.quit();
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("input-email")).sendKeys(generateRandomEmailWithTimeStamp());
        driver.findElement(By.id("input-password")).sendKeys("12345454");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));

        driver.quit();
    }

    public String generateRandomEmailWithTimeStamp(){
        Date date = new Date();
        return date.toString().replace(" ","_").replace(":", "_")+ "@gmail.com";

    }
}
