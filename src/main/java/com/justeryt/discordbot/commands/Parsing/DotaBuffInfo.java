package com.justeryt.discordbot.commands.Parsing;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class DotaBuffInfo implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        try {
            if (arguments.length == 2) {
                long id = Long.parseLong(arguments[1]);
                Document document1 = Jsoup.connect("https://www.dotabuff.com/players/" + id).userAgent("Chrome/4.0.249.0")
                        .referrer("https://www,google.com").get();
                Document document = Jsoup.connect("https://ru.dotabuff.com/players/" + id).userAgent("Chrome/4.0.249.0")
                        .referrer("https://www,google.com").get();
                Elements position = document.getElementsByClass("label");
                Elements allMatch = document.getElementsByTag("td");
                Elements MostPopularPickHero1 = document1.getElementsByClass("r-table r-only-mobile-5 heroes-overview").
                        get(0).getElementsByClass("r-none-mobile").get(0).getElementsByTag("a");
                Elements MostPopularPickHero2 = document1.getElementsByClass("r-table r-only-mobile-5 heroes-overview").
                        get(0).getElementsByClass("r-none-mobile").get(1).getElementsByTag("a");
                Elements MostPopularPickHero3 = document1.getElementsByClass("r-table r-only-mobile-5 heroes-overview").
                        get(0).getElementsByClass("r-none-mobile").get(2).getElementsByTag("a");
                Elements WinRatePersonal = document1.getElementsByClass("r-body");
                Elements MatchMost = document1.getElementsByClass("r-fluid r-10 r-line-graph");
                Elements WinOrNot = document.getElementsByClass("r-table r-only-mobile-5 performances-overview");
                Elements KDA = document1.getElementsByClass("r-table r-only-mobile-5 performances-overview");
                Elements thunmbailRank = document1.getElementsByClass("rank-tier-base");
                Elements name = document1.getElementsByClass("header-content-title");
                String rank = thunmbailRank.get(0).getElementsByTag("img").attr("src");
                String namePlayer = name.text().replace("Overview", "");
                List<String> pos = Main.getList();
                pos.add(position.get(0).text());//Кор
                pos.add(position.get(6).text());//Сапп
                List<String> Matches = Main.getList();
                Matches.add(allMatch.get(1).text());//Количестов матчей
                Matches.add(allMatch.get(2).text());//Винрейт матчей
                List<String> PickHero = Main.getList();
                PickHero.add(MostPopularPickHero1.get(0).text());//1 Часто выбираемый перс
                PickHero.add(MostPopularPickHero2.get(0).text());//2 часто выбираемый перс
                PickHero.add(MostPopularPickHero3.get(0).text());//3 Часто выбираемый перс
                PickHero.add(MatchMost.get(0).getElementsByClass("r-body").text());//Матчей на персе 1
                PickHero.add(MatchMost.get(3).getElementsByClass("r-body").text());//Матчей на персе 2
                PickHero.add(MatchMost.get(6).getElementsByClass("r-body").text());//Матчей на персе 3
                PickHero.add(WinRatePersonal.get(2).text());//WinRate1
                PickHero.add(WinRatePersonal.get(8).text());//WinRate2
                PickHero.add(WinRatePersonal.get(14).text());//WinRate3
                List<String> nameCharacter = Main.getList();
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(0).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(1).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(2).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(3).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(4).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(5).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(6).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(7).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(8).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                nameCharacter.add(document1.getElementsByClass("r-table r-only-mobile-5 performances-overview").get(0).getElementsByClass("r-row")
                        .get(9).getElementsByClass("r-fluid r-40 r-icon-text").get(0).getElementsByClass("r-body").get(0).getElementsByTag("a").text());
                List<String> WinOrNotGame = Main.getList();
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(2).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(5).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(8).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(11).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(14).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(17).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(20).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(23).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(26).text());
                WinOrNotGame.add(WinOrNot.get(0).getElementsByTag("a").get(29).text());
                List<String> KDAGame = Main.getList();
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(4).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(9).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(14).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(19).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(24).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(29).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(34).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(39).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(44).text());
                KDAGame.add(KDA.get(0).getElementsByClass("r-body").get(49).text());
                EmbedCreate.createDotaBuff(namePlayer, rank, pos.get(0), pos.get(1), PickHero.get(0), PickHero.get(3), PickHero.get(6),
                        PickHero.get(1), PickHero.get(4), PickHero.get(7), PickHero.get(2), PickHero.get(5), PickHero.get(8),
                        nameCharacter.get(0), WinOrNotGame.get(0), KDAGame.get(0), nameCharacter.get(1), WinOrNotGame.get(1),
                        KDAGame.get(1), nameCharacter.get(2), WinOrNotGame.get(2), KDAGame.get(2),
                        nameCharacter.get(3), WinOrNotGame.get(3), KDAGame.get(3),
                        nameCharacter.get(4), WinOrNotGame.get(4), KDAGame.get(4),
                        nameCharacter.get(5), WinOrNotGame.get(5), KDAGame.get(5),
                        nameCharacter.get(6), WinOrNotGame.get(6), KDAGame.get(6),
                        nameCharacter.get(7), WinOrNotGame.get(7), KDAGame.get(7),
                        nameCharacter.get(8), WinOrNotGame.get(8), KDAGame.get(8),
                        nameCharacter.get(9), WinOrNotGame.get(9), KDAGame.get(9),
                        Matches.get(0), Matches.get(1),
                        textChannel);
            } else {
                EmbedCreate.createEmbed("💢Введите так !dotabuff id", textChannel);
            }
        } catch (Exception exception) {
            if(exception instanceof IOException){
                EmbedCreate.createEmbed("💢Не удалось загрузить страницу", textChannel);
            } else if (exception instanceof  IndexOutOfBoundsException) {
                EmbedCreate.createEmbed("📛Приватная страница", textChannel);
            }else {
                EmbedCreate.createEmbed(String.valueOf(exception),textChannel);
            }
        }
    }
}
