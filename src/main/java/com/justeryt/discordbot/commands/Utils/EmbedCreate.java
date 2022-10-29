package com.justeryt.discordbot.commands.Utils;

import com.justeryt.discordbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public abstract class EmbedCreate {
    public MessageChannel textChannel;

    private static EmbedBuilder AccessEmbed() {
        return new EmbedBuilder();
    }

    public static void createEmbed(String SetTitle, MessageChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createEmbedClear(String SetTitle, MessageChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));
    }

    public static void createEmbedBan(String SetTitle, MessageChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createEmbedTrackScheduler(String setTitle, String Description, String Footer, String Icon,
                                                 MessageChannel textChannel, String Image, Color color, Long time) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setDescription(Description);
        embedBuilder.setFooter(Footer, Icon);
        embedBuilder.setImage(Image);
        embedBuilder.setColor(color);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(time, TimeUnit.MILLISECONDS));
    }

    public static void createEmbedTrackLoaded(String setTitle, String Thunmbail, String addField, String addField1, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setThumbnail(Thunmbail);
        embedBuilder.addField("Добавил: ", addField, true);
        embedBuilder.addField("Длительность:", addField1, true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }
    public static void createEmbedPlaylistLoad(String title, String description, String footer, String icon
    ,Color color, MessageChannel textChannel, int cost, String url, String name){
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setDescription(description);
        embedBuilder.setAuthor(name, url);
        embedBuilder.addField("Количество треков: ", String.valueOf(cost), true);
        embedBuilder.setFooter(footer, icon);
        embedBuilder.setColor(color);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    public static void createEmbedHelp(String setTitle, String Description, String Footer, MessageChannel textChannel, String Icon, int time) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setDescription(Description);
        embedBuilder.setColor(Color.orange);
        embedBuilder.setFooter(Footer, Icon);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(time, TimeUnit.SECONDS));
    }

    public static void createEmbedUserInfo(String setTitle, String Thunmbail, String addField, String addField1, String addField2
            , String addField3, OnlineStatus addField4, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setThumbnail(Thunmbail);
        embedBuilder.addField("Когда присоединился: ", addField, true);
        embedBuilder.addField("Когда создал акк: ", addField1, true);
        embedBuilder.addField("Проверка на человечность: ", addField2, true);
        embedBuilder.addField("Роль: ", addField3, true);
        embedBuilder.addField("Статус онлайна: ", String.valueOf(addField4), true);
        embedBuilder.setColor(Color.orange);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    public static void createEmbedOnJoin(String title, String description,  String text,String thunmbail, String addField,  MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setDescription("Пользователь: " + description);
        embedBuilder.setThumbnail(thunmbail);
        embedBuilder.addField(text, addField, true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    public static void createEmbedOnMemberJoin(String s, String s1, String avatarUrl, String roles, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(s);
        embedBuilder.setDescription(s1);
        embedBuilder.setThumbnail(avatarUrl);
        embedBuilder.addField("Первоначальная роль: ", roles, true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    public static void createEmbedNowPlay(String s, String icon, String text, String uri, int size, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(s);
        embedBuilder.setThumbnail(icon);
        embedBuilder.setAuthor(text, uri);
        embedBuilder.addField("Количество треков", String.valueOf(size), true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));
    }

    public static void createEmbedException(String title, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
