package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstTask {
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
    public void checkFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select__header']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select__list']//p[text()='Услуги связи']"))).click();
        String expectedTitle = "Номер телефона";
        WebElement phoneNumTitle = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        String expectedSumTitle = "Сумма";
        WebElement sumTitle = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        String expectedEmailTitle = "E-mail для отправки чека";
        WebElement emailTitle = driver.findElement(By.xpath("//input[@id='connection-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select__header']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select__list']//p[text()='Домашний интернет']"))).click();
        expectedTitle = "Номер абонента";
        phoneNumTitle = driver.findElement(By.xpath("//input[@id='internet-phone']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        expectedSumTitle = "Сумма";
        sumTitle = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        expectedEmailTitle = "E-mail для отправки чека";
        emailTitle = driver.findElement(By.xpath("//input[@id='internet-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select__header']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select__list']//p[text()='Рассрочка']"))).click();
        expectedTitle = "Номер счета на 44";
        phoneNumTitle = driver.findElement(By.xpath("//input[@id='score-instalment']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        expectedSumTitle = "Сумма";
        sumTitle = driver.findElement(By.xpath("//input[@id='instalment-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        expectedEmailTitle = "E-mail для отправки чека";
        emailTitle = driver.findElement(By.xpath("//input[@id='instalment-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select__header']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select__list']//p[text()='Задолженность']"))).click();
        expectedTitle = "Номер счета на 2073";
        phoneNumTitle = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        expectedSumTitle = "Сумма";
        sumTitle = driver.findElement(By.xpath("//input[@id='arrears-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        expectedEmailTitle = "E-mail для отправки чека";
        emailTitle = driver.findElement(By.xpath("//input[@id='arrears-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));
    }
    @Test
    @Order(2)
    public void checkWorkFieldAndContinue() {
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='select__list']//p[text()='Услуги связи']"))).click();
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberField.sendKeys("297777777");
        WebElement serviceDropDown = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        serviceDropDown.sendKeys("1");
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='button button__default ']"));
        continueButton.click();
    }
}
