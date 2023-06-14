package com.justeryt.discordbot.commands.Utils;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Parsing.Rank;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class EmbedCreate {
    public MessageChannel textChannel;
    private static final Guild guildEmoji;

    static {
        assert Main.getJda() != null;
        guildEmoji = Main.getJda().getGuildById(403639391265882115L);
    }

    private static EmbedBuilder AccessEmbed() {
        return new EmbedBuilder();
    }

    public static void createEmbed(String SetTitle, MessageChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        em.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().submitAfter(5, TimeUnit.SECONDS));
    }

    public static void createEmbedClear(String SetTitle, MessageChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        em.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));
    }

    public static void createEmbedTrackScheduler(String title, String Description, String Footer, String Icon,
                                                 MessageChannel textChannel, String Image, Color color, long time,
                                                 String url, String author) {
        Emoji pauseEmoji = guildEmoji.getEmojisByName("pause", true).get(0);
        Emoji stopEmoji = guildEmoji.getEmojisByName("stop", true).get(0);
        Emoji nextEmoji = guildEmoji.getEmojisByName("next", true).get(0);
        Emoji mixEmoji = guildEmoji.getEmojisByName("shuffle", true).get(0);
        Emoji backEmoji = guildEmoji.getEmojisByName("back", true).get(0);
        Emoji gitHub = guildEmoji.getEmojisByName("history", true).get(0);
        Emoji repeat = guildEmoji.getEmojisByName("repeat", true).get(0);
        Emoji upVolume = guildEmoji.getEmojisByName("up", true).get(0);
        Emoji downVolume = guildEmoji.getEmojisByName("down", true).get(0);
        Emoji leave = guildEmoji.getEmojisByName("leave", true).get(0);
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setAuthor("Играет");
        embedBuilder.setTitle(title, url);
        embedBuilder.setDescription(Description);
        embedBuilder.addField("Название канала", author, true);
        embedBuilder.setFooter(Footer, Icon);
        embedBuilder.setThumbnail(Image);
        embedBuilder.setColor(color);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).addActionRow(
                Button.secondary("Previous", backEmoji),
                Button.secondary("PauseOrPlay", pauseEmoji),
                Button.secondary("Stop", stopEmoji),
                Button.secondary("Next", nextEmoji),
                Button.secondary("Shuffle", mixEmoji)).addActionRow(
                Button.secondary("history", gitHub),
                Button.secondary("repeat", repeat),
                Button.secondary("down", downVolume),
                Button.secondary("up", upVolume),
                Button.danger("leave", leave)
        ).queue(message -> message.delete().submitAfter(time, TimeUnit.MILLISECONDS));
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
            , Color color, MessageChannel textChannel, int cost, String url) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setDescription(description);
        embedBuilder.setThumbnail(url);
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
        textChannel.sendTyping().completeAfter(2, TimeUnit.SECONDS);
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

    public static void createEmbedOnJoin(String title, String description, String text, String thunmbail, String addField, TextChannel textChannel) {
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
                                      String AllMatch, String AllMatchWinrate, String rankText,
                                      MessageChannel textChannel) {
        Rank rank = new Rank();
        String result = rank.extractRank(thumbnail);
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("Профиль игрока: " + title);
        embedBuilder.setDescription(String.format("**Роли: ** *%s* **|** *%s*\n **Ранг:** %s", core, supp, rankText));
        embedBuilder.setThumbnail(rank.getRankImages().get(result));
        embedBuilder.addField("Сколько всего игр:", String.format("Матчей: *%s* **|** Винрейт: *%s*", AllMatch, AllMatchWinrate), false);
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
                        """,
                nameCharacter, WonOrNote(WonAndLose), KDA,
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
        textChannel.sendTyping().completeAfter(2, TimeUnit.SECONDS);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(100, TimeUnit.SECONDS));
    }

    public static void EmbedCreateRoll(String member, int procent, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("Пользователь: " + member);
        embedBuilder.addField("Процент: ", procent + "%", false);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createEmbedRollGame(String slovo, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("На основе рандома выбрана следующая игра!!!");
        embedBuilder.setImage("https://media.tenor.com/v0ygh6Q-qtMAAAAi/khersi-dance.gif");
        embedBuilder.addField("Игра: ", slovo, true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createRollPos(String person1, String person2, String person3, String person4, String person5, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("🎉Распределение по ролям!!!🎉");
        embedBuilder.setDescription("Вот что получилось:");
        embedBuilder.setImage("https://media.tenor.com/BSEQAtx0bvQAAAAC/dota2.gif");
        embedBuilder.addField("⚔️Керри (1 pos): ", person1, false);
        embedBuilder.addField("🏹Мидер (2 pos): ", person2, false);
        embedBuilder.addField("🪓Хардлейнер (3 pos): ", person3, false);
        embedBuilder.addField("🛡️Поддержка (4 pos): ", person4, false);
        embedBuilder.addField("💊Полная поддержка (5 pos): ", person5, false);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createVersion(String title, String addfield, String addfield1, MessageChannel textChannel) {
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setDescription("Лог изменений:");
        embedBuilder.addField("1.14: ", addfield, false);
        embedBuilder.addField("1.13: ", addfield1, false);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createChoiceVideo(String argument, String name, String name1, String name2, String name3,
                                         String name4, MessageChannel textChannel) {
        Emoji emojiOne = guildEmoji.getEmojisByName("one", true).get(0);
        Emoji emojiTwo = guildEmoji.getEmojisByName("two", true).get(0);
        Emoji emojiThree = guildEmoji.getEmojisByName("three", true).get(0);
        Emoji emojiFour = guildEmoji.getEmojisByName("four", true).get(0);
        Emoji emojiFive = guildEmoji.getEmojisByName("five", true).get(0);
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle("Вот что я нашёл по вашему запросу: " + argument);
        embedBuilder.addField("Трек 1:", name, false);
        embedBuilder.addField("Трек 2:", name1, false);
        embedBuilder.addField("Трек 3:", name2, false);
        embedBuilder.addField("Трек 4:", name3, false);
        embedBuilder.addField("Трек 5:", name4, false);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        embedBuilder.setTimestamp(Instant.now());
        textChannel.sendMessageEmbeds(embedBuilder.build()).addComponents(ActionRow.of(
                Button.secondary("Choice 1", emojiOne),
                Button.secondary("Choice 2", emojiTwo),
                Button.secondary("Choice 3", emojiThree),
                Button.secondary("Choice 4", emojiFour),
                Button.secondary("Choice 5", emojiFive))).queue(message -> message.delete().submitAfter(20, TimeUnit.SECONDS));
    }

    public static void createHistoryEmbed(List<String> tracks, int startIndex, String track, MessageChannel textChannel
            , int totalPage, int CurrentPage) {
        Emoji emojiNext = guildEmoji.getEmojisByName("vpered", true).get(0);
        Emoji emojiPrev = guildEmoji.getEmojisByName("nazad", true).get(0);
        Emoji emojiKorzina = guildEmoji.getEmojisByName("korzina", true).get(0);
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setDescription("Сейчас играет: " + track);
        embedBuilder.setTitle("История треков");
        embedBuilder.setFooter(String.format("Страница %d из %d", CurrentPage, totalPage));
        embedBuilder.setColor(Color.orange);
        for (int i = 0; i < tracks.size(); i++) {
            embedBuilder.addField("Трек " + (startIndex + i + 1), tracks.get(i), false);
        }
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> {
            message.editMessageComponents(ActionRow.of(Button.secondary("prev", emojiPrev),
                    Button.secondary("next", emojiNext), Button.danger("delete", emojiKorzina))).queue();
        });


    }

    public static Emoji WonOrNote(String text) {
        Emoji win = guildEmoji.getEmojisByName("win", true).get(0);
        Emoji lose = guildEmoji.getEmojisByName("lose", true).get(0);
        if (text.equals("Поражение")) {
            return lose;
        }
        if (text.equals("Победа")) {
            return win;
        }
        return null;
    }
}
