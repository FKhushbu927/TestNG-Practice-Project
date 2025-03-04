package com.tutorialsninja.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class verifyRegistrationForm {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void verifyRegistration(){

        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Khushbu");
        driver.findElement(By.id("input-lastname")).sendKeys("Jannat");
        //input-email

        driver.findElement(By.id("input-email")).sendKeys("fatemakhushbu9027@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("89645365");

        driver.findElement(By.id("input-password")).sendKeys("123456789");
        driver.findElement(By.id("input-confirm")).sendKeys("123456789");

        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
