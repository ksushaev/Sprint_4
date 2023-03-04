import config.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import pages.OrderPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class NewOrderTest {
    WebDriver driver;
    private final String placeOfButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String days;


    public NewOrderTest(String placeOfButton, String name, String surname, String address, String phone, String date, String days) {
        this.placeOfButton = placeOfButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.days = days;
    }

    @Parameterized.Parameters
    public static Object[][] getInputsForOrder() {
        return new Object[][]{
                {"Верхняя кнопка", "Ксюша", "Никульшина", "Москва", "89765324566", "24.03.2023", "сутки"},
                {"Нижняя кнопка", "Катя", "Никулина", "Казань", "89765375436", "25.03.2023", "двое суток"},
        };
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ksenianikulsina/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(AppConfig.URL);
    }

    @Test
    public void makeNewOrder() {
        MainPage objOrderInTwoPlaces = new MainPage(driver);
        OrderPage objOrderPage = new OrderPage(driver);
        //выбираем верхнюю/нижнюю кнопку
        objOrderInTwoPlaces.clickOnOrderButton(placeOfButton);
        //заполняем все поля
        objOrderPage.writeNameInInput(name);
        objOrderPage.writeSurnameInInput(surname);
        objOrderPage.writeAddressInInput(address);
        //метро выбираем из выпадающего списка
        objOrderPage.chooseMetroStation();
        objOrderPage.whitePhoneInInput(phone);
        objOrderPage.clickOnFurther();
        objOrderPage.setButtonCookie();
        objOrderPage.chooseOnDateForDelivery(date);
        objOrderPage.chooseRentalPeriod(days);
        objOrderPage.pressOrderButtonFinish();
        //ждем да
        objOrderPage.pressPopupWithYes();
        //проверяем статус заказа
        objOrderPage.checkOrder();
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
