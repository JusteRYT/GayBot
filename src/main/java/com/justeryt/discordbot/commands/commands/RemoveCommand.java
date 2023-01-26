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


public class RemoveCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            if (voiceChannel != null) {
                MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                AudioPlayer player = musicController.getAudioPlayer();
                TrackScheduler scheduler = musicController.getScheduler();
                player.addListener(scheduler);
                ArrayList<AudioTrack> list = scheduler.getList();
                try {
                    if (list.get(0) != null) {
                        scheduler.drainQueue();
                        EmbedCreate.createEmbed("✅Очередь удалена", textChannel);
                    } else {
                        EmbedCreate.createEmbed("💢В очереди нет треков!", textChannel);
                    }
                } catch (IndexOutOfBoundsException e) {
                    EmbedCreate.createEmbed("💢В очереди нет треков!", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("📛Я не в голосовом канале мудак!", textChannel);
            }
        } else {
            EmbedCreate.createEmbed("📛Нужно вот так !remove", textChannel);
        }
    }
}
