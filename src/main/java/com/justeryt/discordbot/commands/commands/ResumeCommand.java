package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class ResumeCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            if (voiceChannel != null) {
                MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                AudioPlayer player = musicController.getAudioPlayer();
                TrackScheduler scheduler = musicController.getScheduler();
                player.addListener(scheduler);
                if (player.getPlayingTrack() != null) {
                    if (player.isPaused()) {
                        scheduler.resume();
                        EmbedCreate.createEmbed("✅Мы его отпустили", textChannel);
                    } else {
                        EmbedCreate.createEmbed("😡Ты оглох?! Трек и так играет мудила", textChannel);
                    }
                } else {
                    EmbedCreate.createEmbed("📛Сейчас нечего не играет, так что иди нахуй", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("📛Я не в голосовом канале мудак!", textChannel);
            }
        } else {
            EmbedCreate.createEmbed("🤦‍♂️Писать нужно вот так !resume", textChannel);
        }
    }
}
