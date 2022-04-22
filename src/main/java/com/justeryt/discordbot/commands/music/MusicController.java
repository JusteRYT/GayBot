package com.justeryt.discordbot.commands.music;

import com.justeryt.discordbot.Main;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.MutableAudioFrame;
import net.dv8tion.jda.api.entities.Guild;

import java.nio.ByteBuffer;

public class MusicController {

    private Guild guild;
    private AudioPlayer audioPlayer;
    private ByteBuffer buffer;
    private MutableAudioFrame frame;
    private final TrackScheduler scheduler;

    public MusicController(Guild guild) {
        this.guild = guild;
        this.audioPlayer = Main.getAudioPlayerManager().createPlayer();
        this.guild.getAudioManager().setSendingHandler(new AudioPlayerSendHandler(audioPlayer, buffer, frame));
        this.scheduler = new TrackScheduler(audioPlayer);
        this.audioPlayer.addListener(scheduler);

    }

    public Guild getGuild() {
        if (this.guild != null) {
            return this.guild;
        }
        return null;
    }

    public AudioPlayer getAudioPlayer() {
        if (this.audioPlayer != null) {
            return this.audioPlayer;
        }
        return null;
    }
    public TrackScheduler getScheduler(){
        if (this.scheduler != null){
            return this.scheduler;
        }
        return  null;
    }

}
