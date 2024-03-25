package pages;

import org.openqa.selenium.*;


public class OrderPage {

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
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

    // Локатор для опции "Красносельская" в выпадающем списке
    private final By metroStationKrasnoselskaya = By.xpath("//div[text()='Красносельская']");

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
    private final By buttonOrder = By.cssSelector(".Order_Buttons__1xGrp > button.Button_Button__ra12g:not(.Button_Inverted__3IF-i)");



    // Заголовок шаг 3  "Хотите оформить заказ?"
    private final By titleStepThree = By.cssSelector(".Order_ModalHeader__3FDaJ");

    //Кнопка Подтвердить
    private final By buttonConfirm = By.cssSelector(".Order_Modal__YZ-d3 .Order_Buttons__1xGrp button:not(.Button_Inverted__3IF-i)");




    // Кнопка на Статусном экране  "Посмотреть статусс"
    private final By buttonViewStatus = By.cssSelector(".Order_NextButton__1_rCA .Button_Button__ra12g");

    //Кнопка "Принять все куки"
    private final By buttonCookieAccept = By.cssSelector(".App_CookieButton__3cvqF");






    // Методы

    // Метод для поиска элемента на странице по его локатору (селектору), очищает поле, если в нем уже что-то есть, и вводит новое значение
    public void fillInputField(By selector, String value) {
        WebElement element = driver.findElement(selector);
        element.clear();
        element.sendKeys(value);
    }

    //Метод ввода данных на первом шаге оформления заказа
    public void fillFormStep1(pages.Utils.FormData formData) {
        fillInputField(inputName, formData.getName());
        fillInputField(inputSurname, formData.getSurname());
        fillInputField(inputAddress, formData.getAddress());
        fillInputField(inputPhone, formData.getPhone());
    }

    //Метод ввода данных на втором шаге оформления заказа
    public void fillFormStep2(pages.Utils.FormData formData) {
        WebElement dateInput = driver.findElement(inputDate);
        dateInput.clear();
        dateInput.sendKeys(formData.getDeliveryDate());

        dateInput.sendKeys(Keys.ESCAPE);

        fillInputField(inputComment, formData.getCourierComment());
    }


    public OrderPage clickNextButton() {
        driver.findElement(buttonNext).click();
        return this;
    }

    // Метод проверки заголовка на шаге 1 оформления заказа
    public boolean istitleStepOne() {
        try {
            return driver.findElement(titleStepOne).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Метод проверки заголовка на шаге 3 оформления заказа
    public boolean isTitleStepThree() {
        try {
            return driver.findElement(titleStepThree).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Метод проверки кнопки Посмотреть статус заказа на статусном экране
    public boolean getButtonViewStatus() {
        try {
            return driver.findElement(buttonViewStatus).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    // Метод открывает выпадающий список станций метро и выбирает станцию "Черкизовская".
    public void selectMetroStationCherkizovskaya() {
        // Открыть dropdown
        driver.findElement(selectMetroStation).click();

        // Клик по элементу списка "Черкизовская"
        WebElement stationButton = driver.findElement(By.cssSelector("li.select-search__row[data-value='2'] > button"));
        stationButton.click();

    }

    //Метод выбора продолжительности периода
    public void selectRentalDuration() {
        // Клик по дропдауну для открытия списка опций
        WebElement dropdown = driver.findElement(dropdownDuration);
        dropdown.click();

        // Клик по опции "Сутки"
        WebElement option = driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='сутки']"));
        option.click();
    }

    //Метод активации чекбокса выбора цвета самоката - Черный
    public void selectScooterColorBlack() {
        WebElement checkBox = driver.findElement(checkBoxBlack);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    //Метод активации чекбокса выбора цвета самоката - Серый
    public void selectScooterColorGray() {
        WebElement checkBox = driver.findElement(checkBoxGray);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    //Метод клика по кнопке заказать
    public void clickOrderButton() {
        driver.findElement(buttonOrder).click();
    }

    //Метод клика по кнопке заказать
    public void clickButtonConfirm() {
        driver.findElement(buttonConfirm).click();
    }

    //Метод клика по кнопке Принять все куки

    public void clickButtonCookieAccept() {
        driver.findElement(buttonCookieAccept).click();
    }


}