package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.MyChatGPT;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;


public class GPT implements ServerCommand {
    private static final int MAX_CONTENT_LENGTH = 2000;
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        StringBuilder builder = Main.getStringBuilder();
        for (int i = 1; i < arguments.length; i++) {
            builder.append(arguments[i]).append(" ");
        }
        String response = builder.toString().trim().replace("]", "").replace("[", "");
        String generatedResponse = MyChatGPT.generateChatGptResponse(response);
        sendGeneratedResponse(generatedResponse, textChannel);
    }

    //textChannel.sendMessage(MyChatGPT.generateChatGptResponse(response)).queue(message1 -> message1.delete().submitAfter(60, TimeUnit.SECONDS));
    private void sendGeneratedResponse(String generatedResponse, MessageChannel channel) {
        if (generatedResponse.length() <= MAX_CONTENT_LENGTH) {
            channel.sendMessage(generatedResponse).queue();
        } else {
            int startIndex = 0;
            int endIndex = MAX_CONTENT_LENGTH;
            while (startIndex < generatedResponse.length()) {
                if (endIndex >= generatedResponse.length()) {
                    endIndex = generatedResponse.length();
                } else {
                    while (endIndex > startIndex && !Character.isWhitespace(generatedResponse.charAt(endIndex))) {
                        endIndex--;
                    }
                }

                String messagePart = generatedResponse.substring(startIndex, endIndex);
                channel.sendMessage(messagePart).queue();

                startIndex = endIndex;
                endIndex += MAX_CONTENT_LENGTH;
            }
        }
    }
}

