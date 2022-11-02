package com.justeryt.discordbot.commands.music;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.Utils.Utils;
import com.sedmelluq.discord.lavaplayer.filter.equalizer.EqualizerFactory;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import net.dv8tion.jda.api.entities.TextChannel;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class TrackScheduler extends AudioEventAdapter {
    private final AudioPlayer player;
    private final BlockingDeque<AudioTrack> queue;
    private final TextChannel textChannel;
    private static final float[] BASS_BOOST = {
            0,2f,
            0.15f,
            0.1f,
            0.05f,
            0.0f,
            -0.05f,
            -0.1f,
            -0.1f,
            -0.1f,
            -0.1f,
            -0.1f,
            -0.1f,
            -0.1f,
            -0.1f,
            -0.1f,
    };
    private final EqualizerFactory equalizerFactory;

    public TrackScheduler(AudioPlayer player) {
        this.player = player;
        this.queue = new LinkedBlockingDeque<>();
        this.textChannel = Main.getJda().getTextChannelById(529237596602105867L);
        this.equalizerFactory = new EqualizerFactory();
        this.player.setFilterFactory(equalizerFactory);
        this.player.setFrameBufferDuration(500);
    }

    @Override
    public void onPlayerPause(AudioPlayer player) {
        super.onPlayerPause(player);
        player.isPaused();

    }

    @Override
    public void onPlayerResume(AudioPlayer player) {
        super.onPlayerResume(player);

    }

    @Override
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        super.onTrackStart(player, track);
        String time = Utils.formatLongDuration(track.getInfo().length);
        long millisecond = track.getInfo().length;
        EmbedCreate.createEmbedTrackScheduler("Сейчас ебашит: " + track.getInfo().title, "Длительность: " + time,
                "GayBot", Main.getIcon(), textChannel, getLink(track), Color.orange, millisecond);
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
        EmbedCreate.createEmbedException("Не удалось запустить трек: " + track.getInfo().title, textChannel);
        skip();
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

    public void drainQueue() {
        LinkedBlockingDeque<AudioTrack> drainQueue = new LinkedBlockingDeque<>();
        queue.drainTo(drainQueue);
    }

    public void playNow(AudioTrack audioTrack) {
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

    public void getVolume() {
        player.getVolume();
    }

    public void stop() {
        player.setPaused(true);
    }

    public void resume() {
        player.setPaused(false);
    }

    public void Bass(float percentage) {
        final float multiplier = percentage / 100.00f;
        for (int i = 0; i < BASS_BOOST.length; i++){
            equalizerFactory.setGain(i, BASS_BOOST[i] * multiplier);
        }
    }

    public static String getLink(AudioTrack track) {

        String link = track.getIdentifier();
        return String.format("http://img.youtube.com/vi/" + link + "/hqdefault.jpg");
    }
}

