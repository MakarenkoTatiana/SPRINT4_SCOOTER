package ru.praktikum.sprint4;

import org.junit.Assert;
import org.junit.Test;

public class QuestionsTest extends BaseTest{
    String expectedTextPanel0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    String expectedTextPanel1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься " +
            "с друзьями, можете просто сделать несколько заказов — один за другим.";
    String expectedTextPanel2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в " +
            "течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    String expectedTextPanel3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    String expectedTextPanel4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку " +
            "по красивому номеру 1010.";

    String expectedTextPanel5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток " +
            "— даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    String expectedTextPanel6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки " +
            "тоже не попросим. Все же свои.";

    String expectedTextPanel7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Test
    public void questionAboutPayment() {
       mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel0,
                mainPage.getTextPanel0());
    }

    @Test
    public void questionOfSeveral() {
        mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel1,
                mainPage.getTextPanel1());
    }

    @Test
    public void questionAboutRentalTime() {
        mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel2,
                mainPage.getTextPanel2());
    }

    @Test
    public void questionAboutOrderingToday() {
        mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel3,
                mainPage.getTextPanel3());
    }

    @Test
    public void questionAboutLeaseExtension() {
        mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel4,
                mainPage.getTextPanel4());
    }

    @Test
    public void questionAboutCharging() {
        mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel5,
                mainPage.getTextPanel5());
    }

    @Test
    public void questionAboutOrderCancellation() {
        mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel6,
                mainPage.getTextPanel6());
    }

    @Test
    public void questionAboutLocation() {
        mainPage.scrollToQuestionAboutImportant();
        Assert.assertEquals(expectedTextPanel7,
                mainPage.getTextPanel7());
    }
}
