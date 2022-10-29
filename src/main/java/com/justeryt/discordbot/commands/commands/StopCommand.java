package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.*;

public class StopCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            if (voiceChannel != null) {
                MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                AudioPlayer player = musicController.getAudioPlayer();
                TrackScheduler scheduler = musicController.getScheduler();
                player.addListener(scheduler);
                if (player.getPlayingTrack() != null) {
                    if (!player.isPaused()) {
                        scheduler.stop();
                        EmbedCreate.createEmbed("💢Мы его задержали", textChannel);
                    } else {
                        EmbedCreate.createEmbed("📛Он и так не играет дэбил!!!", textChannel);
                    }
                } else {
                    EmbedCreate.createEmbed("😡В очереди нет треков", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("📛Я не в голосовом канале мудак!", textChannel);
            }
        } else {
            EmbedCreate.createEmbed("🤦‍♂️Ни как вы блять не научитесь !stop и всё!!!", textChannel);
        }
    }
}
