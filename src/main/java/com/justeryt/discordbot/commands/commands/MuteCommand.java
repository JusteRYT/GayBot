package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
public class MuteCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel)  {
        if (arguments.length == 2) {
            try {
                Member target = message.getMentionedMembers().get(0);
                if (target != null) {
                    if(member.hasPermission(Permission.VOICE_MUTE_OTHERS)){
                        EmbedCreate.createEmbed("☺Я замутил этого еблана: " + target.getUser().getName(), textChannel);
                        target.mute(true).queue();
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