package com.justeryt.discordbot.commands.commands;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandManager extends ListenerAdapter {

    private final HelpCommands helpCommands;
    private final ClearCommands clearCommands;
    private final KickCommand kickCommand;
    private final BanCommand banCommand;
    private final UnBanCommand unBanCommand;
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

    public CommandManager() {
        this.helpCommands = new HelpCommands();
        this.clearCommands = new ClearCommands();
        this.kickCommand = new KickCommand();
        this.banCommand = new BanCommand();
        this.unBanCommand = new UnBanCommand();
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
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (!event.getMember().getUser().isBot()) {
            String[] arguments = event.getMessage().getContentRaw().split(" ");
            Guild guild = event.getGuild();
            Member member = event.getMember();
            TextChannel textChannel = event.getChannel();
            Message message = event.getMessage();
            VoiceChannel voiceChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();

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
                case "!ban":
                    banCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
                    break;
                case "!unban":
                    unBanCommand.performCommand(arguments, guild, member, textChannel, message, voiceChannel);
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
            }
        }
    }
}

