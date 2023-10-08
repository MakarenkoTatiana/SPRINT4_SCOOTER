package ru.praktikum.sprint4.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentPage {
    WebDriver webDriver;

    public RentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //Поле ввода даты
    private By dateInput = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");
    //Поле ввода "Срока аренды"
    private By rentPeriodInput = By.xpath(".//div[contains(text(), '* Срок аренды')]/../..");
    //Комментарий
    private By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
   // Кнопка "Заказать"
    private By orderButton = By.xpath("(.//button[text()='Заказать'])[2]");

    private String colourCheckbox = ".//input[@id='colour']";

    public void setDateInput(String textDate) {
        webDriver.findElement(dateInput).sendKeys(textDate);
    }

    public void setRentPeriodInput(String rent) {
        webDriver.findElement(rentPeriodInput)
                .findElement(By.xpath("//span"))
                .click();
        webDriver.findElement(rentPeriodInput)
                .findElement(By.xpath("//div[@class='Dropdown-menu']/div[text()='" + rent + "']"))
                .click();
    }

    public void setColourCheckBox(String colour) {
        webDriver.findElement(By.xpath(colourCheckbox.replace("colour",colour))).click();
    }

    public void setCommentInput(String text) {
        webDriver.findElement(commentInput).sendKeys(text);
    }

    public OrderQuestionPage clickOrderButton() {
        webDriver.findElement(orderButton).click();
        return new OrderQuestionPage(webDriver);
    }

    public void fillOrderRentPage(String date, String period, String colour, String comment) {
        setDateInput(date);
        setRentPeriodInput(period);
        setColourCheckBox(colour);
        setCommentInput(comment);
    }

}
