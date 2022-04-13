package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class UnBanCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if (arguments.length == 2) {
            String id = arguments[1];
            guild.unban(id).queue();
        } else {
            textChannel.sendMessage("Эхх, ну смотри !unban <ЧелID>").queue();
        }
    }
}

