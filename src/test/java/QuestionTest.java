import config.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionTest {
    private WebDriver driver;
    private final int questionNumber;
    private final String expected;

    public QuestionTest(int questionNumber, String expected) {
        this.questionNumber = questionNumber;
        this.expected = expected;
    }

    static String[] expectedResult = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    @Parameterized.Parameters
    public static Object[][] getAnswerForQuestion() {
        return new Object[][]{
                {0, expectedResult[0]},
                {1, expectedResult[1]},
                {2, expectedResult[2]},
                {3, expectedResult[3]},
                {4, expectedResult[4]},
                {5, expectedResult[5]},
                {6, expectedResult[6]},
                {7, expectedResult[7]},
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(AppConfig.URL);
    }

    @Test
    public void checkFirstTextInImportantQuestions() {
        MainPage objFirstQuestion = new MainPage(driver);
        String actual = objFirstQuestion.scrollAndClickOnFirstQuestion(questionNumber);
        assertEquals("Неверный ответ на вопрос!", expected, actual);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
