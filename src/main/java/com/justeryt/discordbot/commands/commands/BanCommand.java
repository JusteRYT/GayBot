package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

public class BanCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        if (arguments.length == 3) {
            Member target = message.getMentionedMembers().get(0);
            if (target != null) {
                String reason = arguments[2];
                if (reason != null) {
                    if (member.hasPermission(Permission.BAN_MEMBERS)) {
                        target.ban(0, reason).queue();
                        EmbedCreate.createEmbed("Я забанил этого мудака: " + target, textChannel);
                    } else {
                        EmbedCreate.createEmbedBan("📛А прав то у меня нет дебил!!!", textChannel);
                    }
                } else {
                    EmbedCreate.createEmbedBan("💢Что ты написал чудовище. Поясни за что маляву накатал, черт!", textChannel);

                }
            }
        } else {
            EmbedCreate.createEmbedBan("😡Вот так пиши дубень !ban @Guzanov пидорас", textChannel);
        }
    }
}
