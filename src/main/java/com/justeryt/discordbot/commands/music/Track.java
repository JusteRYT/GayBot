package com.justeryt.discordbot.commands.music;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.resource.LoadToken;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Track {
    List<String> listTitle = Main.getList();
    List<String> listId = Main.getList();
    public JSONObject object;
    public String argument;

    public Track() {
    }

    public List<String> getSearchVideoId() throws IOException {
        return listId;
    }

    public List<String> getSearchVideoTitle() throws IOException {
        return listTitle;
    }

    public void getJsonResponse(String argument) throws IOException {
        this.argument = argument;
        String url = "https://www.googleapis.com/youtube/v3/search?part=snippet" +
                "&fields=items(snippet(title)snippet(thumbnails)id(videoId)id(playlistId))&q=" +
                argument + "&type=video,playlist&key=AIzaSyABfpNSEasY_mh9CVC2llu-XDIWON0qHHI";
        InputStream is = new URL(url).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String jsonText = Main.readAll(rd);
        this.object = new JSONObject(jsonText);
        this.listTitle.clear();
        this.listId.clear();
        for (int i = 0; i < 5;i++){
            try {
                this.listId.add(i, String.format("https://www.youtube.com/watch?v=%s",object.getJSONArray("items").getJSONObject(i)
                        .getJSONObject("id").getString("videoId")));
            } catch (JSONException e){
                this.listId.add(i,String.format("https://www.youtube.com/playlist?list=%s", object.getJSONArray("items").getJSONObject(i)
                        .getJSONObject("id").getString("playlistId")));
            }
            this.listTitle.add(i,object.getJSONArray("items").getJSONObject(i)
                    .getJSONObject("snippet").getString("title"));
        }
    }
    public static long[] getPublicationVideo(String videoId) throws IOException, ParseException {
        String url = String.format("https://www.googleapis.com/youtube/v3/videos?id=%s&key=%s&part=snippet",videoId,LoadToken.getApiKey());
        InputStream is = new URL(url).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String jsonText = Main.readAll(rd);
        JSONObject object1 = new JSONObject(jsonText);
        String time = object1.getJSONArray("items").getJSONObject(0).getJSONObject("snippet").getString("publishedAt");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        Clock clock = Clock.system(zoneId);
        Date date = simpleDateFormat.parse(time);
        Date date1 = new Date(clock.millis());
        return new long[]{date.getTime(),date1.getTime()};
    }
}
