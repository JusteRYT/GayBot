package com.justeryt.discordbot;

import com.justeryt.discordbot.commands.Listener.onJoin;
import com.justeryt.discordbot.commands.commands.CommandManager;
import com.justeryt.discordbot.commands.music.AudioManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class Main extends ListenerAdapter {
    //Создаем объект из библиотеки дискорда
    private static JDA jda;
    private static JDABuilder jdaBuilder;
    public static AudioPlayerManager audioPlayerManager;
    private static AudioManager audioManager;

    public static void main(String[] args) throws IOException {
        //Вставляем ключ от бота (Нельзя проебать, а то заного его придется делать)
        jdaBuilder = JDABuilder.createDefault("OTM2NTQxMTcxMjM5NTAxODM0.YfOr7w.5TTeFNtH1cHFpBIDq8MTvJwvUqI");
        //Статус бота (Онлайн, спящий или оффлайн)
        jdaBuilder.setStatus(OnlineStatus.ONLINE);
        //Статус бота (Во что играет или просто цитатка)
        jdaBuilder.setActivity(Activity.playing("Привет я твой персональный бот!"));
        //Делаем обработку ошибки
        jdaBuilder.addEventListeners(new onJoin());
        try {
            jda = jdaBuilder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }

        CommandListUpdateAction action = jda.updateCommands();
        action.addCommands(new CommandData("say", "Отправить сообщение")
                .addOptions(new OptionData(OptionType.STRING, "message", "The message to send").setRequired(true))).complete();
        action.addCommands(new CommandData("play", "Сыграть на балалйке"));
        //команды
        registerCommands();
        //Анимированный статус
        setDescription();
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
}
