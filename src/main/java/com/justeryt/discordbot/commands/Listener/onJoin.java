package com.justeryt.discordbot.commands.Listener;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class onJoin extends ListenerAdapter {
    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        Member member = event.getMember();
        TextChannel textChannel = event.getGuild().getTextChannelById(529237596602105867L);
        if (member.getIdLong() == 334633054779736064L) {
            assert textChannel != null;
            EmbedCreate.createEmbedOnJoin("**Зашёл мистер Гузанов, мойте очко и протрите яички**",
                    String.valueOf(member.getUser().getName()),
                            "**Это мистер Гузанчик, грязные яички обслуживаются в первую очередь**", member.getUser().getAvatarUrl(),
                            textChannel);
        }
        if (member.getIdLong() == 277369971779043328L){
            assert textChannel != null;
            EmbedCreate.createEmbedOnJoin("**Покровитель молодых женских писек**",
                    String.valueOf(member.getUser().getName()),
                    "**Готовьте жопки, надзиратель уже тут: **", member.getUser().getAvatarUrl(),
                    textChannel);}
        if (member.getIdLong() == 293989403179745281L){
            assert textChannel != null;
            EmbedCreate.createEmbedOnJoin("**Патаму шта дора дура!!!**",
                    String.valueOf(member.getUser().getName()),
                    "**Вот он, тайный поклоник доры: **", member.getUser().getAvatarUrl(),
                    textChannel);
        }
        if (member.getIdLong() == 278177107182485504L){
            assert textChannel != null;
            EmbedCreate.createEmbedOnJoin("**Авсюнинский мачо**",
                    String.valueOf(member.getUser().getName()),
                    "**Анальный укротитель в дискорде, всем неотраханым просьба зайти и получить свою порцию удовольствия от: **"
                    , member.getUser().getAvatarUrl(),
                    textChannel);
        }
        if (member.getIdLong() == 398228323249029121L){
            assert textChannel != null;
            EmbedCreate.createEmbedOnJoin("**Вот он немеций люфтвафен и автор мейнкампфа майнкрафта, называйте как хотите**",
                    String.valueOf(member.getUser().getName()),
                    "**Вот он, наш рыбак, танкист и просто дестройер мамкиных писек:  **"
                    , member.getUser().getAvatarUrl(),
                    textChannel);
        }
    }
}
