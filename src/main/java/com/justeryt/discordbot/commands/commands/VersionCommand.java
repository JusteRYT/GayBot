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
            EmbedCreate.createVersion("Версия:1.14",
                    """
                            Добавлены кнопки под плеером\s
                            Добавлены новые классы\s
                            Исправлены баги\s             
                            """,
                    """
                            Переработан поиск треков(теперь можно писать !play <url> или <title>\s
                             Добавлены кнопки в поиск треков, в поиске выводится 5 позиций\s
                             Добавлена команда !servers, чтобы смотреть сколько серверов используют бота\s
                             Добавлена команда !history, чтобы смотреть последние 10 треков\s
                             Убраны быстрые плейлисты по типу !play my,!play gachi, теперь можно находить по названию трека\s
                            """, textChannel);
        }
    }
}
