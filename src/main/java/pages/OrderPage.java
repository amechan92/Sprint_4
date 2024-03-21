package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class OrderPage {

    private final WebDriver driver;
    // Локаторы

    // Заголовок шаг 1 "Для кого самокат"
    private final By titleStepOne = By.cssSelector(".Order_Header__BZXOb");

    // Поле ввода Имя
    private final By inputName = By.cssSelector("input[placeholder='* Имя']");

    // Поле ввода Фамилия
    private final By inputSurname = By.cssSelector("input[placeholder='* Фамилия']");

    // Поле ввода Адрес
    private final By inputAddress = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");

    // Выпадающий список Станция метро
    private final By selectMetroStation = By.cssSelector(".select-search__input");

    // Поле ввода Телефон
    private final By inputPhone = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка Далее
    private final By buttonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");



    // Заголовок шаг 2 "Про аренду"
    private final By titleStepTwo = By.cssSelector(".Order_Header__BZXOb");

    // Поле ввода Дата доставки
    private final By inputDate = By.cssSelector("input[placeholder='* Когда привезти самокат']");

    // Дропдаун Срок аренды
    private final By dropdownDuration = By.cssSelector(".Dropdown-control");

    // Чекбокс цвет самоката Черный
    private final By checkBoxBlack = By.cssSelector("input#black");

    // Чекбокс цвет самоката Серый
    private final By checkBoxGray = By.cssSelector("input#grey");

    // Поле ввода Комментарий для курьера
    private final By inputComment = By.cssSelector("input[placeholder='Комментарий для курьера']");

    // Кнопка Заказать
    private final By buttonOrder = By.cssSelector(".Button_Button__ra12g:not(.Button_Inverted__3IF-i)");



    // Заголовок шаг 3  "Хотите оформить заказ?"
    private final By titleStepThree = By.cssSelector(".Order_ModalHeader__3FDaJ");

    //Кнопка Подтвердить
    private final By buttonConfirm = By.xpath("//div[contains(@class, 'Order_Modal__YZ-d3')]//button[text()='Да']");



    // Заголовок Статусный экран  "Заказ оформлен"
    private final By titleStatusScreen = By.cssSelector(".Order_ModalHeader__3FDaJ");



    //Методы

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