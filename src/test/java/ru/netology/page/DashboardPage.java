package ru.netology.page;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DashboardPage {

    private SelenideElement heading = $("[data-test-id='dashboard']");
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");
    private SelenideElement firstCard = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCard = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement firstCardDepoButton = firstCard.$("[data-test-id='action-deposit']");
    private SelenideElement secondCardDepoButton = secondCard.$("[data-test-id='action-deposit']");
    private ElementsCollection cardsCollection = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
        SelenideElement[] elementsToVerify = {
                heading,
                reloadButton,
                firstCard,
                secondCard,
                firstCardDepoButton,
                secondCardDepoButton};
        for (SelenideElement element : elementsToVerify) {
            element.shouldBe(visible);
        }
    }

    public int getCardBalance(String cardId) {
        SelenideElement card = cardsCollection.findBy(attribute("data-test-id", cardId));
        String text = card.getText();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        int start = text.indexOf(balanceStart);
        int finish = text.indexOf(balanceFinish);
        String value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public DepositPage cardDeposit(String cardId) {
        SelenideElement card = cardsCollection.findBy(attribute("data-test-id", cardId));
        card.$("[data-test-id='action-deposit']").click();
        return new DepositPage();
    }

}