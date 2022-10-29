package com.justeryt.discordbot.commands.commands;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

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
            }
        }
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        String[] arguments = new String[2];
        Guild guild = event.getGuild();
        Member member = event.getMember();
        AudioChannel audioChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();
        MessageChannel messageChannel = event.getMessageChannel();
        Message message = null;
        switch (command) {
            case "play":
                arguments[0] = "!play";
                arguments[1] = Arrays.toString(event.getOption("url").getAsString().split(" "));
                playCommand.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Запускаю");
                break;
            case "welcome":
                String userTag = event.getUser().getName();
                event.reply("Добро пожаловать на сервер шизофрения **" + userTag + "**!").queue();
                break;
            case "help":
                helpCommands.performCommand(arguments, guild, member, messageChannel, message, audioChannel);
                event.reply("Выполняю");
                break;
            case "join":
        }
    }
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("welcome", "Поприветствует такого мудака как ты"));
        commandData.add(Commands.slash("play", "Играй балалайка, играй").addOption(OptionType.STRING, "url",
                "Ссылка на музыку", true));
        commandData.add(Commands.slash("help", "Помощь такому уебану как ты"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}

