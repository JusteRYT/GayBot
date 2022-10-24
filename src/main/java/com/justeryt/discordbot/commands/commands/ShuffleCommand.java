package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.*;

import java.util.ArrayList;

public class ShuffleCommand implements ServerCommand {


    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        if (arguments.length == 1) {
            if (voiceChannel != null) {
                MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                AudioPlayer player = musicController.getAudioPlayer();
                TrackScheduler scheduler = musicController.getScheduler();
                player.addListener(scheduler);
                ArrayList<AudioTrack> list = scheduler.getList();
                try {
                    if (list.get(0) != null) {
                        scheduler.shuffle();
                        EmbedCreate.createEmbed("✅Плейлист перемешен", textChannel);
                    } else {
                        EmbedCreate.createEmbed("📛В очереди нет треков, так что я не буду нечего мешать!!!", textChannel);
                    }
                } catch (IndexOutOfBoundsException e) {
                    EmbedCreate.createEmbed("📛В очереди нет треков, так что я не буду нечего мешать!!!", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("📛А ну да, мне же надо сначало воспроизвести музыку, а потом подключаться, это ты здорово придумал", textChannel);
            }
        } else {
            EmbedCreate.createEmbed("🤦‍♂️Напиши вот так и не беси меня !shuffle", textChannel);
        }
    }
}
