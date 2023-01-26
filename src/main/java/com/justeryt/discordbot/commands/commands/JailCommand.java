package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class JailCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        try {
            if (arguments.length == 2) {
                Member target = message.getMentions().getMembers().get(0);
                if (target != null) {
                    if (member.hasPermission(Permission.VOICE_MOVE_OTHERS)) {
                        AudioChannel channel = target.getGuild().getAfkChannel();
                        guild.moveVoiceMember(target, channel).queue();
                        EmbedCreate.createEmbed("✅Мы поместили этого отброса: " + target.getUser().getName()
                                + " в утилизатор", textChannel);
                    } else {
                        EmbedCreate.createEmbed("📛Ты же женщина,прав у тебя нет до 1893(хотя даже после этого нет прав)", textChannel);
                    }
                } else {
                    EmbedCreate.createEmbed("📛Я не понимаю кого банить", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("🤦‍♂️Надо писать вот так !jail @member", textChannel);
            }
        } catch (IndexOutOfBoundsException e) {
            EmbedCreate.createEmbed("📛Вы ввели неверного пользователя!", textChannel);
        }
    }
}
