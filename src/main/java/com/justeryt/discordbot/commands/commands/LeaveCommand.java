package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

public class LeaveCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        if (voiceChannel == null){
            textChannel.sendMessage("❌Ебанат я не в голосовом чате").queue();
        }else {
            guild.getAudioManager().closeAudioConnection();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("✔Я ливнул, пидорасы");
            textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
        }

    }
}
