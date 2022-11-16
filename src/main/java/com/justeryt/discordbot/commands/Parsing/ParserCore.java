package com.justeryt.discordbot.commands.Parsing;

import com.justeryt.discordbot.Main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class ParserCore {
    static Document SteamDocument;
    static Document Dota2Document;

    private static Document getSteamDocument(){
        try {
            SteamDocument = Jsoup.connect("https://vgtimes.ru/tags/Steam/").userAgent("Chrome/4.0.249.0" +
                    "Safari/532.5").referrer("https://www.google.com").get();
            return SteamDocument;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    private static Document getDota2Document(){
        try {
            Dota2Document = Jsoup.connect("https://vgtimes.ru/games/dota-2/news").userAgent("Chrome/4.0.249.0" +
                    "Safari/532.5").referrer("https://www.google.com").get();
            return Dota2Document;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static List<String> getListLinkNews(){
        Document doc = getSteamDocument();
        Elements linknews = doc.getElementsByClass("item-name type0");
        List<String> list =Main.getList();
        list.add(linknews.get(0).getElementsByTag("a").attr("href"));
        list.add(linknews.get(1).getElementsByTag("a").attr("href"));
        list.add(linknews.get(2).getElementsByTag("a").attr("href"));
        list.add(linknews.get(3).getElementsByTag("a").attr("href"));
        list.add(linknews.get(4).getElementsByTag("a").attr("href"));
        return list;
    }
    public static List<String> getTextNews(){
        Document doc = getSteamDocument();
        Elements TitleNews = doc.getElementsByClass("item-name type0");
        List<String> list =Main.getList();
        list.add(TitleNews.get(0).text());
        list.add(TitleNews.get(1).text());
        list.add(TitleNews.get(2).text());
        list.add(TitleNews.get(3).text());
        list.add(TitleNews.get(4).text());
        return list;
    }
    public static List<String> getUrlImageNews(){
        Document doc = getSteamDocument();
        Elements UrlImage = doc.getElementsByClass("image_wrap  type0");
        List<String> list =Main.getList();
        list.add("https://vgtimes.ru" + UrlImage.get(0).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + UrlImage.get(1).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + UrlImage.get(2).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + UrlImage.get(3).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + UrlImage.get(4).getElementsByTag("img").attr("data-src"));
        return list;
    }
    public static List<String> getTimeNews(){
        Document doc = getSteamDocument();
        Elements time = doc.getElementsByClass("news_item_time");
        List<String> list = Main.getList();
        list.add(time.get(0).text());
        list.add(time.get(1).text());
        list.add(time.get(2).text());
        list.add(time.get(3).text());
        list.add(time.get(4).text());
        return list;
    }
    public static List<String> getListDotaTime(){
        Elements dataDota = getDota2Document().getElementsByClass("spar");
        List<String> list = Main.getList();
        list.add(dataDota.get(0).getElementsByClass("d").text());
        list.add(dataDota.get(1).getElementsByClass("d").text());
        list.add(dataDota.get(2).getElementsByClass("d").text());
        list.add(dataDota.get(3).getElementsByClass("d").text());
        list.add(dataDota.get(4).getElementsByClass("d").text());
        return list;
    }
    public static List<String> getLinkDotaNews(){
        Elements UrlDota = getDota2Document().getElementsByClass("pubs_search");
        List<String> list = Main.getList();
        list.add("https://vgtimes.ru" + UrlDota.get(0).getElementsByTag("a").attr("href"));
        list.add("https://vgtimes.ru" + UrlDota.get(1).getElementsByTag("a").attr("href"));
        list.add("https://vgtimes.ru" + UrlDota.get(2).getElementsByTag("a").attr("href"));
        list.add("https://vgtimes.ru" + UrlDota.get(3).getElementsByTag("a").attr("href"));
        list.add("https://vgtimes.ru" + UrlDota.get(4).getElementsByTag("a").attr("href"));
        return list;
    }
    public static List<String> getDotaTitle(){
        Elements TitleDota = getDota2Document().getElementsByClass("title");
        List<String> list = Main.getList();
        list.add(TitleDota.get(0).getElementsByTag("a").text());
        list.add(TitleDota.get(1).getElementsByTag("a").text());
        list.add(TitleDota.get(2).getElementsByTag("a").text());
        list.add(TitleDota.get(3).getElementsByTag("a").text());
        list.add(TitleDota.get(4).getElementsByTag("a").text());
        return list;
    }
    public static List<String> getUrlImageDota(){
        Elements LinkDota = getDota2Document().getElementsByClass("pubs_search");
        List<String> list = Main.getList();
        list.add("https://vgtimes.ru" + LinkDota.get(0).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + LinkDota.get(0).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + LinkDota.get(0).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + LinkDota.get(0).getElementsByTag("img").attr("data-src"));
        list.add("https://vgtimes.ru" + LinkDota.get(0).getElementsByTag("img").attr("data-src"));
        return list;
    }
}
