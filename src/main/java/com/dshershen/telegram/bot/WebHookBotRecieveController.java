package com.dshershen.telegram.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RestController
public class WebHookBotRecieveController {
    @Autowired
    private UNBBot unbBot;
    @PostMapping("/")
    public void getUpdate(@RequestBody Update update){
        log.info("some update recieved {}",update.toString());
        unbBot.onWebhookUpdateReceived(update);

    }
    @PostMapping("/callback/unbbotapi")
    public void getUpdateWithDifferentUrl(@RequestBody Update update){
        log.info("some update recieved {}",update.toString());
        unbBot.onWebhookUpdateReceived(update);

    }
}
