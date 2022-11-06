package com.justeryt.discordbot.commands.Parsing;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Random;

public class ParserMeme implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            try {
                Connection conn1 = Jsoup.connect("https://www.memify.ru/top/");
                Document doc1 = conn1.get();
                Random random = new Random();
                Elements id = doc1.select("a[class=infinite-more-link btn btn-default]");
                String next = id.attr("href");
                int Page = Integer.parseInt(next.substring(5));
                int url = random.nextInt(Page);
                Connection conn = Jsoup.connect("https://www.memify.ru/top/" + url).maxBodySize(0)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0");
                Document doc = conn.get();
                Elements jpg = doc.select("img[src$=jpg]");
                Element infoJpg = jpg.get(random.nextInt(jpg.size()));
                String imgUrl = infoJpg.attr("src"); // Ссылка на картинку
                String Title = infoJpg.attr("alt"); // Заголовок к картинки
                EmbedCreate.createParser(Title, imgUrl, textChannel);

            } catch (IOException e) {
                EmbedCreate.createEmbed("💢Не удалось получить доступ к сайту", textChannel);
            }
        } else {
            EmbedCreate.createEmbed("Хуйня", textChannel);
        }
    }
}
