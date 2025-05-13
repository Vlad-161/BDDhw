package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DepositPage {
    private SelenideElement heading = $("[data-test-id='dashboard']");
    private SelenideElement secondHeader = $("h1");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement cancelButton = $("[data-test-id='action-cancel']");

    public DepositPage() {
        SelenideElement[] elementsToVerify = {
                heading,
                secondHeader,
                amountInput,
                fromInput,
                transferButton,
                cancelButton
        };
        for (SelenideElement element : elementsToVerify) {
            element.shouldBe(visible);
        }
        secondHeader.shouldHave(exactText("Пополнение карты"));
    }

    public DashboardPage validDeposit(String amount, String from) {
        amountInput.press(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE).setValue(amount);
        fromInput.press(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE).setValue(from);
        transferButton.click();
        return new DashboardPage();
    }
}