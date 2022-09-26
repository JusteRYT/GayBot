package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

public class ShuffleCommand implements ServerCommand {


    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        if (voiceChannel != null) {
            MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
            AudioPlayer player = musicController.getAudioPlayer();
            TrackScheduler scheduler = musicController.getScheduler();
            player.addListener(scheduler);
            scheduler.shuffle();
            textChannel.sendMessage("✔Плейлист перемешен").queue();
        } else {
            textChannel.sendMessage("❌А ну да, мне же не надо сначало воспроизвести музыку, а потом подключаться, это ты здорово придумал").queue();
        }
    }
}
