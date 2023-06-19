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
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.util.concurrent.TimeUnit;

public class PlayOrNot implements ServerCommand {
    static ButtonInteractionEvent event;
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (voiceChannel != null) {
            Guild emojiGuild = Main.getJda().getGuildById(403639391265882115L);
            Emoji play = emojiGuild.getEmojisByName("play", true).get(0);
            Emoji pause = emojiGuild.getEmojisByName("pause", true).get(0);
            MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
            AudioPlayer player = musicController.getAudioPlayer();
            TrackScheduler scheduler = musicController.getScheduler();
            player.addListener(scheduler);
            if (player.getPlayingTrack() != null) {
                if (player.isPaused()) {
                    scheduler.resume();
                    event.editButton(event.getButton().withEmoji(pause)).queue();

                } else if (!player.isPaused()){
                    scheduler.pause();
                    event.editButton(event.getButton().withEmoji(play)).queue();
                    
                }
            } else {
                EmbedCreate.createEmbed("В очереди нет треков📛",textChannel);
            }
        }
    }
    public static void setEvent(ButtonInteractionEvent event){
        PlayOrNot.event = event;
    }

    public ButtonInteractionEvent getEvent() {
        return event;
    }
}
