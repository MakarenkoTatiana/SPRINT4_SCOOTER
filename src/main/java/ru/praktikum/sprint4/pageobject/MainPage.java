package ru.praktikum.sprint4.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.sprint4.config.AppConfig;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPage {
    WebDriver webDriver;
    // Блок вопросов о важном
    private By questionAboutImportant = By.xpath(".//div[contains(text(), 'Вопросы о важном')]");
    //кнопка "Заказать" вверху страницы
    private By orderUpButton = By.xpath("(.//button[contains(text(), 'Заказать')])[1]");
    //кнопка "Заказать" внизу страницы
    private By orderDownButton = By.xpath("(.//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать'])");
    // question #0
    private By questionAboutPaymentHeading0 = By.id("accordion__heading-0");
    private By questionAboutPaymentPanel0 = By.id("accordion__panel-0");
    // question #1
    private By questionOfSeveralHeading1 = By.id("accordion__heading-1");
    private By questionOfSeveralPanel1 = By.id("accordion__panel-1");
    // question #2
    private By questionAboutRentalTimeHeading2 = By.id("accordion__heading-2");
    private By questionAboutRentalTimePanel2 = By.id("accordion__panel-2");
    // question #3
    private By questionsAboutOrderingTodayHeading3 = By.id("accordion__heading-3");
    private By questionsAboutOrderingTodayPanel3 = By.id("accordion__panel-3");
    // question #4
    private By questionAboutLeaseExtensionHeading4 = By.id("accordion__heading-4");
    private By questionAboutLeaseExtensionPanel4 = By.id("accordion__panel-4");
    // question #5
    private By questionsAboutChargingHeading5 = By.id("accordion__heading-5");
    private By questionsAboutChargingPanel5 = By.id("accordion__panel-5");
    // question #6
    private By questionsAboutOrderCancelHeading6 = By.id("accordion__heading-6");
    private By questionsAboutOrderCancelPanel6 = By.id("accordion__panel-6");
    // question #7
    private By questionsAboutLocationHeading7 = By.id("accordion__heading-7");
    private By questionsAboutLocationPanel7 = By.id("accordion__panel-7");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(AppConfig.SCOOTER_APP_URL);
    }
    public void scrollToQuestionAboutImportant() {
        WebElement element = webDriver.findElement(questionAboutImportant);
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
    public String getTextPanel0() {
        webDriver.findElement(questionAboutPaymentHeading0).click();
       WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionAboutPaymentPanel0));
        return accordionPanel.getText();
    }
    public String getTextPanel1() {
        webDriver.findElement(questionOfSeveralHeading1).click();
        WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionOfSeveralPanel1));
        return accordionPanel.getText();
    }
    public String getTextPanel2() {
        webDriver.findElement(questionAboutRentalTimeHeading2).click();
        WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionAboutRentalTimePanel2));
        return accordionPanel.getText();
    }
    public String getTextPanel3() {
        webDriver.findElement(questionsAboutOrderingTodayHeading3).click();
        WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionsAboutOrderingTodayPanel3));
        return accordionPanel.getText();
    }
    public String getTextPanel4() {
        webDriver.findElement(questionAboutLeaseExtensionHeading4).click();
        WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionAboutLeaseExtensionPanel4));
        return accordionPanel.getText();
    }
    public String getTextPanel5() {
        webDriver.findElement(questionsAboutChargingHeading5).click();
        WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionsAboutChargingPanel5));
        return accordionPanel.getText();
    }
    public String getTextPanel6() {
        webDriver.findElement(questionsAboutOrderCancelHeading6).click();
        WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionsAboutOrderCancelPanel6));
        return accordionPanel.getText();
    }
    public String getTextPanel7() {
        webDriver.findElement(questionsAboutLocationHeading7).click();
        WebElement accordionPanel = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(visibilityOfElementLocated(questionsAboutLocationPanel7));
        return accordionPanel.getText();
    }
    public OrderPage clickOrderUpButton() {
        webDriver.findElement(orderUpButton).click();
        return new OrderPage(webDriver);
    }
    public OrderPage clickOrderDownButton() {
        webDriver.findElement(orderDownButton).click();
        return new OrderPage(webDriver);
    }
    // Скролл к кнопке "Заказать" снизу страницы
    public void scrollToOrderDownButton() {
        WebElement element = webDriver.findElement(orderDownButton);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
