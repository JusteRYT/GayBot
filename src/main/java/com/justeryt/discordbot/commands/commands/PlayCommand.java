package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
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
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
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
                    StringBuilder builder = new StringBuilder();
                    for (int i = 1; i < arguments.length; i++) builder.append(arguments[i] + " ");
                    String rawLink = builder.toString().trim();
                    if (rawLink.equals("gachi")) {
                        rawLink = "https://www.youtube.com/playlist?list=PLG_SPmHF0hBfgHU60KwF-2Y4lDX4FD1vu";
                    }
                    if (rawLink.equals("GachiRadio")) {
                        rawLink = "https://www.youtube.com/watch?v=J5M0ZWKVhC0";
                    }
                    if (rawLink.equals("phonk")) {
                        rawLink = "https://www.youtube.com/watch?v=ao4RCon11eY&list=PLNrz3YPMGMM6uvULJYIdLFflAi_xxah0x&index=2";
                    }
                    if (!rawLink.startsWith("https")) {
                        rawLink = "ytsearch: " + rawLink;
                    }
                    final String url = rawLink;
                    assert audioPlayerManager != null;

                    String finalRawLink = rawLink;
                    audioPlayerManager.loadItem(url, new AudioLoadResultHandler() {
                        @Override
                        public void trackLoaded(AudioTrack audioTrack) {
                            if (audioTrack != null) {
                                EmbedCreate.createEmbedTrackLoaded("▶Трек загружен: " + audioTrack.getInfo().title,
                                        getURL(url), String.valueOf(member.getUser().getName()),
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
                                int track = audioPlaylist.getTracks().size();
                                EmbedCreate.createEmbed("▶Аудиоплейлист загружен: " + audioPlaylist.getName(),
                                        "Длительность: " + Utils.formatLongDuration(time),
                                        "GayBot", Main.getIcon(), Color.ORANGE, textChannel, track, finalRawLink, audioPlaylist.getName());
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
                            scheduler.skip();
                            EmbedCreate.createEmbed("📛Не удалось загрузить трек", textChannel);
                        }
                    });
                } else {
                    textChannel.sendMessage("❌Ты должен быть в голосовом чате дебил, а потом написать плей... еблан").queue();
                }
            } else {
                textChannel.sendMessage("❌Ты должен быть в голосовом чате дебил, а потом написать плей... еблан").queue();
            }
        }
    }

    public static String getURL(String url) {
        String VideoID = url.split("v=")[1];
        return "http://img.youtube.com/vi/" + VideoID + "/hqdefault.jpg";
    }
}
