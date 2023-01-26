package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class UnMuteCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel)  {
        if (arguments.length == 2) {
            try {
                Member target = message.getMentions().getMembers().get(0);
                if (target != null) {
                    if(member.hasPermission(Permission.VOICE_MUTE_OTHERS)){
                        EmbedCreate.createEmbed("👍Я размутил его: " + target.getUser().getName() +", но это в последний раз", textChannel);
                        target.mute(false).queue();
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                if (e.toString().startsWith("java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0")) {
                    EmbedCreate.createEmbed("📛Неверный пользователь!", textChannel);
                }
            }
        }
    }
}
