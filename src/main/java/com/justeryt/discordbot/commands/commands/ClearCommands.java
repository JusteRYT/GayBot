package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

import java.util.List;


public class ClearCommands implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        if (arguments.length < 2) {
            EmbedCreate.createEmbed("🤡Извините мистер, но вы бы не могли, сука ,после команды ввести число, блять", textChannel);
        } else {
            try {
                try {
                    message.delete().queue();
                } catch (InsufficientPermissionException exception) {
                    EmbedCreate.createEmbed("😅Прости, но ты не дал мне права на это", textChannel);
                }
                List<Message> messageList = textChannel.getHistory().retrievePast(Integer.parseInt(arguments[1])).complete();
                textChannel.deleteMessages(messageList).queue();
                EmbedCreate.createEmbedClear("☺Кароча я удалил твою жизнь, мать, собаку и ту шлюху, о которой не знает твоя девушка!", textChannel);
            } catch (IllegalArgumentException exception) {
                if (exception.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                    EmbedCreate.createEmbedClear("😡Да блять, я не могу нахуй удалить больше 100 сообщений", textChannel);
                } else {
                    EmbedCreate.createEmbedClear("🤔Один слишком мало, тут уже не к тебе претензии, а к разрабу", textChannel);
                }
            }
        }
    }
}



