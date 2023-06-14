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

public class VolumeCommand implements ServerCommand {
     public static int volume = 100;
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        try {
            if (arguments.length == 2) {
                if (voiceChannel != null) {
                    MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                    AudioPlayer player = musicController.getAudioPlayer();
                    TrackScheduler scheduler = musicController.getScheduler();
                    player.addListener(scheduler);
                    scheduler.setVolume(volume);
                    if(volume >= 0 && volume <= 100) {
                        volume = Integer.parseInt(arguments[1]);
                        System.out.println(volume);
                        if (volume >= 50 & volume <= 100) {
                            EmbedCreate.createEmbed("🔊Громкость вот такая: " + volume, textChannel);
                        }
                        if (volume <= 49 & volume >= 20) {
                            EmbedCreate.createEmbed("🔉Громкость вот такая: " + volume, textChannel);
                        }
                        if (volume <= 19 & volume >= 0) {
                            EmbedCreate.createEmbed("🔈Громкость вот такая: " + volume, textChannel);
                        }
                    } else {
                        EmbedCreate.createEmbed("Громкость не может быть ниже 0 или больше 100", textChannel);
                    }
                } else {
                    EmbedCreate.createEmbed("📛Я не в голосовом канале, ебень", textChannel);
                }
            } else if (arguments.length == 1) {
                MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                AudioPlayer player = musicController.getAudioPlayer();
                int volume = player.getVolume();
                EmbedCreate.createEmbed("🔊Громкость вот такая: " + volume, textChannel);
            } else {
                EmbedCreate.createEmbed("😡Пиши вот так чмо !volume 0-100", textChannel);
            }
        } catch (NumberFormatException e) {
            EmbedCreate.createEmbed("Ну ты еблан, цыфры от букв не отличаешь 🤦‍♂️", textChannel);
        }
    }

    public  int getVolume() {
        return volume;
    }
}
