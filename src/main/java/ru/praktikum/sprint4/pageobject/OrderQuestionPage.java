package ru.praktikum.sprint4.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderQuestionPage {
    WebDriver webDriver;

    public OrderQuestionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Кнопка "Да" в окне "Хотите оформить заказ?"
    private By yesButton = By.xpath(".//button[text()='Да']");

    public OrderSuccessPage clickYesButton() {
        webDriver.findElement(yesButton).click();
        return new OrderSuccessPage(webDriver);
    }
}
