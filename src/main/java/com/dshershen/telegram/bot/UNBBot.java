package com.dshershen.telegram.bot;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@Slf4j
@Component

public class WebHook extends TelegramWebhookBot  {
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;


    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        log.info(update.toString());
        SendMessage sendmessage = new SendMessage();
        sendmessage.setChatId(update.getMessage().getChatId().toString());
        sendmessage.setText("Hi");

        return sendmessage;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return "unbbotapi";
    }


}
