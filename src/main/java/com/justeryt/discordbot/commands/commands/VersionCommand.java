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
            EmbedCreate.createVersion("Версия:1.13",
                    """
                            Переработан поиск треков(теперь можно писать !play <url> или <title>\s
                            Добавлены кнопки в поиск треков, в поиске выводится 5 позиций\s
                            Добавлена команда !servers, чтобы смотреть сколько серверов используют бота\s
                            Добавлена команда !history, чтобы смотреть последние 10 треков\s
                            Убраны быстрые плейлисты по типу !play my,!play gachi, теперь можно находить по названию трека\s
                            """,
                    """
                            Обновление библиотеки jda\s
                            Оптимизированы методы получение превью у видео\s
                            Теперь бот отправляет сообщения только в свои гильдии, а не в определенные\s
                            Команда !jail теперь отправляет в каналы для afk\s
                            Теперь бот пишет в системные текстовые каналы\s
                            Теперь бот умеет разделять сообщение о информации музыки для разных гильдий\s
                            (Например) - В сервере Уточка играет одна музыка, а в GayMer другая.\s
                            """, textChannel);
        }
    }
}
