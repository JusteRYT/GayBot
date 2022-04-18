package com.justeryt.discordbot.commands.Listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class onJoin extends ListenerAdapter {
    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        Member member = event.getMember();
        if (member.getIdLong() == 334633054779736064L) {
            event.getGuild().getTextChannelById(529237596602105867L).sendMessage("@everyone Зашёл Гузан, мойте жопу").queue();
        }
        if (member.getIdLong() == 277369971779043328L){
            event.getGuild().getTextChannelById(529237596602105867L).sendMessage("**@everyone Готовьте свои жопки, надзиратель уже тут: **" + member.getUser().getName()).queue();
        }
        if (member.getIdLong() == 293989403179745281L){
            event.getGuild().getTextChannelById(529237596602105867L).sendMessage("**@everyone Любитель доры уже тут, угадайте кто он, правильно это же **" + member.getUser().getName()).queue();
        }
        if (member.getIdLong() == 278177107182485504L){
            event.getGuild().getTextChannelById(529237596602105867L).sendMessage("**@everyone Анальный укротитель в дискорде, всем неотраханым просьба зайти и получить свою порцию удовольствия от: " + member.getUser().getName()).queue();
        }
        if (member.getIdLong() == 398228323249029121L){
            event.getGuild().getTextChannelById(529237596602105867L).sendMessage("@everyone Вот он, наш рыбак, танкист и просто дестройер мамкиных писек: " + member.getUser().getName()).queue();
        }
    }
}
