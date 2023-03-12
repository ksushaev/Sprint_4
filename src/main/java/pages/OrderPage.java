package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OrderPage {

    WebDriver driver;

    //Поле "Имя" в заказе
    private final By orderName = By.xpath(".//input[@placeholder='* Имя']");

    //Поле "Фамилия" в заказе
    private final By orderSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле "Адрес" в заказе
    private final By orderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле "Станция метро" в заказе
    private final By orderMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //выпадающий список метро
    private final By metroStations = By.className("select-search__select");

    //Поле "Телефон для курьера" в заказе
    private final By orderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопки принять куки
    private final By buttonCookie = By.id("rcc-confirm-button");

    //Кнопка "Далее"
    private final By buttonFurther = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    //Когда привезти самокат
    private final By dateForDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Срок аренды
    private final By rentalPeriod = By.className("Dropdown-control");

    //Кнопка "Заказать"
    private final By orderButtonOnOrderPage = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    //Кнопка "Да"
    private final By buttonYes = By.xpath(".//button[text()='Да']");

    //Посмотреть статус
    private final By buttonViewStatus = By.xpath(".//button[text()='Посмотреть статус']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //заполняем поле Имя
    public void writeNameInInput(String name) {
        driver.findElement(orderName).sendKeys(name);
    }

    //Заполняем поле Фамилия
    public void writeSurnameInInput(String surname) {
        driver.findElement(orderSurname).sendKeys(surname);
    }

    //Заполняем поле Адрес
    public void writeAddressInInput(String address) {
        driver.findElement(orderAddress).sendKeys(address);
    }

    //выбираем станцию метро
    public void chooseMetroStation() {
        WebElement nameOfMetro = driver.findElement(orderMetroStation);
        nameOfMetro.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(metroStations));
        nameOfMetro.sendKeys(Keys.ARROW_DOWN);
        nameOfMetro.sendKeys(Keys.ENTER);
    }

    //Заполняем поле Телефон
    public void whitePhoneInInput(String phone) {
        driver.findElement(orderPhone).sendKeys(phone);
    }

    //Принимаем куки
    public void setButtonCookie() {
        driver.findElement(buttonCookie).click();
    }

    //Нажимаем кнопку "Далее"
    public void clickOnFurther() {
        new WebDriverWait(driver, 5);
        driver.findElement(buttonFurther).click();
    }

    //Заполняем дату получения
    public void chooseOnDateForDelivery(String date) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(dateForDelivery));
        WebElement writeDate = driver.findElement(dateForDelivery);
        writeDate.sendKeys(date);
        writeDate.sendKeys(Keys.ENTER);
    }

    //заполняем срок аренды
    public void chooseRentalPeriod(String days) {
        WebElement rental = driver.findElement(rentalPeriod);
        rental.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(rentalPeriod));
        WebElement daysForRent = driver.findElement(By.xpath(".//*[text()='" + days + "']"));
        daysForRent.click();
    }

    //нажимаем кнопку "Заказать"
    public void pressOrderButtonFinish() {
        driver.findElement(orderButtonOnOrderPage).click();
    }

    //ждем загрузку окна с подтверждением
    public void pressPopupWithYes() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        driver.findElement(buttonYes).click();
    }

    //проверяем появление попапа с проверкой статуса
    public void checkOrder() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonViewStatus));
        driver.findElement(buttonViewStatus).isEnabled();
    }

}
