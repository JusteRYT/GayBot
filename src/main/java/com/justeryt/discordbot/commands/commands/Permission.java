package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

public class Permission implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        try {
            message.delete().queue();
            if (member.hasPermission(net.dv8tion.jda.api.Permission.ADMINISTRATOR)){
                textChannel.sendMessage("Есть права, я не женщина").queue();
            } else {
                textChannel.sendMessage("Походу я женщина,у меня нет прав").queue();
            }
        }catch (InsufficientPermissionException exception){
            String permission = exception.getPermission().getName();
            textChannel.sendMessage("Сори, я женщина и у меня нет прав на " + permission).queue();
        }
    }
}
