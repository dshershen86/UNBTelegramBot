package com.dshershen.telegram.bot;



import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.starter.SpringWebhookBot;


@Slf4j
@Setter
public class UNBBot extends SpringWebhookBot {
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    public UNBBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    public UNBBot(DefaultBotOptions options, SetWebhook setWebhook) {
        super(options, setWebhook);
    }
    @Override
    public BotApiMethod<Message> onWebhookUpdateReceived(Update update) {
        log.info(update.toString());
        if (update.getMessage() != null && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            try {
                execute(new SendMessage(chatId.toString(), "HI HANDSOME " + update.getMessage().getText()));

            } catch (TelegramApiException e) {
                throw new IllegalStateException(e);
            }
        }
        return null;
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
