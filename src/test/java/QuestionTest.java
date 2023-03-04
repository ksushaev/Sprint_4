import config.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class QuestionTest {
    private WebDriver driver;
    String[] expectedResult = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ksenianikulsina/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(AppConfig.URL);
    }

    @Test
    public void checkFirstTextInImportantQuestions() {
        MainPage objFirstQuestion = new MainPage(driver);
        String actual;
        String expected;

        for (int i = 0; i < expectedResult.length; i++) {
            objFirstQuestion.scrollAndClickOnFirstQuestion(i);
            actual = objFirstQuestion.getAnswerForFirstQuestion(i);
            expected = expectedResult[i];
            assertEquals("Неверный ответ на вопрос!", actual, expected);
        }
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
