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
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TrackScheduler extends AudioEventAdapter {
    private final AudioPlayer player;
    public static ArrayList<String> history;
    private final ArrayList<AudioTrack> queue;
    private TextChannel textChannel;
    private static ArrayList<String> urltitle;
    public int currentIndex;
    public static int page;
    private static final float[] BASS_BOOST = {
            0, 2f,
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

    public TrackScheduler(AudioPlayer player, Guild guild) {
        this.player = player;
        this.queue = new ArrayList<>();
        this.textChannel = guild.getDefaultChannel().asTextChannel();
        this.equalizerFactory = new EqualizerFactory();
        this.player.setFilterFactory(equalizerFactory);
        this.player.setFrameBufferDuration(500);
        urltitle = Main.getList();
        history = new ArrayList<>();
        this.currentIndex = 0;
        page = 0;
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
        history.add(track.getInfo().title);
        removeQueue();
        super.onTrackStart(player, track);
        setTitleUrl(track.getInfo().title, track.getInfo().uri);
        if (track.getDuration() < 175800000) {
            String time = Utils.bestFormatDuration(track.getInfo().length);
            long millisecond = track.getInfo().length;
            EmbedCreate.createEmbedTrackScheduler(track.getInfo().title, "Длительность: " + time,
                    "GayBot", Main.getIcon(), textChannel, Main.getUrlForVideo(getLink(track)), Color.orange, millisecond, track.getInfo().uri,
                    track.getInfo().author);
        } else {
            String time = Utils.bestFormatDuration(track.getInfo().length, track.getIdentifier());
            long millisecond = track.getInfo().length;
            EmbedCreate.createEmbedTrackScheduler(track.getInfo().title, "Длительность: " + time,
                    "GayBot", Main.getIcon(), textChannel, Main.getUrlForVideo(getLink(track)), Color.orange, millisecond, track.getInfo().uri,
                    track.getInfo().author);
        }

    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        super.onTrackEnd(player, track, endReason);
        if (endReason.mayStartNext) {
            currentIndex++;
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
        if (queue.isEmpty()) {
            currentIndex = 0;
        }
        queue.add(audioTrack);
        startNextTrack(true);
    }

    public void removeQueue() {
        if (currentIndex >= 200) {
            int trackToRemove = 150;
            int newCurrentIndex = currentIndex - trackToRemove;
            for (int i = 0; i < trackToRemove; i++) {
                queue.remove(0);
            }
            currentIndex = Math.max(0, newCurrentIndex);
        }
    }

    public void startNextTrack(boolean noInterrupt) {
        if (currentIndex >= 0 && currentIndex < queue.size()) {
            if (currentIndex > 0) {
                AudioTrack next = queue.get(currentIndex).makeClone();
                if (next != null) {
                    if (!player.startTrack(next, noInterrupt)) {
                        queue.set(currentIndex, next);
                    }
                } else {
                    player.stopTrack();
                }
            } else{
                AudioTrack next = queue.get(currentIndex).makeClone();
                player.startTrack(next, noInterrupt );
            }
        }
        if (currentIndex > queue.size()) {
            EmbedCreate.createEmbed("В очереди не осталось треков", textChannel);
        }
    }

    public static void history(MessageChannel textChannel, int pageNumber, String messageId) {
        String track = history.get(history.size() - 1);
        List<String> reversedTracks = new ArrayList<>(history);
        Collections.reverse(reversedTracks);
        int tracksPerPage = 10; // Количество треков на странице
        int totalTracks = history.size(); // Общее количество треков в истории

        int totalPages = (int) Math.ceil((double) totalTracks / tracksPerPage); // Общее количество страниц
        int startIndex = Math.max((pageNumber - 1) * tracksPerPage, 0); // Индекс начала текущей страницы
        int endIndex = Math.min(startIndex + tracksPerPage, totalTracks); // Индекс конца текущей страницы
        if (startIndex >= history.size()) {
            // Достигнут конец истории, нет дополнительных треков для отображения
            return;
        }

        List<String> tracksToShow = reversedTracks.subList(startIndex, endIndex);
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Заголовок Embed");
        textChannel.retrieveMessageById(messageId).queue(message -> {
            EmbedCreate.createHistoryEmbed(tracksToShow, startIndex, track, textChannel, totalPages, pageNumber, message);
        });

    }

    public void previous() {
        if (currentIndex > -1) {
            currentIndex--;
            AudioTrack audioTrack = queue.get(currentIndex).makeClone();
            if (audioTrack != null) {
                player.playTrack(audioTrack);
            }
        } else {
            EmbedCreate.createEmbed("Нет треков в очереди", textChannel);
        }
    }

    public void drainQueue() {
        queue.clear();
    }

    public void skip() {
        currentIndex++;
        startNextTrack(false);
    }

    public void shuffle() {
        ArrayList<AudioTrack> list = getList();
        Collections.shuffle(list);
        queue.clear();
        queue.addAll(list);
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

    public void pause() {
        player.setPaused(true);
    }

    public void resume() {
        player.setPaused(false);
    }

    public void Bass(float percentage) {
        final float multiplier = percentage / 100.00f;
        for (int i = 0; i < BASS_BOOST.length; i++) {
            equalizerFactory.setGain(i, BASS_BOOST[i] * multiplier);
        }
    }

    public static String getLink(AudioTrack track) {
        String link = track.getInfo().uri;
        return link.split("v=")[1];
    }

    public void setTextChannel(TextChannel textChannel) {
        this.textChannel = textChannel;
    }

    public static ArrayList<String> getTitle() {
        return urltitle;
    }

    public static void setTitleUrl(String title, String url) {
        if (urltitle.size() < 10) {
            urltitle.add(String.format("[%s](%s)", title, url));
        } else {
            urltitle.remove(0);
            urltitle.add(String.format("[%s](%s)", title, url));
        }
    }
}

