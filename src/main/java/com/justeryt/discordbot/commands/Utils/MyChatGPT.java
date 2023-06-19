package com.justeryt.discordbot.commands.Utils;

import com.justeryt.discordbot.resource.LoadToken;
import com.plexpt.chatgpt.ChatGPT;

import java.io.FileNotFoundException;

public class MyChatGPT {

    public static String generateChatGptResponse(String message) {
        ChatGPT chatGPT = null;
        try {
            chatGPT = ChatGPT.builder()
                    .apiKey(LoadToken.getApiChatGPT())
                    .build()
                    .init();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return chatGPT.chat(message);
    }
}

