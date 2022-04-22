package com.justeryt.discordbot.commands.music;

import com.justeryt.discordbot.Main;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


public class TrackScheduler extends AudioEventAdapter {
    private final AudioPlayer player;
    private final BlockingDeque<AudioTrack> queue;
    private TextChannel textChannel;
    private EmbedBuilder embedBuilder;


    public TrackScheduler(AudioPlayer player) {
        this.player = player;
        this.queue = new LinkedBlockingDeque<>();
        this.textChannel = Main.getJda().getTextChannelById(953926413113769987L);
        this.embedBuilder = new EmbedBuilder();
    }

    @Override
    public void onPlayerPause(AudioPlayer player) {
        super.onPlayerPause(player);
        player.isPaused();

    }

    @Override
    public void onPlayerResume(AudioPlayer player) {
        super.onPlayerResume(player);
        AudioTrack audioTrack = queue.peek();
        player.startTrack(audioTrack, false);
    }

    @Override
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        super.onTrackStart(player, track);
        embedBuilder.setTitle("Сейчас ебашит: " + track.getInfo().title);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        super.onTrackEnd(player, track, endReason);
        if (endReason.mayStartNext) {
            startNextTrack(true);
        }
    }

    @Override
    public void onTrackException(AudioPlayer player, AudioTrack track, FriendlyException exception) {
        super.onTrackException(player, track, exception);
    }

    @Override
    public void onTrackStuck(AudioPlayer player, AudioTrack track, long thresholdMs) {
        super.onTrackStuck(player, track, thresholdMs);
        startNextTrack(false);
    }


    public void addToQueue(AudioTrack audioTrack) {
        queue.addLast(audioTrack);
        startNextTrack(true);
    }

    public void startNextTrack(boolean noInterrupt) {
        AudioTrack next = queue.pollFirst();
        if (next != null) {
            if (!player.startTrack(next, noInterrupt)) {
                queue.addFirst(next);
            }
        } else {
            player.stopTrack();
        }
    }

    public LinkedBlockingDeque<AudioTrack> drainQueue() {
        LinkedBlockingDeque<AudioTrack> drainQueue = new LinkedBlockingDeque<>();
        queue.drainTo(drainQueue);
        return drainQueue;
    }

    public void playNow(AudioTrack audioTrack, boolean clearQueue) {
        if (clearQueue) {
            queue.clear();
        }
        queue.addFirst(audioTrack);
        startNextTrack(false);
    }

    public void skip() {
        startNextTrack(false);
    }

    public void shuffle() {
        ArrayList<AudioTrack> list = getList();
        Collections.shuffle(list);
        queue.clear();
        for (AudioTrack track : list) {
            queue.offer(track);
        }
    }

    public ArrayList<AudioTrack> getList() {
        Iterator<AudioTrack> i = queue.iterator();
        ArrayList<AudioTrack> al = new ArrayList<>();
        while (i.hasNext()) {
            al.add(i.next());
        }
        return al;
    }

    public void setVolume(int volume) {
        player.setVolume(volume);
    }

    public void stop() {
        player.stopTrack();
    }
    public void resume(AudioTrack track){
        player.startTrack(track, true);
    }
}
