package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {
    private final WebDriver driver;

    // Локаторы

    //Ссылка на Яндекс
    private final By yandexLink = By.cssSelector(".Header_LogoYandex__3TSOI");
    //Ссылка на главную Самоката
    private final By scooterLogoLink = By.cssSelector(".Header_LogoScooter__3lsAR");
    //Кнопка Заказать в шапке сайта
    private final By orderButtonHeader = By.cssSelector(".Button_Button__ra12g");
    //Кнопка Заказать в теле сайта
    private final By orderButtonBody = By.xpath("//div[contains(@class, 'Home_FinishButton__1_cWm')]//button[contains(text(), 'Заказать')]");

    //Аккордион(первая  вкладка)
    private final String accordionItemHeadingBase = "accordion__heading-";
    //Базовая часть ID для вкладки аккордиона
    private final String accordionItemPanelBase = "accordion__panel-";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод раскрытия вкладки первого элемента аккордиона с прокруткой страницы
    public MainPage clickAccordionItemHeading(int itemIndex) {
        WebElement heading = driver.findElement(By.id(accordionItemHeadingBase + itemIndex));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", heading);
        sleep(500); // Задержка
        heading.click();
        return this;
    }

    //Метод проверки раскрытия вкладки аккордиона
    public boolean isAccordionItemExpanded(int itemIndex) {
        WebElement heading = driver.findElement(By.id(accordionItemHeadingBase + itemIndex));
        return heading.getAttribute("aria-expanded").equals("true");
    }

    //Метод получения текста аккордиона для проверки
    public String getAccordionItemPanelText(int itemIndex) {
        WebElement panel = driver.findElement(By.id(accordionItemPanelBase + itemIndex));
        return panel.getText();
    }

    //Метод проверки текста из аккордиона
    public boolean verifyAccordionItemPanelTextContains(int itemIndex, String expectedText) {
        WebElement panel = driver.findElement(By.id(accordionItemPanelBase + itemIndex));
        return panel.getText().contains(expectedText);
    }

    //Метод Клика по логотипу Яндекса
    public MainPage clickYandexLink() {
        return click(yandexLink);
    }

    //Метод Клика по логотипу Самоката
    public MainPage clickScooterLogoLink() {
        return click(scooterLogoLink);
    }

    //Метод раскрытия первой вкладки аккордиона
    public MainPage clickOrderButtonHeader() {
        return click(orderButtonHeader);
    }

    //Метод раскрытия вкладки аккордиона с прокруткой до элемента
    public MainPage clickOrderButtonBody() {
        WebElement button = driver.findElement(orderButtonBody);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        sleep(500); // Задержка
        button.click();
        return this;
    }

    //Метод Клик
    private MainPage click(By selector) {
        WebElement link = driver.findElement(selector);
        link.click();
        return this;
    }

    // Вспомогательный метод для задержки
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
