package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.ListMusic.TrackList;
import com.justeryt.discordbot.commands.Parsing.DotaBuffInfo;
import com.justeryt.discordbot.commands.Parsing.ParserMeme;
import com.justeryt.discordbot.commands.Parsing.ParsingNewsDota;
import com.justeryt.discordbot.commands.Parsing.ParsingNewsSteam;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private final StopCommand stopCommand;
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
        this.stopCommand = new StopCommand();
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
                    helpCommands.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!clear":
                    clearCommands.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!kick":
                    kickCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!test":
                    permission.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!play":
                    playCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!info":
                    userInfoCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!skip":
                    skipCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!shuffle":
                    shuffleCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!volume":
                    volumeCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!leave":
                    leaveCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!remove":
                    removeCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!resume":
                    resumeCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!stop":
                    stopCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!join":
                    joinCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!nowplay":
                    nowPlayingCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!mute":
                    muteCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!unmute":
                    unMuteCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!version":
                    versionCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!bass":
                    bassCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!kickVoice":
                    kickVoiceCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!jail":
                    jailCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!meme":
                    parserMeme.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!steam":
                    parsingNews.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!dota":
                    parsingNewsDota.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!dotabuff":
                    dotaBuffInfo.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
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
        AudioChannel audioChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();
        AudioChannel audioChannel1 = member.getVoiceState().getChannel();
        MessageChannel messageChannel = event.getMessageChannel();
        Message message = null;
        embedBuilder.setFooter("GayBot", Main.getIcon());
        embedBuilder.setColor(Color.orange);
        switch (command) {
            case "play":
                String url = Arrays.toString(event.getOption("url").getAsString().split(" ")).replace("["
                        , " ").replace("]", " ").trim();
                if (url.equals("gachi")) {
                    embedBuilder.setTitle("Выберите плейлист:");
                    embedBuilder.addField("🔊1 Плейлист:", "🎵 Коллекция Крепкой Мужской на 10+ часов гачи 🎵",false);
                    embedBuilder.addField("🔊2 Плейлист:", "🎵 Gachi золотой пантеон 🎵",false);
                    embedBuilder.addField("🔊3 Плейлист:", "🎵 Гачи/gachi 🎵",false);
                    embedBuilder.setImage(Main.getImageMusic());
                    embedBuilder.setTimestamp(Instant.now());
                    event.replyEmbeds(embedBuilder.build()).addActionRow(Button.primary("Gachi", "Плейлист 1"),
                            Button.primary("Gachi1", "Плейлист 2"), Button.primary("Gachi2",
                                    "Плейлист 3")).queue();
                }
                if (url.equals("phonk")) {
                    embedBuilder.setTitle("Выберите плейлист:");
                    embedBuilder.addField("🔊1 Плейлист:", "🎵 Phonk 🎵",false);
                    embedBuilder.addField("🔊2 Плейлист:", "🎵 Best Phonk playlist 🎵",false);
                    embedBuilder.addField("🔊3 Плейлист:", "🎵 AGGRESSIVE PHONK 🎵",false);
                    embedBuilder.setImage(Main.getImageMusic());
                    embedBuilder.setTimestamp(Instant.now());
                    event.replyEmbeds(embedBuilder.build()).addActionRow(Button.primary("Phonk", "Плейлист 1"),
                            Button.primary("Phonk1", "Плейлист 2"), Button.primary("Phonk2",
                                    "Плейлист 3")).queue();
                }
                if (url.equals("GachiRadio")) {
                    if (audioChannel1 != null) {
                        arguments[0] = "!play";
                        arguments[1] = TrackList.getGachiRadio();
                        playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                        event.reply("Запускаю").queue();
                    } else {
                        event.reply("📛Вас нет в голосовом канале").queue();
                    }
                }
                if (url.equals("my")){
                    if (audioChannel1 != null) {
                        arguments[0] = "!play";
                        arguments[1] = TrackList.getMyPlaylist();
                        playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                        event.reply("Запускаю").queue();
                    } else {
                        event.reply("📛Вас нет в голосовом канале").queue();
                    }
                }
                break;
            case "welcome":
                String userTag = event.getUser().getName();
                event.reply("Добро пожаловать на сервер шизофрения **" + userTag + "**!").queue();
                break;
            case "help":
                event.reply("Выполняю!").queue();
                helpCommands.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                break;
        }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome", "Поприветствует такого мудака как ты"));
        commandData.add(Commands.slash("play", "Играй балалайка, играй").addOption(OptionType.STRING, "url",
                "Ссылка на музыку", true));
        commandData.add(Commands.slash("help", "Помощь такому уебану как ты"));
        commandData.add(Commands.slash("test","test"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        String[] arguments = new String[2];
        Guild guild = event.getGuild();
        Member member = event.getMember();
        AudioChannel audioChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();
        AudioChannel audioChannel1 = member.getVoiceState().getChannel();
        MessageChannel messageChannel = event.getMessageChannel();
        Message message = null;
        ArrayList<String> listGachi = TrackList.getGachi();
        ArrayList<String> listPhonk = TrackList.getPhonk();
        if (event.getComponentId().equals("Gachi")) {
            if(audioChannel1 != null) {
                arguments[0] = "!play";
                arguments[1] = listGachi.get(0);
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("✅Запускаю").queue();
            } else {
                event.reply("📛Вас нет в голосовом канале").queue();
            }
        } else if (event.getComponentId().equals("Gachi1")) {
            if (audioChannel1 != null) {
                arguments[0] = "!play";
                arguments[1] = listGachi.get(1);
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("✅Запускаю").queue();
            } else {
                event.reply("📛Вас нет в голосовом канале").queue();
            }
        } else if (event.getComponentId().equals("Gachi2")) {
            if (audioChannel1 != null) {
                arguments[0] = "!play";
                arguments[1] = listGachi.get(2);
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("✅Запускаю").queue();
            } else {
                event.reply("📛Вас нет в голосовом канале").queue();
            }
        } else if (event.getComponentId().equals("Phonk")) {
            if (audioChannel1 != null) {
                arguments[0] = "!play";
                arguments[1] = listPhonk.get(0);
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("✅Запускаю").queue();
            } else {
                event.reply("📛Вас нет в голосовом канале").queue();
            }
        } else if (event.getComponentId().equals("Phonk1")) {
            if (audioChannel1 != null) {
                arguments[0] = "!play";
                arguments[1] = listPhonk.get(1);
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("✅Запускаю").queue();
            } else {
                event.reply("📛Вас нет в голосовом канале").queue();
            }

        } else if (event.getComponentId().equals("Phonk2")) {
            if (audioChannel1 != null) {
                arguments[0] = "!play";
                arguments[1] = listPhonk.get(2);
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("✅Запускаю").queue();
            } else {
                event.reply("📛Вас нет в голосовом канале").queue();
            }
        }
    }
}