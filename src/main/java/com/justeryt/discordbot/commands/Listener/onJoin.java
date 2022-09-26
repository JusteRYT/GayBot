package com.justeryt.discordbot.commands.Listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class onJoin extends ListenerAdapter {
    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        Member member = event.getMember();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        if (member.getIdLong() == 334633054779736064L) {
            embedBuilder.setTitle("**Зашёл мистер Гузанов, мойте очко и протрите яички**");
            embedBuilder.addField("**Зашёл мистер Гузанов, мойте очко и протрите яички**",String.valueOf(member.getUser().getName()), true);
            embedBuilder.setThumbnail(member.getUser().getAvatarUrl());
            event.getGuild().getTextChannelById(529237596602105867L).sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
        }
        if (member.getIdLong() == 277369971779043328L){
            embedBuilder.setTitle("**Зашёл в голосовой канал DOTA2**");
            embedBuilder.addField("**Готовьте жопки, надзиратель уже тут: **",String.valueOf(member.getUser().getName()), true);
            embedBuilder.setThumbnail(member.getUser().getAvatarUrl());
            event.getGuild().getTextChannelById(529237596602105867L).sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
        }
        if (member.getIdLong() == 293989403179745281L){
            embedBuilder.setTitle("**Зашёл в голосовой канал DOTA2**");
            embedBuilder.addField("**Вот он, тайный поклоник доры: **",String.valueOf(member.getUser().getName()), true);
            embedBuilder.setThumbnail(member.getUser().getAvatarUrl());
            event.getGuild().getTextChannelById(529237596602105867L).sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
        }
        if (member.getIdLong() == 278177107182485504L){
            embedBuilder.setTitle("**Зашёл в голосовой канал DOTA2**");
            embedBuilder.addField("**Анальный укротитель в дискорде, всем неотраханым просьба зайти и получить свою порцию удовольствия от: **",String.valueOf(member.getUser().getName()), true);
            embedBuilder.setThumbnail(member.getUser().getAvatarUrl());
            event.getGuild().getTextChannelById(529237596602105867L).sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
        }
        if (member.getIdLong() == 398228323249029121L){
            embedBuilder.setTitle("**Зашёл в голосовой канал DOTA2**");
            embedBuilder.addField("**Вот он, наш рыбак, танкист и просто дестройер мамкиных писек:  **",String.valueOf(member.getUser().getName()), true);
            embedBuilder.setThumbnail(member.getUser().getAvatarUrl());
            event.getGuild().getTextChannelById(529237596602105867L).sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(60, TimeUnit.SECONDS));
        }
    }
}
