package com.justeryt.discordbot;

import com.justeryt.discordbot.commands.Listener.OnShutDown;
import com.justeryt.discordbot.commands.Listener.onJoin;
import com.justeryt.discordbot.commands.Listener.onMemberJoin;
import com.justeryt.discordbot.commands.Listener.onReadyBot;
import com.justeryt.discordbot.commands.commands.CommandManager;
import com.justeryt.discordbot.commands.music.AudioManager;
import com.justeryt.discordbot.resource.LoadToken;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.apache.commons.lang3.time.StopWatch;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class Main extends ListenerAdapter {
    //Создаем объект из библиотеки дискорда
    private static JDA jda;
    private static JDABuilder jdaBuilder;
    public static AudioPlayerManager audioPlayerManager;
    private static AudioManager audioManager;
    public static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) throws IOException {
        //Вставляем ключ от бота (Нельзя проебать, а то заного его придется делать)
        jdaBuilder = JDABuilder.createDefault(LoadToken.getToken());
        //Статус бота (Онлайн, спящий или оффлайн)
        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        //Статус бота (Во что играет или просто цитатка)
        jdaBuilder.setActivity(Activity.playing("Привет я твой персональный бот!"));
        jdaBuilder.addEventListeners(new onJoin(), new onMemberJoin(), new OnShutDown(), new onReadyBot());
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES);
        jdaBuilder.setMemberCachePolicy(MemberCachePolicy.ALL);
        jdaBuilder.setChunkingFilter(ChunkingFilter.ALL);
        jdaBuilder.enableCache(CacheFlag.ONLINE_STATUS);
        try {
            jda = jdaBuilder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
        //команды
        registerCommands();
        //Анимированный статус
        setDescription();
        stopWatch.start();
        audioPlayerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
        audioManager = new AudioManager();
        //Метод для команд
    }

    private static void registerCommands() {
        CommandManager commandManager = new CommandManager();
        jda.addEventListener(commandManager);
    }

    //Метод статуса
    private static void setDescription() {
        Description description = new Description();
        Timer timer = new Timer();
        timer.schedule(description, 0, 5000); //5 секунд
    }

    public static JDA getJda() {
        if (jda != null) {
            return jda;
        }
        return null;
    }

    public static AudioPlayerManager getAudioPlayerManager() {
        if (audioPlayerManager != null) {
            return audioPlayerManager;
        }
        return null;
    }

    public static AudioManager getAudioManager() {
        if (audioManager != null) {
            return audioManager;
        }
        return null;
    }

    public static String getIcon() {
        return "https://goo.su/vZAAi";
    }
    public static String getImageMusic() {
        return "https://thumbs.gfycat.com/OpulentShortAfricanporcupine-size_restricted.gif";
    }

    public static StringBuilder getStringBuilder() {
        return new StringBuilder();
    }

    public static ArrayList<String> getList() {
        return new ArrayList<>();
    }
    public static Random getRandom(){
        return new Random();
    }
    public static List<Guild> getGuild(){
        return jda.getGuilds();
    }
    public static long getTime(){
        return Main.stopWatch.getTime();
    }


}
