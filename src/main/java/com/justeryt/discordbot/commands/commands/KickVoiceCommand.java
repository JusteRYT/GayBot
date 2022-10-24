package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;

import static net.dv8tion.jda.api.Permission.ADMINISTRATOR;

public class KickVoiceCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        try {
            if (arguments.length == 2) {
                Member target = message.getMentionedMembers().get(0);
                if (target != null) {
                    if (member.hasPermission(ADMINISTRATOR)) {
                        guild.kickVoiceMember(target).queue();
                        EmbedCreate.createEmbed("✅Кикнул лоха: " + target.getUser().getName()
                                + " с голосового канала", textChannel);
                    } else {
                        EmbedCreate.createEmbed("😡У меня нет прав!!", textChannel);
                    }
                } else {
                    EmbedCreate.createEmbed("📛Я не понимаю кого кикать, хотя понимаю что Гузана" +
                            ", но ты не правильно ввел !kickVoice @Guzan", textChannel);
                }
            } else {
                EmbedCreate.createEmbed("🤦‍♂️Надо вводить так !kickVoice @Guzan", textChannel);
            }
        } catch (IndexOutOfBoundsException e) {
            EmbedCreate.createEmbed("Введите пользователя коректно, я хз кого ты вписал", textChannel);
        }
    }
}