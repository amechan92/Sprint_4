package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import pages.OrderPage;
import pages.Utils;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CombinedOrderTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;
    private Utils.FormData formData;
    private boolean colorBlack; // true for black, false for gray

    // Конструктор для параметризированных значений
    public CombinedOrderTest(Utils.FormData formData, boolean colorBlack) {
        this.formData = formData;
        this.colorBlack = colorBlack;
    }

    // Параметры для тестов
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                { Utils.dataSet1(), true },
                { Utils.dataSet2(), false }
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrderFormFilling() {
        mainPage.clickOrderButtonHeader();
        assertEquals("URL страницы не соответствует ожидаемому", "https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());
        assertTrue("Заголовок 'Для кого самокат' не найден на странице", orderPage.istitleStepOne());

        orderPage.clickButtonCookieAccept();
        orderPage.fillFormStep1(formData);
        orderPage.selectMetroStationCherkizovskaya();
        orderPage.clickNextButton();
        orderPage.fillFormStep2(formData);
        orderPage.selectRentalDuration();

        if (colorBlack) {
            orderPage.selectScooterColorBlack();
        } else {
            orderPage.selectScooterColorGray();
        }

        orderPage.clickOrderButton();
        assertTrue("Заголовок 'Хотите оформить заказ?' не найден на странице", orderPage.isTitleStepThree());
        orderPage.clickButtonConfirm();
        assertTrue("Кнопка 'Посмотреть статус' отсутствует на странице", orderPage.getButtonViewStatus());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
