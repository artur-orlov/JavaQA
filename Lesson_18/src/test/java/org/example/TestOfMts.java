package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOfMts {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        acceptCookies();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка надписей в незаполненных полях \"Услуги связи\"")
    @Description("Проверка надписей в незаполненных полях раздела \"услуги связи\"")
    public void testOfConnectionServiceEmptyFields() {
        selectService("Услуги связи");

        String expectedTitle = "Номер телефона";
        WebElement phoneNumTitle = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        String expectedSumTitle = "Сумма";
        WebElement sumTitle = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        String expectedEmailTitle = "E-mail для отправки чека";
        WebElement emailTitle = driver.findElement(By.xpath("//input[@id='connection-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписей в незаполненных полях \"Домашний интернет\"")
    @Description("Проверка надписей в незаполненных полях раздела \"Домашний интернет\"")
    public void testOfInternetEmptyFields() {
        selectService("Домашний интернет");

        String expectedTitle = "Номер абонента";
        WebElement phoneNumTitle = driver.findElement(By.xpath("//input[@id='internet-phone']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        String expectedSumTitle = "Сумма";
        WebElement sumTitle = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        String expectedEmailTitle = "E-mail для отправки чека";
        WebElement emailTitle = driver.findElement(By.xpath("//input[@id='internet-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписей в незаполненных полях \"Рассрочка\"")
    @Description("Проверка надписей в незаполненных полях раздела \"Рассрочка\"")
    public void testOfInstalmentEmptyFields() {
        selectService("Рассрочка");

        String expectedTitle = "Номер счета на 44";
        WebElement phoneNumTitle = driver.findElement(By.xpath("//input[@id='score-instalment']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        String expectedSumTitle = "Сумма";
        WebElement sumTitle = driver.findElement(By.xpath("//input[@id='instalment-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        String expectedEmailTitle = "E-mail для отправки чека";
        WebElement emailTitle = driver.findElement(By.xpath("//input[@id='instalment-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписей в незаполненных полях \"Задолженность\"")
    @Description("Проверка надписей в незаполненных полях раздела \"Задолженность\"")
    public void testOfArrearsEmptyFields() {
        selectService("Задолженность");

        String expectedTitle = "Номер счета на 2073";
        WebElement phoneNumTitle = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        assertEquals(expectedTitle, phoneNumTitle.getAttribute("placeholder"));
        String expectedSumTitle = "Сумма";
        WebElement sumTitle = driver.findElement(By.xpath("//input[@id='arrears-sum']"));
        assertEquals(expectedSumTitle, sumTitle.getAttribute("placeholder"));
        String expectedEmailTitle = "E-mail для отправки чека";
        WebElement emailTitle = driver.findElement(By.xpath("//input[@id='arrears-email']"));
        assertEquals(expectedEmailTitle, emailTitle.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка заполнения полей раздела \"Услуги связи\" и корректности отображения в окне после кнопки продолжить" +
            "а также проверка наличия иконок платежных систем")
    @Description("Проверка заполнения полей раздела \"Услуги связи\" и корректности отображения в окне после кнопки продолжить" +
            "а также проверка наличия иконок платежных систем")
    public void testOfConnectionFields() {
        selectService("Услуги связи");

        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberField.sendKeys("297777777");
        WebElement serviceDropDown = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        serviceDropDown.sendKeys("11");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']/button[@type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']"))));

        WebElement resultPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Оплата:')]")));
        assertEquals("Оплата: Услуги связи Номер:375297777777", resultPhone.getText());

        WebElement resultButtonSum = driver.findElement(By.xpath("//*[text()=' Оплатить  11.00 BYN ']"));
        assertEquals("Оплатить 11.00 BYN", resultButtonSum.getText());

        checkCardInputFields();

        checkPaymentIcons();


        driver.get("https://www.mts.by/");
    }

    private void selectService(String serviceName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select__header']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + serviceName + "']"))).click();
    }

    private void checkCardInputFields() {
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
    }

    private void checkPaymentIcons() {
        WebElement mastercardLogo = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        assertTrue(mastercardLogo.isDisplayed(), "Иконка MasterCard не отображается");

        WebElement visaLogo = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        assertTrue(visaLogo.isDisplayed(), "Иконка Visa не отображается");

        WebElement belcartLogo = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        assertTrue(belcartLogo.isDisplayed(), "Иконка Белкард не отображается");

        WebElement mirLogo = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));
        assertTrue(mirLogo.isDisplayed(), "Иконка Мир не отображается");
    }

    private void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.xpath("//button[@class='btn btn_black cookie__ok']")));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
            }
        } catch (Exception e) {
            System.out.println("Всплывающее окно с файлами cookie не найдено или недоступно для клика.");
        }
    }
}
