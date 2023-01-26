package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        GuildVoiceState guildVoiceState;
        if (arguments.length == 1) {
            if ((guildVoiceState = member.getVoiceState()) != null) {
                if ((voiceChannel = guildVoiceState.getChannel()) != null) {
                    AudioManager audioManager = guildVoiceState.getGuild().getAudioManager();
                    audioManager.openAudioConnection(voiceChannel);
                    EmbedCreate.createEmbed("😅Я подключился к каналу: " + voiceChannel.getName(), textChannel);
                } else {
                    EmbedCreate.createEmbed("😡Ты не в голосовом канале сучка!", textChannel);
                }
            }
        } else {
            EmbedCreate.createEmbed("📛Ну напиши ты корявыми пальцами вот так !join, не !join хуебес быстро блять," +
                    "а просто !join", textChannel);
        }
    }
}
