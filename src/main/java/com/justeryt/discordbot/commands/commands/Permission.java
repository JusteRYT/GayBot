package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

public class Permission implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel)  {
        try {
            message.delete().queue();
            if (member.hasPermission(net.dv8tion.jda.api.Permission.ADMINISTRATOR)){
                EmbedCreate.createEmbed("✅Есть права, я не женщина", textChannel);
            } else {
                EmbedCreate.createEmbed("💢Походу я женщина,у меня нет прав", textChannel);
            }
        }catch (InsufficientPermissionException exception){
            String permission = exception.getPermission().getName();
            EmbedCreate.createEmbed("❌Сори, я женщина и у меня нет прав на " + permission, textChannel);
        }
    }
}
