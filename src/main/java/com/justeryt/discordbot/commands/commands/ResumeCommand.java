package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.*;

public class ResumeCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        GuildVoiceState voiceState = member.getVoiceState();
        VoiceChannel voiceChannel = voiceState.getChannel();
        MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
        AudioPlayer player = musicController.getAudioPlayer();
        TrackScheduler scheduler = musicController.getScheduler();
        player.addListener(scheduler);
        scheduler.onPlayerResume(player);
        textChannel.sendMessage("Трек запущен").queue();
    }
}
