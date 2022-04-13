package com.justeryt.discordbot.commands.types;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.w3c.dom.Text;

public interface ServerCommand {
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message);
}
