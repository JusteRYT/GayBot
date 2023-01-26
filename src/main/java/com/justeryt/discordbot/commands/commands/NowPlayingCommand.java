package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.util.ArrayList;

public class NowPlayingCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            if (voiceChannel != null) {
                MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                AudioPlayer player = musicController.getAudioPlayer();
                TrackScheduler scheduler = musicController.getScheduler();
                player.addListener(scheduler);
                if (player.getPlayingTrack() != null) {
                    try {
                        ArrayList<AudioTrack> list = scheduler.getList();
                        EmbedCreate.createEmbedNowPlay("🔊Сейчас играет: " + player.getPlayingTrack().getInfo().title, Main.getIcon(),
                                player.getPlayingTrack().getInfo().title, player.getPlayingTrack().getInfo().uri, list.size(), textChannel);
                    } catch (IndexOutOfBoundsException e) {
                        if (e.toString().startsWith("java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0")) {
                            EmbedCreate.createEmbed("📛В очереди нет треков, мудила, рукаблуд ссанина...", textChannel);
                        }
                    }
                } else {
                    EmbedCreate.createEmbed("📛В очереди нет треков, мудила, рукаблуд ссанина...", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("😡Я не в голосовом канале!!!", textChannel);
            }
        } else
            EmbedCreate.createEmbed("📛Нужно писать вот так !nowplay", textChannel);
    }
}

