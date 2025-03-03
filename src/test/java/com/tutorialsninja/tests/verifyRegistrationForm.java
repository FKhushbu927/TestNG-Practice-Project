package com.tutorialsninja.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class verifyRegistrationForm {


    @Test
    public void verifyRegistration(){
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

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
}
