package com.tutorialsninja.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeTestNGAssertions {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test(priority = 1)
    public void sampleMethod() {

        String actualResult = driver.getTitle();
        String expectedResult = "Your Store";
        System.out.println(actualResult);

        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test(priority = 2)
    public void sampleMethod2() {
        String str1 = "Khushbu";
        String str2 = "Khushboo";
        Assert.assertNotEquals(str1, str2);

    }

    @Test(priority = 3)
    public void sampleMethod3() {
//        String str = "My name is Khushbu";
//
//        Assert.assertTrue(str.contains("Khushbu"));

        driver.findElement(By.name("search")).sendKeys("HP", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

    }

    @Test(priority = 4)
    public void sampleMethod4() {

        String str = null;
        Assert.assertNotNull(str);
    }

    @Test(priority = 5)
    public void sampleMethod5() {
        if (driver.findElement(By.linkText("Canon EOS 5D")).isDisplayed()) {
            Assert.fail("Canon EOS is displayed");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
