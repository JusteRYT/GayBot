package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class BassCommand implements ServerCommand {
    public static float precent;
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        try {
            if (arguments.length == 2) {
                precent = Float.parseFloat(arguments[1]);
                if (voiceChannel != null) {
                    if (precent <= 200 & precent >= 0) {
                        MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                        TrackScheduler scheduler = musicController.getScheduler();
                        AudioPlayerManager audioPlayerManager = Main.getAudioPlayerManager();
                        audioPlayerManager.getConfiguration().setFilterHotSwapEnabled(true);
                        scheduler.Bass(precent);
                        int value = (int) precent;
                        EmbedCreate.createEmbed("✌Наслаждайся бассом в " + value + " Дыцыбел!", textChannel);
                    } else {
                        EmbedCreate.createEmbed("😅Введите значения от 0 до 200", textChannel);
                    }
                } else {
                    EmbedCreate.createEmbed("📛Я не в голосовом канале дебил", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("😡Введи так ебанушка !bass 200", textChannel);
            }
        } catch (NumberFormatException e) {
            EmbedCreate.createEmbed("🤦‍♂️Ну ты дебил, можешь цифрами написать?!", textChannel);
        }
    }

    public static float getPrecent() {
        return precent;
    }
}

