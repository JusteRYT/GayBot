package com.justeryt.discordbot.commands.Utils;

import com.justeryt.discordbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
import java.time.Instant;
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
        em.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createEmbedClear(String SetTitle, MessageChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        em.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));
    }

    public static void createEmbedTrackScheduler(String setTitle, String Description, String Footer, String Icon,
                                                 MessageChannel textChannel, String Image, Color color, Long time) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setDescription(Description);
        embedBuilder.setFooter(Footer, Icon);
        embedBuilder.setImage(Image);
        embedBuilder.setColor(color);
        embedBuilder.setTimestamp(Instant.now());
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
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createEmbedPlaylistLoad(String title, String description, String footer, String icon
            , Color color, MessageChannel textChannel, int cost, String url, String name) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setDescription(description);
        embedBuilder.setAuthor(name, url);
        embedBuilder.addField("Количество треков: ", String.valueOf(cost), true);
        embedBuilder.setFooter(footer, icon);
        embedBuilder.setColor(color);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    public static void createEmbedHelp(String setTitle, String Description, String Footer, MessageChannel textChannel, String Icon, int time) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setDescription(Description);
        embedBuilder.setColor(Color.orange);
        embedBuilder.setFooter(Footer, Icon);
        embedBuilder.setTimestamp(Instant.now());
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
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    public static void createEmbedOnJoin(String title, String description, String text, String thunmbail, String addField, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setDescription("Пользователь: " + description);
        embedBuilder.setThumbnail(thunmbail);
        embedBuilder.addField(text, addField, true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
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
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }

    public static void createEmbedNowPlay(String s, String icon, String text, String uri, int size, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(s);
        embedBuilder.setThumbnail(icon);
        embedBuilder.setAuthor(text, uri);
        embedBuilder.addField("Количество треков: ", String.valueOf(size), true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));
    }

    public static void createEmbedException(String title, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));
        ;
    }

    public static void createParser(String title, String urlImage, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.addField("Заголовок: ", title, false);
        embedBuilder.setImage(urlImage);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));

    }

    public static void createParserNews(String addField, String addField1, String addField2, String addField3,
                                        String addField4, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("Новости Steam");
        embedBuilder.addField("1:", addField, false);
        embedBuilder.addField("2:", addField1, false);
        embedBuilder.addField("3:", addField2, false);
        embedBuilder.addField("4:", addField3, false);
        embedBuilder.addField("5:", addField4, false);
        embedBuilder.setImage("https://goo.su/2U3TLa");
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(25, TimeUnit.SECONDS));
        ;
    }

    public static void createParserNewsSolo(String title, String Description, String LinkNews, String UrlImage, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setAuthor(title, LinkNews);
        embedBuilder.setDescription(Description);
        embedBuilder.setImage(UrlImage);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createParserNewsDota(String addField, String addField1, String addField2, String addField3,
                                            String addField4, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("Новости Dota2");
        embedBuilder.addField("1:", addField, false);
        embedBuilder.addField("2:", addField1, false);
        embedBuilder.addField("3:", addField2, false);
        embedBuilder.addField("4:", addField3, false);
        embedBuilder.addField("5:", addField4, false);
        embedBuilder.setImage("https://thumbs.gfycat.com/EmotionalWaterloggedFalcon-size_restricted.gif");
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(40, TimeUnit.SECONDS));
    }

    public static void createDotaBuff(String title, String thumbnail, String core, String supp, String nameFirstPers, String valuematch
            , String WinRate1, String nameFirstPers2, String valuematch2, String WinRate2, String nameFirstPers3,
                                      String valuematch3, String WinRate3, String nameCharacter, String WonAndLose, String KDA
            , String nameCharacter2, String WonAndLose2, String KDA2, String nameCharacter3, String WonAndLose3, String KDA3,
                                      String nameCharacter4, String WonAndLose4, String KDA4,
                                      String nameCharacter5, String WonAndLose5, String KDA5,
                                      String nameCharacter6, String WonAndLose6, String KDA6,
                                      String nameCharacter7, String WonAndLose7, String KDA7,
                                      String nameCharacter8, String WonAndLose8, String KDA8,
                                      String nameCharacter9, String WonAndLose9, String KDA9,
                                      String nameCharacter10, String WonAndLose10, String KDA10,
                                      String AllMatch, String AllMatchWinrate,
                                      MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("Профиль игрока: " + title);
        embedBuilder.setDescription(String.format("**Роли: ** *%s* **|** *%s*", core, supp));
        embedBuilder.setThumbnail(thumbnail);
        embedBuilder.addField("Сколько всего игр:", String.format("Матчей: *%s* **|** Винрейт: *%s*",AllMatch, AllMatchWinrate), false);
        embedBuilder.addField("*1 top pick hero:*", String.format("**Герой:** *%s* \n **Матчей:** *%s* \n **Винрейт:** *%s*", nameFirstPers, valuematch, WinRate1), false);
        embedBuilder.addField("*2 top pick hero:*", String.format("**Герой:** *%s* \n **Матчей:** *%s* \n **Винрейт:** *%s*", nameFirstPers2, valuematch2, WinRate2), false);
        embedBuilder.addField("*3 top pick hero:*", String.format("**Герой:** *%s* \n **Матчей:** *%s* \n **Винрейт:** *%s*", nameFirstPers3, valuematch3, WinRate3), false);
        embedBuilder.addField("Последние игры:", String.format(
                """
                        **1 Матч:** *%s* | %s | KDA: *%s*\s
                        **2 Матч:** *%s* | %s | KDA: *%s*\s
                        **3 Матч:** *%s* | %s | KDA: *%s*\s
                        **4 Матч:** *%s* | %s | KDA: *%s*\s
                        **5 Матч:** *%s* | %s | KDA: *%s*\s
                        **6 Матч:** *%s* | %s | KDA: *%s*\s
                        **7 Матч:** *%s* | %s | KDA: *%s*\s
                        **8 Матч:** *%s* | %s | KDA: *%s*\s
                        **9 Матч:** *%s* | %s | KDA: *%s*\s
                        **10 Матч:** *%s* | %s | KDA: *%s*\s
                        """, nameCharacter, WonOrNote(WonAndLose), KDA,
                nameCharacter2, WonOrNote(WonAndLose2), KDA2,
                nameCharacter3, WonOrNote(WonAndLose3), KDA3,
                nameCharacter4, WonOrNote(WonAndLose4), KDA4,
                nameCharacter5, WonOrNote(WonAndLose5), KDA5,
                nameCharacter6, WonOrNote(WonAndLose6), KDA6,
                nameCharacter7, WonOrNote(WonAndLose7), KDA7,
                nameCharacter8, WonOrNote(WonAndLose8), KDA8,
                nameCharacter9, WonOrNote(WonAndLose9), KDA9,
                nameCharacter10, WonOrNote(WonAndLose10), KDA10), false);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(100, TimeUnit.SECONDS));
    }
    public static String WonOrNote(String text){
        if(text.equals("Поражение")){
            return "📛";
        }
        if(text.equals("Победа")){
            return "✅";
        }
        return null;
    }
}
