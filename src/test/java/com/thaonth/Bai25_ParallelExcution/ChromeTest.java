package com.thaonth.Bai25_ParallelExcution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class ChromeTest {

    @Test
    public void ChromeTestMethod01() {
        System.out.println("Initializing the Google Chrome Driver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();
        driver.quit();
    }

    @Test
    public void ChromeTestMethod02() {
        System.out.println("Initializing the Google Chrome Driver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='API Testing']")).click();
        driver.quit();
    }

    @Test
    public void ChromeTestMethod03() {
        System.out.println("Initializing the Google Chrome Driver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Mobile Testing']")).click();
        driver.quit();
    }
    @Test
    public void ChromeTestMethod04() {
        System.out.println("Initializing the Google Chrome Driver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the chrome driver
        System.out.println("The thread ID for Chrome is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Desktop Testing']")).click();
        driver.quit();
    }

}