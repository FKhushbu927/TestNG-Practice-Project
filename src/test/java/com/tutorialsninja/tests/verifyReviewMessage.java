package com.tutorialsninja.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class verifyReviewMessage {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void verifyReviewMessages() {
        driver.findElement(By.linkText("iPhone")).click();
        driver.findElement(By.linkText("Reviews (0)")).click();
        driver.findElement(By.id("input-name")).sendKeys("Khushbu");
        driver.findElement(By.id("input-review")).sendKeys("very good Lorem ipsum dolor sit amet, elit.");
        //input[@value='3']

        WebElement element = driver.findElement(By.xpath("//input[@value='3']"));

        if (!(element.isSelected())) {
            element.click();
        } else {
            System.out.println("Checkbox is already selected");
        }

        driver.findElement(By.id("button-review")).click();
        String actualReviewMessage = "Thank you for your review. It has been submitted to the webmaster for approval.";
        String expectedReviewMessage = "Thank you for your review. It has been submitted to the webmaster for approval.";
        Assert.assertEquals(actualReviewMessage, expectedReviewMessage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
