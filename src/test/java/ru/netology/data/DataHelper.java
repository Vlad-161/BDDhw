package ru.netology.data;

import lombok.Value;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    private static final Faker faker = new Faker();
    private static final List<Card> cards = new ArrayList<>();

    static {
        cards.add(new Card("92df3f1c-a033-48e6-8390-206f6b1f56c0",
                "5559 0000 0000 0001", 10_000));
        cards.add(new Card("0f3f5c2a-249e-4c3d-8287-09f7a039391d",
                "5559 0000 0000 0002", 10_000));
    }

    private DataHelper() {
    }

    public static Card getCard(int index) {
        return cards.get(index);
    }

    public static int genAmount(Card card, int limit) {
        return faker.number().numberBetween(1, limit + 1);
    }

    @Value
    public static class Card {
        private String id;
        private String number;
        private int initialBalance;
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }


    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }
}