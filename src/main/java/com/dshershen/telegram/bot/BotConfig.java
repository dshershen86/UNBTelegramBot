package com.dshershen.telegram.bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultWebhook;

@Slf4j
@Configuration
public class BotConfig {
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;
    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url("https://dshershen.site").build();
    }

    @Bean
    public UNBBot unbbot(SetWebhook setWebhookInstance) throws TelegramApiException {

        UNBBot unbbot = new UNBBot(setWebhookInstance);
        unbbot.setBotUsername(botUsername);
        unbbot.setBotToken(botToken);

        DefaultWebhook defaultWebhook = new DefaultWebhook();

      defaultWebhook.setInternalUrl(
                "http://localhost:8080"); // the port to start the server, on the localhost computer, on the server it
        // be the server address
        //   defaultWebhook.registerWebhook(adamSmithBot);

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class, defaultWebhook);

        log.info("SetWebHook from UNBBot {}", setWebhookInstance);
        unbbot.getBotUsername();
        telegramBotsApi.registerBot(unbbot, setWebhookInstance);
        return unbbot;

    }
}
