package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class VersionCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            EmbedCreate.createVersion("Версия:1.14.1",
                    """
                            Добавлена история треков с кнопками, теперь ее можно пролистывать вперед назад\s
                            Изменен подход по обработки никнеймов пользователей\s
                            Добавлены нормальные картинки рангов из доты для команды !dotabuff\s
                            Теперь при команде !leave, либо когда вы отключаете бота от голосового канала, он удаляет очередь\s
                            Добавлены новые кнопки под музыкой, история, громкость, репит(не работает), и ливнуть\s
                            Добавлены обзывательства для людей, которые зашли в голосовой канал\s
                            Всё!                                                       
                            """,
                    """
                            Добавлены кнопки под плеером, next prev, стоп, перемешать, пауза\s
                            Добавление эмодзи на кнопки, но не обычные, а пользовательские\s
                            Переработал очередь треков, чтобы проще было управлять музыкой вперед-назад\s
                            """, textChannel);
        }
    }
}
