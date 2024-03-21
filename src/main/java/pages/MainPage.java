package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для клика по заголовку аккордеона
    public MainPage clickAccordionItemHeading(int itemIndex) {
        WebElement heading = driver.findElement(By.id("accordion__heading-" + itemIndex));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", heading);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        heading.click();
        return this;
    }

    // Метод для проверки, раскрыт ли аккордеон
    public boolean isAccordionItemExpanded(int itemIndex) {
        By headingSelector = By.id("accordion__heading-" + itemIndex);
        WebElement heading = driver.findElement(headingSelector);
        return heading.getAttribute("aria-expanded").equals("true");
    }

    // Метод для получения текста из панели аккордеона
    public String getAccordionItemPanelText(int itemIndex) {
        By panelSelector = By.id("accordion__panel-" + itemIndex);
        WebElement panel = driver.findElement(panelSelector);
        return panel.getText();
    }

    // Метод для проверки текста внутри раскрытой панели аккордеона
    public boolean verifyAccordionItemPanelTextContains(int itemIndex, String expectedText) {
        By panelSelector = By.id("accordion__panel-" + itemIndex);
        WebElement panel = driver.findElement(panelSelector);
        return panel.getText().contains(expectedText);
    }

    // Метод для клика по кнопке Яндекс
    public MainPage clickYandexLink() {
        return click(By.cssSelector(".Header_LogoYandex__3TSOI"));
    }

    // Метод для клика по кнопке Самоката
    public MainPage clickScooterLogoLink() {
        return click(By.cssSelector(".Header_LogoScooter__3lsAR"));
    }

    //Метод для клика по кнопке Заказать в шапке сайта
    public MainPage clickOrderButtonHeader() {
        return click(By.cssSelector(".Button_Button__ra12g"));
    }

    //Метод для клика по кнопке Заказать в теле сайта
    public MainPage clickOrderButtonBody(){
        WebElement button = driver.findElement(By.xpath("//div[contains(@class, 'Home_FinishButton__1_cWm')]//button[contains(text(), 'Заказать')]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        button.click();
        return this;
    }


    private MainPage click(By selector) {
        WebElement link = driver.findElement(selector);
        link.click();
        return this;
    }
}


