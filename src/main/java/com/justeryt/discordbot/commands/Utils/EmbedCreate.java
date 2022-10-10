package com.justeryt.discordbot.commands.Utils;

import com.justeryt.discordbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class EmbedCreate {
    public TextChannel textChannel;

    private static EmbedBuilder AccessEmbed(){
        return new EmbedBuilder();
    }

    public static void createEmbed(String SetTitle, TextChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(20,TimeUnit.SECONDS));
    }
    public static void createEmbedClear(String SetTitle, TextChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(15, TimeUnit.SECONDS));
    }
    public static void createEmbedBan(String SetTitle, TextChannel textChannel) {
        EmbedBuilder em = AccessEmbed();
        em.setTitle(SetTitle);
        em.setColor(Color.orange);
        em.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(em.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
    }

    public static void createEmbedTrackScheduler(String setTitle, String Description, String Footer, String Icon,
                                   TextChannel textChannel, String Image, Color color, Long time){
    EmbedBuilder embedBuilder = AccessEmbed();
    embedBuilder.setTitle(setTitle);
    embedBuilder.setDescription(Description);
    embedBuilder.setFooter(Footer, Icon);
    embedBuilder.setImage(Image);
    embedBuilder.setColor(color);
    textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(time, TimeUnit.MILLISECONDS));
    }
    public static void createEmbed(String setTitle, String Description, String Footer, String Icon, Color Color, TextChannel textChannel, int addField, String url,
                                   String namePlayList){
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setDescription(Description);
        embedBuilder.setFooter(Footer, Icon);
        embedBuilder.setColor(Color);
        embedBuilder.addField("Количество треков: ", String.valueOf(addField), true);
        embedBuilder.setAuthor("Ссылка на плейлист:" + namePlayList, url);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
    public static void createEmbedTrackLoaded (String setTitle, String Thunmbail, String addField, String addField1, TextChannel textChannel){
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setThumbnail(Thunmbail);
        embedBuilder.addField("Добавил: ", addField, true);
        embedBuilder.addField("Длительность:", addField1, true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(20,TimeUnit.SECONDS));
    }
    public static void createEmbedHelp(String setTitle, String Description, String Footer, TextChannel textChannel, String Icon, int time){
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setDescription(Description);
        embedBuilder.setColor(Color.orange);
        embedBuilder.setFooter(Footer, Icon);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(time, TimeUnit.SECONDS));
    }
    public static void createEmbedUserInfo(String setTitle, String Thunmbail, String addField, String addField1, String addField2
    ,String addField3, TextChannel textChannel){
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(setTitle);
        embedBuilder.setThumbnail(Thunmbail);
        embedBuilder.addField("Когда присоединился: ", addField, true);
        embedBuilder.addField("Когда создал акк: " , addField1, true);
        embedBuilder.addField("Проверка на человечность: ", addField2, true);
        embedBuilder.addField("Роль: ", addField3, true);
        embedBuilder.setColor(Color.orange);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30, TimeUnit.SECONDS));
    }
     public static void createEmbedOnJoin(String title, String addField, String text, String thunmbail, TextChannel textChannel){
        EmbedBuilder embedBuilder = AccessEmbed();
        embedBuilder.setTitle(title);
        embedBuilder.setThumbnail(thunmbail);
        embedBuilder.addField(text, addField, true);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue(message -> message.delete().queueAfter(30,TimeUnit.SECONDS));
     }

}
