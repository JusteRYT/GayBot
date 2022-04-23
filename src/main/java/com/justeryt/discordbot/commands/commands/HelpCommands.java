package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;

public class HelpCommands implements ServerCommand {

    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(Color.orange);
        embedBuilder.setTitle("Вот что я умею");
        embedBuilder.setDescription("**🎉!help** - *Ну типо все команды*" +
                "\n**💥!clear <Число 2 и более>** - *Сотру вашу жизнь*" +
                "\n**🤡!kick <Чел> <Причина>** *Нахуй бездаря из  канала*" +
                "\n**❌!ban <Чел> <Причина>** *Ну это прям попадос, команда чисто для гузана*" +
                "\n**✅!unban <Чел>** *Для слабохарактерного быдло, нельзя прощать бездарей(особенно Гузанова)*" +
                "\n**🔊!play <url>**-*Музло ыыыы*" +
                "\n**👀!info <Чел>**-*Узнать все про бездаря*" +
                "\n**☢!leave** - *Ливну с войс чата*" +
                "\n**🔀!shuffle** - *Перемешать плейлист*" +
                "\n**⏭!skip** - *Пропустить трек*" +
                "\n**🔊!volume** - *Настроить звук*");
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
