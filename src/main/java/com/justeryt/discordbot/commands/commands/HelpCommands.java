package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;


public class HelpCommands implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        EmbedCreate.createEmbedHelp("Вот что я умею","""
                **🎉!help** - *Ну типо все команды*
                **💥!clear <Число 2 и более>** - *Сотру вашу жизнь*
                **🤡!kick <Чел> <Причина>** *Нахуй бездаря из  канала*
                **❌!ban <Чел> <Причина>** *Ну это прям попадос, команда чисто для гузана*
                **✅!unban <Чел>** *Для слабохарактерного быдло, нельзя прощать бездарей(особенно Гузанова)*
                **🔊!play <url>**-*Музло ыыыы*
                **👀!info <Чел>**-*Узнать все про бездаря*
                **☢!leave** - *Ливну с войс чата*
                **🔀!shuffle** - *Перемешать плейлист*
                **⏭!skip** - *Пропустить трек*
                **🔊!volume** - *Настроить звук*
                **📛!remove** - *Удалить всю очередь музла*
                **⛔!stop** - *Остановить твою жизнь и трек*
                **▶!resume** - *Продолжить существовать в этом мире и запуск трека*""", "GayBot", textChannel,
                Main.getIcon(), 20 );
    }
}
