package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    String[] locatorOfQuestion = {
            "accordion__heading-0", // первый вопрос в разделе о важном
            "accordion__heading-1", // второй вопрос в разделе о важном
            "accordion__heading-2", // третий вопрос в разделе о важном
            "accordion__heading-3", // четвертый вопрос в разделе о важном
            "accordion__heading-4", // пятый вопрос в разделе о важном
            "accordion__heading-5", // шестой вопрос в разделе о важном
            "accordion__heading-6", // седьмой вопрос в разделе о важном
            "accordion__heading-7", // восьмой вопрос в разделе о важном
    };

    String[] locatorOfAnswer = {
            "accordion__panel-0", // первый ответ на вопрос
            "accordion__panel-1", // второй ответ на вопрос
            "accordion__panel-2", // третий ответ на вопрос
            "accordion__panel-3", // четвертый ответ на вопрос
            "accordion__panel-4", // пятый ответ на вопрос
            "accordion__panel-5", // шестой ответ на вопрос
            "accordion__panel-6", // седьмой ответ на вопрос
            "accordion__panel-7", // восьмой ответ на вопрос
    };

    private final By orderButtonInTop = By.className("Button_Button__ra12g");

    private final By orderButtonInFoot = By.className("Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //по номеру вопроса выбираем нужный, кликаем на него, получаем соответствующий номеру текст ответа
    public String scrollAndClickOnFirstQuestion(int questionNumber) {
        if (questionNumber == 1) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[0]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[0])).getText();
        } else if (questionNumber == 2) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[1]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[1])).getText();
        } else if (questionNumber == 3) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[2]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[2])).getText();
        } else if (questionNumber == 4) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[3]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[3])).getText();
        } else if (questionNumber == 5) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[4]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[4])).getText();
        } else if (questionNumber == 6) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[5]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[5])).getText();
        } else if (questionNumber == 7) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[6]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[6])).getText();
        } else if (questionNumber == 8) {
            WebElement element = driver.findElement(By.id(locatorOfQuestion[7]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            return driver.findElement(By.id(locatorOfAnswer[7])).getText();
        } else {
            return "Ошибка, что-то с вопросом";
        }
    }

    public void clickOnOrderButton(String placeOfButton) {
        if (placeOfButton.equals("Верхняя кнопка")) {
            driver.findElement(orderButtonInTop).click();
        } else if (placeOfButton.equals("Нижняя кнопка")) {
            WebElement element = driver.findElement(orderButtonInFoot);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }
}