package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.util.*;

public class RollPos implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        GuildVoiceState voiceState = member.getVoiceState();
        assert voiceState != null;
        voiceChannel = voiceState.getChannel();
        if (voiceChannel != null) {
            ArrayList<String> list = Main.getList();
            for (int i = 0; i < 5; i++) {
                if (voiceChannel.getMembers().size() <= 6) {
                    try {
                        list.add(voiceChannel.getMembers().get(i).getUser().getName());
                    } catch (IndexOutOfBoundsException e) {
                        list.add("Пусто");
                    }
                } else {
                    EmbedCreate.createEmbed("В голосовом чате много народа 💢",textChannel);
                }
            }
            Collections.shuffle(list);
            EmbedCreate.createRollPos(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), textChannel);
        } else {
            EmbedCreate.createEmbed("Должен быть, хотя бы один еблан в голосовом канале📛", textChannel);
        }
    }
}
