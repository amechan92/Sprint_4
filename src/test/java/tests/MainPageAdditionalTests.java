package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import java.util.ArrayList;


import static org.junit.Assert.assertTrue;

public class MainPageAdditionalTests {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        // Перед началом теста
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", /*"--headless",*/ "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testYandexLink() {
        mainPage.clickYandexLink();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        assertTrue("Не открылась новая вкладка", tabs.size() > 1);
        driver.switchTo().window(tabs.get(1));
        assertTrue("Открылась не главная страница Яндекса", driver.getCurrentUrl().contains("yandex.ru"));

    }

    @Test
    public void testScooterLogoLink() {
        mainPage.clickOrderButtonHeader();

        mainPage.clickScooterLogoLink();
        assertTrue("Не вернулись на главную страницу", driver.getCurrentUrl().equals("https://qa-scooter.praktikum-services.ru/"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
