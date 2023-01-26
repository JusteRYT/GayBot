package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import static net.dv8tion.jda.api.Permission.ADMINISTRATOR;

public class KickVoiceCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        try {
            if (arguments.length == 2) {
                Member target = message.getMentions().getMembers().get(0);
                GuildVoiceState voiceState;
                if (target != null) {
                    if (member.hasPermission(ADMINISTRATOR)) {
                        if ((voiceState = target.getVoiceState()) != null) {
                            if (voiceState.getChannel() != null) {
                                guild.kickVoiceMember(target).queue();
                                EmbedCreate.createEmbed("✅Кикнул лоха: " + target.getUser().getName()
                                        + " с голосового канала", textChannel);
                            } else {
                                EmbedCreate.createEmbed("😅Его же нет в голосовом!!!", textChannel);
                            }
                        }else {
                            EmbedCreate.createEmbed("😅Его же нет в голосовом!!!", textChannel);
                        }
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