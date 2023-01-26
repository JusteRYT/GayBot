package com.justeryt.discordbot.commands.Parsing;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class ParsingNewsDota implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        try {
        if (arguments.length == 1) {
            EmbedCreate.createParserNewsDota(ParserCore.getDotaTitle().get(0), ParserCore.getDotaTitle().get(1), ParserCore.getDotaTitle().get(2)
                    , ParserCore.getDotaTitle().get(3), ParserCore.getDotaTitle().get(4), textChannel);
        } else if (arguments.length == 2) {
            int b = Integer.parseInt(arguments[1]);
            int a = b - 1;
            EmbedCreate.createParserNewsSolo(ParserCore.getDotaTitle().get(a), ParserCore.getListDotaTime().get(a),
                    ParserCore.getLinkDotaNews().get(a), ParserCore.getUrlImageDota().get(a), textChannel);
        }
        }catch (IndexOutOfBoundsException e){
            EmbedCreate.createEmbed("💢Вы ввели неверное число!!!", textChannel);
        }
    }
}

