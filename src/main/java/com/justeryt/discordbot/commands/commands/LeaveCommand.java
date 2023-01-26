package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class LeaveCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel)  {
        if (voiceChannel == null){
            EmbedCreate.createEmbed("📛Ебанат я не в голосовом чате", textChannel);
        }else {
            guild.getAudioManager().closeAudioConnection();
            EmbedCreate.createEmbed("🙋Я ливнул пидорасы!!!", textChannel);
        }

    }
}
