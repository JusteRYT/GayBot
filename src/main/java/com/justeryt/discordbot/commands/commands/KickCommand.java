package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

public class KickCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        if (arguments.length == 3) {
            Member target = message.getMentionedMembers().get(0);
            if (target != null){
                String reason = arguments[2];
                if (reason != null ){
                    if (member.hasPermission(Permission.KICK_MEMBERS)){
                        EmbedCreate.createEmbed("✅Ну пока клоун по имени: " + target.getUser().getName() + ". Причина кика: " + reason, textChannel);
                        target.kick(reason).queue();
                    }
                }
            }
        } else {
            EmbedCreate.createEmbed("⛔Введите кого кикать и причину",textChannel);
        }
    }
}
