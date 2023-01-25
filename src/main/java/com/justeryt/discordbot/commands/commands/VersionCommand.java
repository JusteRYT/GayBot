package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;

public class VersionCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            EmbedCreate.createVersion("Версия:1.09",
                    "Добавлены команды !roll, !rollgame !rollpos !time \n" +
                            "Исправлен метод onReady \n" +
                            "Теперь бот пишет в текстовые каналы по умолчанию", textChannel);
        }
    }
}
