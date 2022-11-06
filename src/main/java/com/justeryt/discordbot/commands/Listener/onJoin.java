package com.justeryt.discordbot.commands.Listener;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import net.dv8tion.jda.api.entities.AudioChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        Member member = event.getMember();
        TextChannel textChannel = event.getJDA().getTextChannelById(529237596602105867L);
        AudioChannel voiceChannel = Objects.requireNonNull(member.getVoiceState()).getChannel();
        if (textChannel != null) {
            if (voiceChannel != null) {
                if (member.getIdLong() == Guzanov) {
                    EmbedCreate.createEmbedOnJoin("Зашёл мистер Гузанов, мойте очко и протрите яички",
                            member.getUser().getName(),
                            "**Это мистер Гузанчик, грязные яички обслуживаются в первую очередь**", member.getUser().getAvatarUrl(),
                            "Зашёл на канал: " + voiceChannel.getName(), textChannel);
                }
                if (member.getIdLong() == Vashkevich) {
                    EmbedCreate.createEmbedOnJoin("**Покровитель молодых женских писек**",
                            member.getUser().getName(),
                            "**Готовьте жопки, надзиратель уже тут: **", member.getUser().getAvatarUrl(),
                            "Зашёл на канал: " + voiceChannel.getName(), textChannel);
                }
                if (member.getIdLong() == Brazilcev) {
                    EmbedCreate.createEmbedOnJoin("**Патаму шта дора дура!!!**",
                            member.getUser().getName(),
                            "**Вот он, тайный поклоник доры: **", member.getUser().getAvatarUrl(),
                            "Зашёл на канал: " + voiceChannel.getName(), textChannel);
                }
                if (member.getIdLong() == Ancverg) {
                    EmbedCreate.createEmbedOnJoin("**Авсюнинский мачо**",
                            member.getUser().getName(),
                            "**Анальный укротитель в дискорде, всем неотраханым просьба зайти и получить свою порцию удовольствия от: **"
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                }
                if (member.getIdLong() == Laxno) {
                    EmbedCreate.createEmbedOnJoin("**Вот он немеций люфтвафен и автор мейнкампфа майнкрафта, называйте как хотите**",
                            member.getUser().getName(),
                            "**Вот он, наш рыбак, танкист и просто дестройер мамкиных писек:  **"
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                }
                if (member.getIdLong() == Roma) {
                    EmbedCreate.createEmbedOnJoin("**С этим парнем шутки плохи: **",
                            member.getUser().getName(),
                            "**Он подчинил себе рой пчелок и потихоньку захватывает мир😅**"
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                }
                if (member.getIdLong() == marycya) {
                    EmbedCreate.createEmbedOnJoin("**💕💕💕Это моя любимая Марусечка💕💕💕**",
                            member.getUser().getName(),
                            "**Вот кто свет моих очей:  **"
                            , member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName(),
                            textChannel);
                }
                if (member.getIdLong() == Dima) {
                    EmbedCreate.createEmbedOnJoin("**Ну вы поглядите на него, с портфелем в туфлях и поганяло коронное: **",
                            member.getUser().getName(), "**Когда то он малолетнюю дочь увел у отца и трахнул под забором, " +
                                    "так что парни бойтесь**", member.getUser().getAvatarUrl(), "Зашёл на канал: " + voiceChannel.getName()
                            , textChannel);
                }
                if (member.getIdLong() == Maksim){
                    EmbedCreate.createEmbedOnJoin("**Если вы близнецы, то он вас взорвет. Ведь это самый жесткий террорист" +
                            "в России.[Осуждаю]", member.getUser().getName(), "**Далеко далеко в горах кто то трахнул овцу," +
                            "так вот, это был Максимка, наш Альфа самец.**", member.getUser().getAvatarUrl(), "Зашёл на канал: " +
                            voiceChannel.getName(), textChannel);
                }
            }
        }
    }
}
