package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.Utils.Utils;
import com.justeryt.discordbot.commands.music.Track;
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
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.managers.AudioManager;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PlayCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        Track track = Main.getTrack();
        if (arguments[1].startsWith("https")) { //! play <url>
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
                    audioManager.setSelfDeafened(true); //Бот не будет слушать вас
                    StringBuilder builder = Main.getStringBuilder();
                    for (int i = 1; i < arguments.length; i++) builder.append(arguments[i]).append(" ");
                    final String url = builder.toString().trim().replace("]", "").replace("[", "");

                    audioPlayerManager.loadItem(url, new AudioLoadResultHandler() {
                        @Override
                        public void trackLoaded(AudioTrack audioTrack) {
                            if (audioTrack != null) {
                                scheduler.addToQueue(audioTrack);
                                if (audioTrack.getDuration() < 175800000) {
                                    EmbedCreate.createEmbedTrackLoaded("▶Трек загружен: " + audioTrack.getInfo().title,
                                            Main.getUrlForVideo(audioTrack.getIdentifier()), member.getUser().getName(),
                                            Utils.bestFormatDuration(audioTrack.getDuration()), textChannel);
                                } else {
                                    EmbedCreate.createEmbedTrackLoaded("▶Трек загружен: " + audioTrack.getInfo().title,
                                            Main.getUrlForVideo(audioTrack.getIdentifier()), member.getUser().getName(),
                                            Utils.bestFormatDuration(audioTrack.getDuration(), audioTrack.getIdentifier()), textChannel);
                                }

                            }
                        }

                        @Override
                        public void playlistLoaded(AudioPlaylist audioPlaylist) {
                            try {
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
                                            "GayBot", Main.getIcon(), Color.ORANGE, textChannel, cost,
                                            Main.getURLImagePlaylist(getUrlPlayList(url)));
                                }
                                for (AudioTrack audioTrack : audioPlaylist.getTracks()) {
                                    scheduler.addToQueue(audioTrack);
                                }
                            } catch (IOException e) {
                                EmbedCreate.createEmbed("Не удалось получить картинку плейлиста📛", textChannel);
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
        } else {
            try {
                StringBuilder builder = Main.getStringBuilder();
                for (int i = 1; i < arguments.length; i++) builder.append(arguments[i]).append("+");
                String response = builder.toString().trim().replace("]", "").replace("[", "");
                track.getJsonResponse(response);
                List<String> title = track.getSearchVideoTitle();
                EmbedCreate.createChoiceVideo(response, title.get(0),
                        title.get(1), title.get(2), title.get(3), title.get(4), textChannel);
            } catch (IOException e) {
                EmbedCreate.createEmbed("Не удалось получить запрос от YoutubeApi", textChannel);
            }
        }
    }
    public static String getUrlPlayList(String url) {
        return url.split("list=")[1];
    }
}
