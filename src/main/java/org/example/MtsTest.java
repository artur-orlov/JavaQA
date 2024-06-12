package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsTest {
    static WebDriver driver = null;
    static WebDriverWait wait = null;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Artorius/Downloads/chromedriver-win64/chromedriver.exe");
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
    public void testCheckNameBlock() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/h2")));
        WebElement blockTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, blockTitle.getText());
    }

    @Test
    @Order(2)
    public void testCheckIsLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__partners']//img")));
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        assertFalse(logos.isEmpty());
    }

    @Test
    @Order(3)
    public void testCheckWorkLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/a")));
        WebElement moreInfoLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        moreInfoLink.click();
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    @Order(4)
    public void testCheckWorkFieldAndContinue() {
        driver.findElement(By.xpath("//a[@class='page-header__logo']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='connection-phone']")));
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement serviceDropDown = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='button button__default ']"));
        phoneNumberField.sendKeys("297777777");
        Select serviceDropdownSelect = new Select(serviceDropDown);
        serviceDropdownSelect.selectByVisibleText("Услуги связи");
        continueButton.click();
    }
}
