package com.justeryt.discordbot.commands.types;

import net.dv8tion.jda.api.entities.*;
public interface ServerCommand {
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel);
}
