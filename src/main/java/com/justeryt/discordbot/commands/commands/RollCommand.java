package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;

import java.util.Random;

public class RollCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        Random random = Main.getRandom();
        try {
            if (arguments.length == 1) {
                int procent = random.nextInt(100);
                EmbedCreate.EmbedCreateRoll(member.getUser().getName(), procent, textChannel);
            }
            if (arguments.length == 3) {
                int min = Integer.parseInt(arguments[1]);
                int max = Integer.parseInt(arguments[2]);
                int procent = (random.nextInt(max - min) + min);
                EmbedCreate.EmbedCreateRoll(member.getUser().getName(), procent, textChannel);
            }
            if (arguments.length == 2){
                EmbedCreate.createEmbed("Нужно вписать ещё одно число: !roll <min> <max> 👌",textChannel);
            }
        }catch (NumberFormatException ex){
            {
                EmbedCreate.createEmbed("Нужно вводить цифры дыбыл 🤡🤡🤡", textChannel);
            }
        }
    }
}
