package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;


public class HelpCommands implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        EmbedCreate.createEmbedHelp("Вот что я умею","""
                **🎉!help** - *Ну типо все команды*
                **🎶!bass** - *Добавляет бассы в музло ыыыы*
                **💥!clear <Число 2 и более>** - *Сотру вашу жизнь*
                **🤡!kick <Чел> <Причина>** *Нахуй бездаря с сервера*
                **😅!kickVoice <Чел>** *Уберу этого долбаеба с голосового канала*
                **🔊!play <url> или <title>**-*Музло ыыыы*
                **👀!info <Чел>**-*Узнать все про бездаря*
                **☢!leave** - *Ливну с войс чата*
                **🔀!shuffle** - *Перемешать плейлист*
                **⏭!skip** - *Пропустить трек*
                **🔊!volume** - *Настроить звук + узнать текущую громкость*
                **📛!remove** - *Удалить всю очередь музла*
                **⛔!stop** - *Остановить твою жизнь и трек*
                **▶!resume** - *Продолжить существовать в этом мире и запуск трека*
                **🙋‍♂️!join** - *Подключиться к голосовому каналу*
                **🙊!mute** - *Замутить уебана, который орет не по факту*
                **✌!unmute** - *Размутить еблана, так уж и быть*
                **▶!nowplay** - *Узнать что сейчас ебашит*
                **📢!dota, steam** - *Новости по двум тэгам*
                **🤡!meme** - *Юморестки для вас*
                **🆔!version** - *Это чисто для разраба, вам должно быть похуй*
                **⌚!time** - *Время работы бота*
                **🗒️!history** - *Показать историю треков*
                **☄️!servers** - *Количество серверов*
                **♾️!roll, !rollgame, !rollpos** - *!roll <0-100> - рандом в процентаже, !rollgame <value> рандомить слова через пробел, !rollpos - Рандомные позиции в доте""", "GayBot", textChannel,
                Main.getIcon(), 20 );
    }
}
