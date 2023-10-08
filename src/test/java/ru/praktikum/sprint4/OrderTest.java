package ru.praktikum.sprint4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.sprint4.pageobject.OrderPage;
import ru.praktikum.sprint4.pageobject.OrderQuestionPage;
import ru.praktikum.sprint4.pageobject.OrderSuccessPage;
import ru.praktikum.sprint4.pageobject.RentPage;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest{
    OrderPage orderPage;
    RentPage rentPage;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentPeriod;
    private final String colour;
    private final String comment;
    private final boolean orderSuccess;

    public OrderTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentPeriod, String colour, String comment, boolean orderSuccess) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.colour = colour;
        this.comment = comment;
        this.orderSuccess = orderSuccess;
    }

    @Parameterized.Parameters(name = "Заказ самоката. Тестовые данные: {0} {1} {2} {3} {4} {5} {6} {7} {8} {9}")
    public static Object[][] getOrderData() {
        return new Object[][] {
                //Тестовые данные
                {"Татьяна", "Макаренко", "Новосибирск", "Лубянка", "+79131112233", "11.09.2023", "двое суток", "black", "no comments", true},
                {"иван", "Захаров", "Москва", "Орехово", "+79131112233", "11.09.2020", "сутки", "grey", "", true},
        };
    }

    @Test
    public void orderUpTest() {
        orderPage = new OrderPage(webDriver);
        // Нажимаем кнопку "Заказать" вверху главной страницы
        mainPage.clickOrderUpButton();
        // Заполняем данные  заказа
        orderPage.fillOrderPage(name, surname, address, subway, phoneNumber);
        // Далее
        orderPage.clickNextButton();
        rentPage = new RentPage(webDriver);
        //Заполняем данные об аренде
        rentPage.fillOrderRentPage(date, rentPeriod, colour, comment);
        // Заказать
        OrderQuestionPage orderQuestionPage = rentPage.clickOrderButton();
        // Поддтверждаем
        OrderSuccessPage orderSuccessPage = orderQuestionPage.clickYesButton();
      //  Assert.assertTrue("Не появилось окно 'Заказ не оформлен'", orderSuccessPage.isOrderStatusTextVisible());
        Assert.assertEquals("Error! Проверьте актуальный результат.", "Заказ оформлен",orderSuccessPage.getTitle());
    }

    @Test
    public void orderDownTest() {
        orderPage = new OrderPage(webDriver);
        mainPage.scrollToOrderDownButton();
        // Нажимаем кнопку "Заказать" внизу главной страницы
        mainPage.clickOrderDownButton();
        // Заполняем данные  заказа
        orderPage.fillOrderPage(name, surname, address, subway, phoneNumber);
        // Далее
        orderPage.clickNextButton();
        rentPage = new RentPage(webDriver);
        //Заполняем данные об аренде
        rentPage.fillOrderRentPage(date, rentPeriod, colour, comment);
        // Заказать
        OrderQuestionPage orderQuestionPage = rentPage.clickOrderButton();
        // Поддтверждаем
        OrderSuccessPage orderSuccessPage = orderQuestionPage.clickYesButton();
        //  Assert.assertTrue("Не появилось окно 'Заказ оформлен'", orderSuccessPage.isOrderStatusTextVisible());
        Assert.assertEquals("Не появилось окно 'Заказ оформлен'", "Заказ оформлен",orderSuccessPage.getTitle());
    }
}
