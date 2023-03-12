package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    //задаем вопросы
    String locatorOfQuestion = "accordion__heading-";

    //получаем ответы
    String locatorOfAnswer = "accordion__panel-";

    private final By orderButtonInTop = By.className("Button_Button__ra12g");
    private final By orderButtonInFoot = By.className("Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод получает номер вопроса, ищет, кликает, получает ответ
    public String scrollAndClickOnFirstQuestion(int questionNumber) {
        WebElement element = driver.findElement(By.id(locatorOfQuestion + questionNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return driver.findElement(By.id(locatorOfAnswer + questionNumber)).getText();
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