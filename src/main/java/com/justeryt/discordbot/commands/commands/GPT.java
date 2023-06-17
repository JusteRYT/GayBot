package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.MyChatGPT;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.util.Arrays;

public class GPT implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        StringBuilder builder = Main.getStringBuilder();
        for (int i = 1; i < arguments.length; i++) builder.append(arguments[i]).append(" ");
        String response = builder.toString().trim().replace("]", "").replace("[", "");
        textChannel.sendMessage(MyChatGPT.generateChatGptResponse(response)).queue();
    }
}

