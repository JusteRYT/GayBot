package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.util.ArrayList;

public class SkipCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            if (voiceChannel != null) {
                MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                AudioPlayer player = musicController.getAudioPlayer();
                TrackScheduler scheduler = musicController.getScheduler();
                player.addListener(scheduler);
                ArrayList<AudioTrack> list = scheduler.getList();
                if (!list.isEmpty() || player.getPlayingTrack() != null) {
                    scheduler.skip();
                    EmbedCreate.createEmbed("✅Трек пропущен", textChannel);
                } else {
                    EmbedCreate.createEmbed("💢Нечего скипать еблан!", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("📛Я не в голосовом канале мудак!", textChannel);
            }
        }
    }
}


