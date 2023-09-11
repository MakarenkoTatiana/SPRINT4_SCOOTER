package ru.praktikum.sprint4.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage {
    WebDriver webDriver;

    public OrderSuccessPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Текст в окне "Заказ оформлен"
    private By textMessage = By.xpath(".//div[text()='Заказ оформлен']");

    public String getTitle() {
        String message = webDriver.findElement(textMessage).getText();
        String[] messageArr = message.split("\n");
        return messageArr[0];
    }

    public boolean isOrderStatusTextVisible() {
        return webDriver.findElement(textMessage).isDisplayed();
    }
}
