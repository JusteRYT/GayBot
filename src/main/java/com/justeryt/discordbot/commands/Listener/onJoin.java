package com.justeryt.discordbot.commands.Listener;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.Utils.RandomWords;
import com.justeryt.discordbot.commands.music.MusicController;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class onJoin extends ListenerAdapter {
    private final long Roma = 297484435673186305L;
    private final long Guzanov = 334633054779736064L;
    private final long Vashkevich = 277369971779043328L;
    private final long Brazilcev = 293989403179745281L;
    private final long Ancverg = 278177107182485504L;
    private final long Laxno = 398228323249029121L;
    private final long marycya = 996030565717397625L;
    private final long Dima = 294881802676469761L;
    private final long Maksim = 370241725597351936L;

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        Member member = event.getMember();
        TextChannel textChannel = event.getGuild().getDefaultChannel().asTextChannel();
        AudioChannel voiceChannel = Objects.requireNonNull(member.getVoiceState()).getChannel();
        if (!(event.getEntity().getId().equals(event.getJDA().getSelfUser().getId()) && event.getChannelLeft() != null)) {
            if (voiceChannel != null) {
                if (member.getIdLong() == Guzanov) {
                    EmbedCreate.createEmbedOnJoin("Зашёл мистер Гузанов, мойте очко и протрите яички",
                            member.getEffectiveName(),
                            RandomWords.generateInsult(), member.getUser().getAvatarUrl(),
                            "Зашёл на канал: " + voiceChannel.getName(), textChannel);
                } else if (member.getIdLong() == Vashkevich) {
                    EmbedCreate.createEmbedOnJoin("**Покровитель молодых женских писек**",
                            member.getEffectiveName(),
                            RandomWords.generateInsult(), member.getUser().getAvatarUrl(),
                            "Зашёл на канал: " + voiceChannel.getName(), textChannel);
                } else if (member.getIdLong() == Brazilcev) {
                    EmbedCreate.createEmbedOnJoin("**Патаму шта дора дура!!!**",
                            member.getEffectiveName(),
                            RandomWords.generateInsult(), member.getUser().getAvatarUrl(),
                            "Зашёл на канал: " + voiceChannel.getName(), textChannel);
                } else if (member.getIdLong() == Ancverg) {
                    EmbedCreate.createEmbedOnJoin("**Авсюнинский мачо**",
                            member.getEffectiveName(),
                            RandomWords.generateInsult()
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                } else if (member.getIdLong() == Laxno) {
                    EmbedCreate.createEmbedOnJoin("**Вот он немеций люфтвафен и автор мейнкампфа майнкрафта, называйте как хотите**",
                            member.getEffectiveName(),
                            RandomWords.generateInsult()
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                } else if (member.getIdLong() == Roma) {
                    EmbedCreate.createEmbedOnJoin("**С этим парнем шутки плохи: **",
                            member.getEffectiveName(),
                            RandomWords.generateInsult()
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                } else if (member.getIdLong() == marycya) {
                    EmbedCreate.createEmbedOnJoin("**💕💕💕Это моя любимая Марусечка💕💕💕**",
                            member.getEffectiveName(),
                            RandomWords.generateInsult()
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                } else if (member.getIdLong() == Dima) {
                    EmbedCreate.createEmbedOnJoin("**Ну вы поглядите на него, с портфелем в туфлях и поганяло коронное: **",
                            member.getEffectiveName(), RandomWords.generateInsult(), member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName()
                            , textChannel);
                } else if (member.getIdLong() == Maksim) {
                    EmbedCreate.createEmbedOnJoin("**Если вы близнецы, то он вас взорвет. Ведь это самый жесткий террорист" +
                            "в России.**[Осуждаю]", member.getEffectiveName(), RandomWords.generateInsult(), member.getUser().getAvatarUrl(), "Зашёл на канал: " +
                            voiceChannel.getName(), textChannel);
                } else {
                    if (!member.getUser().isBot()) {
                        EmbedCreate.createEmbedOnJoin("Смотри кто зашёл", member.getEffectiveName(),
                                RandomWords.generateInsult(), member.getAvatarUrl(), "Зашёл на канал: " +
                                        voiceChannel.getName(), textChannel);
                        System.out.println(member.getUser().isBot());
                    }
                }
            }
        } else {
            MusicController musicController = Main.getAudioManager().getMusicController(event.getGuild().getIdLong());
            AudioPlayer player = musicController.getAudioPlayer();
            TrackScheduler scheduler = new TrackScheduler(player, event.getGuild());
            scheduler.drainQueue();
            player.stopTrack();
        }
    }
}
