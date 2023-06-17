package com.justeryt.discordbot.commands.Utils;

import com.plexpt.chatgpt.ChatGPT;

public class MyChatGPT {

    public static String generateChatGptResponse(String message) {
        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey("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")
                .build()
                .init();
        return chatGPT.chat(message);
    }
}

