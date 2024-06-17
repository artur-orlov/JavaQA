package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecondTask {
    static WebDriver driver = null;
    static WebDriverWait wait = null;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        WebElement cookies = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        cookies.click();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    @Order(1)
    public void checkWorkFieldAndContinue() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select__list']//p[text()='Услуги связи']"))).click();
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberField.sendKeys("297777777");
        WebElement serviceDropDown = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        serviceDropDown.sendKeys("1");
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='button button__default ']"));
        continueButton.click();
        
        Thread.sleep(5000);
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))));
        WebElement resultSum = driver.findElement(By.xpath("//div[@class='pay-description__cost']//span"));
        assertEquals("1.00 BYN", resultSum.getText());

        WebElement resultButtonSum = driver.findElement(By.xpath("//div[@class='card-page__card']//button"));
        assertEquals("Оплатить 1.00 BYN", resultButtonSum.getText());

        WebElement resultPhone = driver.findElement(By.xpath("//div[@class='payment-page__order-description pay-description']//span[@class='pay-description__text']"));
        assertEquals("Оплата: Услуги связи Номер:375297777777", resultPhone.getText());

        String expectedTitle = "Номер карты";
        WebElement phoneNumTitle = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']"));
        assertEquals(expectedTitle, phoneNumTitle.getText());
        String expectedValidity = "Срок действия";
        WebElement validateTitle = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']"));
        assertEquals(expectedValidity, validateTitle.getText());
        String expectedCVC = "CVC";
        WebElement cvcTitle = driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']"));
        assertEquals(expectedCVC, cvcTitle.getText());
        String expectedHolder = "Имя держателя (как на карте)";
        WebElement holderTitle = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']"));
        assertEquals(expectedHolder, holderTitle.getText());

        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='cards-brands ng-tns-c46-1']//img"));
        assertFalse(logos.isEmpty());
    }
}
