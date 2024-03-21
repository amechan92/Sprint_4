package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class OrderTest2 {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Перед началом теста
        /*WebDriverManager.chromedriver().setup();*/
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/JetBrains/IntelliJ IDEA Community Edition 2023.3.2/plugins/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", /*"--headless",*/ "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testOrderButtonLeadsToCorrectPage() {
        // Клик по кнопке "Заказать" в теле сайта
        mainPage.clickOrderButtonBody();
        // Проверка, что URL соответствует ожидаемому
        Assert.assertEquals("URL страницы не соответствует ожидаемому", "https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());

        // Проверка наличия заголовка на странице
        WebElement header = driver.findElement(By.xpath("//div[contains(text(), 'Для кого самокат')]")); // Заменить икспас на локатор со страницы Ордерпейдж
        assertTrue("Заголовок 'Для кого самокат' не найден на странице", header.isDisplayed());
    }

    @After
    public void tearDown() {
        // Закрытие браузера после выполнения теста
        if (driver != null) {
            driver.quit();
        }
    }
}