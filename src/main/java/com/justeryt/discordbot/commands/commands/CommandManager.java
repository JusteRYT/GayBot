package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Parsing.DotaBuffInfo;
import com.justeryt.discordbot.commands.Parsing.ParserMeme;
import com.justeryt.discordbot.commands.Parsing.ParsingNewsDota;
import com.justeryt.discordbot.commands.Parsing.ParsingNewsSteam;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.music.Track;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommandManager extends ListenerAdapter {

    private final HelpCommands helpCommands;
    private final ClearCommands clearCommands;
    private final KickCommand kickCommand;
    private final Permission permission;
    private final PlayCommand playCommand;
    private final UserInfoCommand userInfoCommand;
    private final SkipCommand skipCommand;
    private final ShuffleCommand shuffleCommand;
    private final VolumeCommand volumeCommand;
    private final LeaveCommand leaveCommand;
    private final RemoveCommand removeCommand;
    private final ResumeCommand resumeCommand;
    private final PauseCommand pauseCommand;
    private final JoinCommand joinCommand;
    private final NowPlayingCommand nowPlayingCommand;
    private final MuteCommand muteCommand;
    private final UnMuteCommand unMuteCommand;
    private final VersionCommand versionCommand;
    private final BassCommand bassCommand;
    private final KickVoiceCommand kickVoiceCommand;
    private final JailCommand jailCommand;
    private final ParserMeme parserMeme;
    private final ParsingNewsSteam parsingNews;
    private final ParsingNewsDota parsingNewsDota;
    private final DotaBuffInfo dotaBuffInfo;
    private final RollCommand rollCommand;
    private final RollGameCommand rollGameCommand;
    private final RollPos rollPos;
    private final TimeCommand timeCommand;
    private final HowManyGuildCommand howManyGuildCommand;
    private final HistoryCommand historyCommand;
    private final PreviousCommand previousCommand;
    private final PlayOrNot playOrNot;
    private final StopCommand stopCommand;
    public int currentPage;

    public CommandManager() {
        this.helpCommands = new HelpCommands();
        this.clearCommands = new ClearCommands();
        this.kickCommand = new KickCommand();
        this.permission = new Permission();
        this.playCommand = new PlayCommand();
        this.userInfoCommand = new UserInfoCommand();
        this.skipCommand = new SkipCommand();
        this.shuffleCommand = new ShuffleCommand();
        this.volumeCommand = new VolumeCommand();
        this.leaveCommand = new LeaveCommand();
        this.removeCommand = new RemoveCommand();
        this.resumeCommand = new ResumeCommand();
        this.pauseCommand = new PauseCommand();
        this.joinCommand = new JoinCommand();
        this.nowPlayingCommand = new NowPlayingCommand();
        this.muteCommand = new MuteCommand();
        this.unMuteCommand = new UnMuteCommand();
        this.versionCommand = new VersionCommand();
        this.bassCommand = new BassCommand();
        this.kickVoiceCommand = new KickVoiceCommand();
        this.jailCommand = new JailCommand();
        this.parserMeme = new ParserMeme();
        this.parsingNews = new ParsingNewsSteam();
        this.parsingNewsDota = new ParsingNewsDota();
        this.dotaBuffInfo = new DotaBuffInfo();
        this.rollCommand = new RollCommand();
        this.rollGameCommand = new RollGameCommand();
        this.rollPos = new RollPos();
        this.timeCommand = new TimeCommand();
        this.howManyGuildCommand = new HowManyGuildCommand();
        this.historyCommand = new HistoryCommand();
        this.previousCommand = new PreviousCommand();
        this.playOrNot = new PlayOrNot();
        this.stopCommand = new StopCommand();
        this.currentPage = 1;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getMember().getUser().isBot()) {
            String[] arguments = event.getMessage().getContentRaw().split(" ");
            Guild guild = event.getGuild();
            Member member = event.getMember();
            MessageChannel textChannel = event.getChannel();
            Message message = event.getMessage();
            AudioChannel voiceChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();
            switch (arguments[0]) {
                case "!help":
                    event.getChannel().sendTyping().queue();
                    helpCommands.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!clear":
                    event.getChannel().sendTyping().queue();
                    clearCommands.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!kick":
                    event.getChannel().sendTyping().queue();
                    kickCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!test":
                    event.getChannel().sendTyping().queue();
                    permission.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!play":
                    event.getChannel().sendTyping().queue();
                    playCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!info":
                    event.getChannel().sendTyping().queue();
                    userInfoCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!skip":
                    event.getChannel().sendTyping().queue();
                    skipCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!shuffle":
                    event.getChannel().sendTyping().queue();
                    shuffleCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!volume":
                    event.getChannel().sendTyping().queue();
                    volumeCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!leave":
                    event.getChannel().sendTyping().queue();
                    leaveCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!remove":
                    event.getChannel().sendTyping().queue();
                    removeCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!resume":
                    event.getChannel().sendTyping().queue();
                    resumeCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!stop":
                    event.getChannel().sendTyping().queue();
                    pauseCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!join":
                    event.getChannel().sendTyping().queue();
                    joinCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!nowplay":
                    event.getChannel().sendTyping().queue();
                    nowPlayingCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!mute":
                    event.getChannel().sendTyping().queue();
                    muteCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!unmute":
                    event.getChannel().sendTyping().queue();
                    unMuteCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!version":
                    event.getChannel().sendTyping().queue();
                    versionCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!bass":
                    event.getChannel().sendTyping().queue();
                    bassCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!kickVoice":
                    event.getChannel().sendTyping().queue();
                    kickVoiceCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!jail":
                    event.getChannel().sendTyping().queue();
                    jailCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!meme":
                    event.getChannel().sendTyping().queue();
                    parserMeme.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!steam":
                    event.getChannel().sendTyping().queue();
                    parsingNews.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!dota":
                    event.getChannel().sendTyping().queue();
                    parsingNewsDota.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!dotabuff":
                    event.getChannel().sendTyping().queue();
                    dotaBuffInfo.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!roll":
                    event.getChannel().sendTyping().queue();
                    rollCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!rollgame":
                    event.getChannel().sendTyping().queue();
                    rollGameCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!rollpos":
                    event.getChannel().sendTyping().queue();
                    rollPos.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!time":
                    event.getChannel().sendTyping().queue();
                    timeCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!servers":
                    event.getChannel().sendTyping().queue();
                    howManyGuildCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!history":
                    event.getChannel().sendTyping().queue();
                    historyCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!previous":
                    event.getChannel().sendTyping().queue();
                    previousCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!pause":
                    event.getChannel().sendTyping().queue();
                    pauseCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
            }
        }
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        String[] arguments = new String[2];
        Guild guild = event.getGuild();
        Member member = event.getMember();
        AudioChannel audioChannel = member.getVoiceState().getChannel();
        MessageChannel messageChannel = event.getMessageChannel();
        Message message = event.getMessageChannel().getHistory().getChannel().getHistory().getMessageById(event.getId());
        System.out.println(message);
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        switch (command) {
            case "play" -> {
                String url = Arrays.toString(event.getOption("url").getAsString().split(" ")).replace("["
                        , " ").replace("]", " ").trim();
                arguments[0] = "!play";
                arguments[1] = url;
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Трек запущен");
            }
            case "welcome" -> {
                String userTag = event.getUser().getName();
                event.reply("Добро пожаловать на сервер шизофрения **" + userTag + "**!").queue();
            }
            case "help" -> {
                event.reply("Выполняю!").queue();
                helpCommands.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
            }
            case "pause" -> {
                event.reply("Выполняю!").queue();
                pauseCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
            }
            case "resume" -> {
                event.reply("Выполняю!").queue();
                resumeCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
            }
            case "bass" -> {
                String value = Arrays.toString(event.getOption("value").getAsString().split(""));
                arguments[0] = "!bass";
                arguments[1] = value;
                bassCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "clear" -> {
                String value = Arrays.toString(event.getOption("value").getAsString().split(" "));
                arguments[0] = "!clear";
                arguments[1] = value;
                clearCommands.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "servers" -> {
                howManyGuildCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "jail" -> {
                String people = Arrays.toString(event.getOption("people").getAsString().split(" "));
                arguments[0] = "!jail";
                arguments[1] = people;
                jailCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "kick" -> {
                String people = Arrays.toString(event.getOption("people").getAsString().split(" "));
                arguments[0] = "!kick";
                arguments[1] = people;
                kickCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "leave" -> {
                leaveCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "mute" -> {
                String people = Arrays.toString(event.getOption("people").getAsString().split(" "));
                arguments[0] = "!mute";
                arguments[1] = people;
                muteCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "unmute" -> {
                String people = Arrays.toString(event.getOption("people").getAsString().split(" "));
                arguments[0] = "!unmute";
                arguments[1] = people;
                unMuteCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "playnow" -> {
                arguments[0] = "!nowplay";
                nowPlayingCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "remove" -> {
                removeCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "roll" -> {
                rollCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "rollpos" -> {
                rollPos.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "shuffle" -> {
                shuffleCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "skip" -> {
                skipCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "time" -> {
                timeCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "userinfo" -> {
                String people = Arrays.toString(event.getOption("people").getAsString().split(" "));
                arguments[0] = "!userinfo";
                arguments[1] = people;
                userInfoCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "version" -> {
                versionCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
            case "volume" -> {
                String value = Arrays.toString(event.getOption("value").getAsString().split(" "));
                arguments[0] = "!volume";
                arguments[1] = value;
                volumeCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю!").queue();
            }
        }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome", "Поприветствует такого мудака как ты"));
        commandData.add(Commands.slash("play", "Играй балалайка, играй").addOption(OptionType.STRING, "url",
                "Ссылка на музыку", true));
        commandData.add(Commands.slash("help", "Помощь такому уебану как ты"));
        commandData.add(Commands.slash("test", "test"));
        commandData.add(Commands.slash("stop", "Остановить трек"));
        commandData.add(Commands.slash("resume", "Продолжить воспроизведение"));
        commandData.add(Commands.slash("bass", "Бассуха").
                addOption(OptionType.STRING, "value", "количество дыцыбел", true));
        commandData.add(Commands.slash("clear", "Очистить чат").
                addOption(OptionType.STRING, "value", "Количество сообщений", true));
        commandData.add(Commands.slash("servers", "Количество серверов"));
        commandData.add(Commands.slash("jail", "Поместить плебея в тюрьму")
                .addOption(OptionType.STRING, "people", "Чел", true));
        commandData.add(Commands.slash("join", "Присоединиться к серверу"));
        commandData.add(Commands.slash("kick", "Кикнуть чела")
                .addOption(OptionType.STRING, "people", "Чел", true));
        commandData.add(Commands.slash("leave", "Бот ливнет с чата"));
        commandData.add(Commands.slash("mute", "Замутить чела")
                .addOption(OptionType.STRING, "people", "Чел", true));
        commandData.add(Commands.slash("playnow", "Какая музыка сейчас играет"));
        commandData.add(Commands.slash("remove", "Удалить очередь"));
        commandData.add(Commands.slash("roll", "Рандомное число")
                .addOption(OptionType.STRING, "value", "число", true));
        commandData.add(Commands.slash("rollpos", "Рандом позиций в доте"));
        commandData.add(Commands.slash("shuffle", "Перемешивание очереди"));
        commandData.add(Commands.slash("skip", "Пропуск трека"));
        commandData.add(Commands.slash("time", "Время работы бота"));
        commandData.add(Commands.slash("userinfo", "Информация о человеке")
                .addOption(OptionType.STRING, "people", "чел", true));
        commandData.add(Commands.slash("version", "Версия бота"));
        commandData.add(Commands.slash("volume", "Громкость")
                .addOption(OptionType.STRING, "value", "количество громкости", true));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        String[] arguments;
        Guild guild = event.getGuild();
        Member member = event.getMember();
        AudioChannel audioChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();
        AudioChannel audioChannel1 = member.getVoiceState().getChannel();
        MessageChannel messageChannel = event.getMessageChannel();
        Message message = event.getMessage();
        Track track = Main.getTrack();
        try {
            List<String> title = track.getSearchVideoId();
            if (event.getComponentId().equals("Choice 1")) {
                if (audioChannel1 != null) {
                    arguments = new String[2];
                    arguments[0] = "!play";
                    arguments[1] = title.get(0);
                    playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                    event.getMessage().delete().queue();
                    event.reply("✅Запускаю").queue(interactionHook -> interactionHook.deleteOriginal().queue());
                } else {
                    event.reply("📛Вас нет в голосовом канале").queue();
                }
            }
            if (event.getComponentId().equals("Choice 2")) {
                if (audioChannel1 != null) {
                    arguments = new String[2];
                    arguments[0] = "!play";
                    arguments[1] = title.get(1);
                    playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                    event.reply("✅Запускаю").queue(interactionHook -> interactionHook.deleteOriginal().queue());
                } else {
                    event.reply("📛Вас нет в голосовом канале").queue();
                }
            }
            if (event.getComponentId().equals("Choice 3")) {
                if (audioChannel1 != null) {
                    arguments = new String[2];
                    arguments[0] = "!play";
                    arguments[1] = title.get(2);
                    playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                    event.reply("✅Запускаю").queue(interactionHook -> interactionHook.deleteOriginal().queue());
                } else {
                    event.reply("📛Вас нет в голосовом канале").queue();
                }
            }
            if (event.getComponentId().equals("Choice 4")) {
                if (audioChannel1 != null) {
                    arguments = new String[2];
                    arguments[0] = "!play";
                    arguments[1] = title.get(3);
                    playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                    event.reply("✅Запускаю").queue(interactionHook -> interactionHook.deleteOriginal().queue());
                } else {
                    event.reply("📛Вас нет в голосовом канале").queue();
                }
            }
            if (event.getComponentId().equals("Choice 5")) {
                if (audioChannel1 != null) {
                    event.getMessage().editMessageComponents(event.getMessage().getComponents().get(0).asDisabled()).queue();
                    arguments = new String[2];
                    arguments[0] = "!play";
                    arguments[1] = title.get(4);
                    playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                    event.reply("✅Запускаю").queue(interactionHook -> interactionHook.deleteOriginal().queue());
                } else {
                    event.reply("📛Вас нет в голосовом канале").queue();
                }
            }
            if (event.getComponentId().equals("Next")) {
                if (audioChannel1 != null) {
                    arguments = new String[1];
                    arguments[0] = "!skip";
                    skipCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                    event.getMessage().delete().queue();
                }
            }
            if (event.getComponentId().equals("PauseOrPlay")) {
                arguments = new String[1];
                playOrNot.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
            }
            if (event.getComponentId().equals("Stop")) {
                arguments = new String[1];
                arguments[0] = "!resume";
                stopCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.getMessage().delete().queue();
                event.reply("Выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
            }
            if (event.getComponentId().equals("Previous")) {
                arguments = new String[1];
                arguments[0] = "!previous";
                previousCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.getMessage().delete().queue();
            }
            if (event.getComponentId().equals("Shuffle")) {
                arguments = new String[1];
                arguments[0] = "!shuffle";
                shuffleCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
            }

            if (event.getComponentId().equals("prev")){
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
                if (currentPage > 1) {
                    currentPage--;
                }
                TrackScheduler.history(messageChannel, currentPage);
            }
            if (event.getComponentId().equals("next")){
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
                currentPage++;
                TrackScheduler.history(messageChannel, currentPage);
            }
            if (event.getComponentId().equals("delete")){
                event.reply("Выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
                event.getMessage().delete().queue();
            }
            if (event.getComponentId().equals("history")){
                arguments = new String[1];
                arguments[0] = "!history";
                historyCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
            }
            if (event.getComponentId().equals("repeat")){
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
            }
            if (event.getComponentId().equals("down")){
                arguments = new String[2];
                arguments[0] = "!volume";
                if (volumeCommand.getVolume() > 0) {
                    arguments[1] = String.valueOf(volumeCommand.getVolume() - 20);
                } else {
                    arguments[1] = String.valueOf(volumeCommand.getVolume());
                }
                volumeCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
            }
            if (event.getComponentId().equals("up")){
                arguments = new String[2];
                arguments[0] = "!volume";
                if (volumeCommand.getVolume() < 100) {
                    arguments[1] = String.valueOf(volumeCommand.getVolume() + 20);
                } else {
                    arguments[1] = String.valueOf(volumeCommand.getVolume());
                }
                volumeCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
            }
            if (event.getComponentId().equals("leave")){
                arguments = new String[1];
                leaveCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("выполнено").queue(interactionHook -> interactionHook.deleteOriginal().queueAfter(1, TimeUnit.SECONDS));
                event.getMessage().delete().queue();
            }
        } catch (IOException e) {
            EmbedCreate.createEmbed("Не удалось получить JSON", messageChannel);
        }
    }
}