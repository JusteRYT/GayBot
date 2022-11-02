package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.ListMusic.TrackList;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.Utils.Utils;
import com.justeryt.discordbot.commands.types.ServerCommand;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.AudioManager;

import java.awt.*;

public class PlayCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 2) { //! play <url>
            GuildVoiceState voiceState;
            if ((voiceState = member.getVoiceState()) != null) {
                if ((voiceChannel = voiceState.getChannel()) != null) {
                    MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                    AudioPlayer player = musicController.getAudioPlayer();
                    AudioPlayerManager audioPlayerManager = Main.getAudioPlayerManager();
                    TrackScheduler scheduler = musicController.getScheduler();
                    player.addListener(scheduler);
                    AudioManager audioManager = voiceState.getGuild().getAudioManager();
                    audioManager.openAudioConnection(voiceChannel);
                    StringBuilder builder = Main.getStringBuilder();
                    for (int i = 1; i < arguments.length; i++) builder.append(arguments[i]).append(" ");
                    String rawLink = builder.toString().trim().replace("]", "").replace("[", "");
                    if (rawLink.equals("gachi")) {
                        rawLink = TrackList.getGachiLink();
                    }
                    if (rawLink.equals("GachiRadio")) {
                        rawLink = TrackList.getGachiRadio();
                    }
                    if (rawLink.equals("phonk")) {
                        rawLink = TrackList.getPhonkLink();
                    }
                    if (!rawLink.startsWith("https")) {
                        rawLink = "ytsearch: " + rawLink;
                    }
                    if (!rawLink.startsWith("my")){
                        rawLink = TrackList.getMyPlaylist();
                    }
                    final String url = rawLink;
                    audioPlayerManager.loadItem(url, new AudioLoadResultHandler() {
                        @Override
                        public void trackLoaded(AudioTrack audioTrack) {
                            if (audioTrack != null) {
                                EmbedCreate.createEmbedTrackLoaded("▶Трек загружен: " + audioTrack.getInfo().title,
                                        getURL(url), member.getUser().getName(),
                                        Utils.formatLongDuration(audioTrack.getDuration()), textChannel);
                                scheduler.addToQueue(audioTrack);
                            }
                        }

                        @Override
                        public void playlistLoaded(AudioPlaylist audioPlaylist) {
                            if (audioPlaylist != null) {
                                long time = 0;
                                for (int i = 0; i < audioPlaylist.getTracks().size(); i++) {
                                    if (!audioPlaylist.getTracks().isEmpty()) {
                                        time = time + audioPlaylist.getTracks().get(i).getDuration();
                                    }
                                }
                                int cost = audioPlaylist.getTracks().size();
                                EmbedCreate.createEmbedPlaylistLoad("▶Аудиоплейлист загружен: " + audioPlaylist.getName(),
                                        "🎵Длительность: " + Utils.formatLongDuration(time),
                                        "GayBot", Main.getIcon(), Color.ORANGE, textChannel, cost, url, audioPlaylist.getName());
                                for (AudioTrack audioTrack : audioPlaylist.getTracks()) {
                                    scheduler.addToQueue(audioTrack);
                                }
                            }
                        }

                        @Override
                        public void noMatches() {
                            EmbedCreate.createEmbed("📛Не правильный url", textChannel);
                        }

                        @Override
                        public void loadFailed(FriendlyException e) {
                            if (e.toString().startsWith("Something broke when playing the track.")) {
                                EmbedCreate.createEmbed("📛Не удалось загрузить трек", textChannel);
                                scheduler.skip();
                            }
                        }
                    });
                } else {
                    EmbedCreate.createEmbed("❌Не удалось найти кого-то в голосовом канале сучка", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("❌Ты должен быть в голосовом чате дебил, а потом написать плей... еблан", textChannel);
            }
        }
    }

    public static String getURL(String url) {
        String VideoID = url.split("v=")[1];
        return "http://img.youtube.com/vi/" + VideoID + "/hqdefault.jpg";
    }
}
