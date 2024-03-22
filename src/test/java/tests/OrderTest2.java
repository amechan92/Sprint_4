package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import pages.OrderPage;
import pages.Utils;

import static org.junit.Assert.assertTrue;

public class OrderTest2 {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/JetBrains/IntelliJ IDEA Community Edition 2023.3.2/plugins/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrderFormFilling() {
        // Переход к форме заказа
        mainPage.clickOrderButtonHeader();

        // Проверка, что URL соответствует ожидаемому
        Assert.assertEquals("URL страницы не соответствует ожидаемому", "https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());

        // Проверка наличия заголовка на странице
        Assert.assertTrue("Заголовок 'Для кого самокат' не найден на странице", orderPage.istitleStepOne());

        // Получение тестовых данных
        Utils.FormData formData = Utils.dataSet2();

        // Используем значения из Utils для заполнения формы 1 шаг
        orderPage.fillFormStep1(formData);

        // Выбор станции метро "Черкизовская"
        orderPage.selectMetroStationCherkizovskaya();

        // Нажатие на кнопку "Далее"
        orderPage.clickNextButton();

        //Используем значения из Utils для заполнения формы 2 шаг
        orderPage.fillFormStep2(formData);

        //Выбор продолжительности аренды
        orderPage.selectRentalDuration();

        //Активация чекбокса
        orderPage.selectScooterColorGray();

        //Нажатие кнопки Заказать
        orderPage.clickOrderButton();

        // Проверка наличия заголовка на странице
        Assert.assertTrue("Заголовок 'Хотите оформить заказ?' не найден на странице", orderPage.isTitleStepThree());

        //Клик по кноке Подтвердить("Да")
        orderPage.clickButtonConfirm();

        //Проверка статуса заказа
        Assert.assertTrue("Кнопка 'Посмотреть статус' отсутствует на странице", orderPage.getButtonViewStatus());


    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
