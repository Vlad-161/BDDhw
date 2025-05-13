package ru.netology.test;

import ru.netology.page.DashboardPage;

public class ServiceTest {
    void revertTransfer(String depositCardId, String fromCardNumber, int amount) {
        var dbPage = new DashboardPage();
        dbPage.cardDeposit(depositCardId).validDeposit(String.valueOf(amount), fromCardNumber);
    }
}
