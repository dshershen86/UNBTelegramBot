package com.dshershen.telegram;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


// Аннотация, которая объединяет в себя @Configuration, @EnableAutoConfiguration, @ComponentScan

public class App {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
