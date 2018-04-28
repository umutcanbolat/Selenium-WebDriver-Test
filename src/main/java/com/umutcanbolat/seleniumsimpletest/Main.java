/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umutcanbolat.seleniumsimpletest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author umut
 */
public class Main {

    /*
    browser:
    0 - Google chrome
    1 - Mozilla Firefox
     */
    public static int browser = 0;

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            switch (browser) {
                case 0:
                    System.setProperty("webdriver.chrome.driver", "./chromedriver");
                    driver = new ChromeDriver();
                    break;

                case 1:
                    System.setProperty("webdriver.gecko.driver", "./geckodriver");
                    driver = new FirefoxDriver();
                    break;
                default:

                    System.setProperty("webdriver.chrome.driver", "./chromedriver");
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Adrese git
            driver.navigate().to("http://www.calculator.net/");

            // Tarayıcı boyutlarını manuel belirle
            // driver.manage().window().setSize(new Dimension(600,600));
            
            // Tarayıcıyı tam ekran yap
            driver.manage().window().maximize();

            // Math Calculators a tıkla
            driver.findElement(By.xpath("//*[@id=\"homelistdiv\"]/table/tbody/tr/td[3]/div[2]/a")).click();
            
            // Percent Calculators a tıkla
            driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[3]/a")).click();

            // İlk kutuya 10 gir
            driver.findElement(By.id("cpar1")).sendKeys("10");

            // ikinici kutuya 500 gir
            driver.findElement(By.id("cpar2")).sendKeys("500");

            // Calculate butonuna tıkla
            driver.findElement(By.xpath("//*[@id=\"content\"]/table[1]/tbody/tr[2]/td/input[2]")).click();

            // Sonucu al
            String result
                    = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();

            // Sonucu ekrana bas
            System.out.println(" The Result is " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (driver != null) {
                // Driver ı kapat
                driver.close();
            }
        }
    }
}
