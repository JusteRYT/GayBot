package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

public class KickCommand implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel)  {
        if (arguments.length == 3) {
            try {
                Member target = message.getMentionedMembers().get(0);
                if (target != null) {
                    String reason = arguments[2];
                    if (reason != null) {
                        if (member.hasPermission(Permission.KICK_MEMBERS)) {
                            EmbedCreate.createEmbed("✅Ну пока клоун по имени: " + target.getUser().getName() + ". Причина кика: " + reason, textChannel);
                            guild.kick(target).queue();
                        } else {
                            EmbedCreate.createEmbed("⛔У меня нет прав на данное действие!", textChannel);
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                if (e.toString().startsWith("java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0")) {
                    EmbedCreate.createEmbed("📛Неверный пользователь!", textChannel);
                }
            }
        } else if (arguments.length == 2) {
            EmbedCreate.createEmbed("⛔Введите причину кика!", textChannel);
        } else if (arguments.length == 1) {
            EmbedCreate.createEmbed("⛔Введите кого кикать!", textChannel);
        } else {
            EmbedCreate.createEmbed("⛔Введите кого кикать и причину!", textChannel);
        }
    }
}
