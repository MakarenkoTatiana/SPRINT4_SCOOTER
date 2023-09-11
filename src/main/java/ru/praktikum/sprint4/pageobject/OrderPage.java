package ru.praktikum.sprint4.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By nameInput = By.cssSelector("input[placeholder='* Имя']");
    private By surnameInput = By.cssSelector("input[placeholder='* Фамилия']");
    private By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By subwayStation = By.xpath(".//input[contains(@placeholder, '* Станция метро')]/../..");
    private By phoneNumber = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[contains(text(), 'Далее')]");

    public void setNameInput(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
    }

    public void setSurnameInput(String surname) {
        webDriver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddressInput(String address) {
        webDriver.findElement(addressInput).sendKeys(address);
    }

    public void setSubwayStation(String station) {
        webDriver.findElement(subwayStation)
                .findElement(By.xpath(".//input[contains(@placeholder, '* Станция метро')]"))
                .sendKeys(station);
        webDriver.findElement(subwayStation)
                .findElement(By.xpath("(.//button[contains(@class, 'select-search__option')])[1]"))
                .click();
    }

    public void setPhoneNumber(String phoneNum) {
        webDriver.findElement(phoneNumber).sendKeys(phoneNum);
    }

    public OrderPage clickNextButton() {
        webDriver.findElement(nextButton).click();
        return new OrderPage(webDriver);
    }

    public void fillOrderPage(String name, String surname, String address, String station, String phone) {
        setNameInput(name);
        setSurnameInput(surname);
        setAddressInput(address);
        setSubwayStation(station);
        setPhoneNumber(phone);
    }
}
