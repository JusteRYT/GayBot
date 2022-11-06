package com.justeryt.discordbot.commands.Parsing;


import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;

public class ParsingNewsSteam implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        try{
        if (arguments.length == 1){
            EmbedCreate.createParserNews(ParserCore.getTextNews().get(0),ParserCore.getTextNews().get(1),
                    ParserCore.getTextNews().get(2),ParserCore.getTextNews().get(3),ParserCore.getTextNews().get(4), textChannel);
        } else if (arguments.length ==2) {
            int b = Integer.parseInt(arguments[1]);
            int a = b-1;
            EmbedCreate.createParserNewsSolo(ParserCore.getTextNews().get(a), ParserCore.getTimeNews().get(a),
                    ParserCore.getListLinkNews().get(a), ParserCore.getUrlImageNews().get(a), textChannel);
        }
        }catch (IndexOutOfBoundsException e){
            EmbedCreate.createEmbed("💢Больше 5 нельзя!!!", textChannel);
        }
    }
}
