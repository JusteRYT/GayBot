package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class PreviousCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1){
            MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
            AudioPlayer player = musicController.getAudioPlayer();
            TrackScheduler scheduler = musicController.getScheduler();
            player.addListener(scheduler);
            scheduler.previous();
        } else {
            EmbedCreate.createEmbed("Нужно писать вот так !previous", textChannel);
        }
    }
}
