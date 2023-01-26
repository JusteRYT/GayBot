package com.justeryt.discordbot.commands.commands;
import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RollGameCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length > 1) {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(arguments).subList(1, arguments.length));
            Random random = Main.getRandom();
            String Choice = list.get(random.nextInt(list.size()));
            EmbedCreate.createembedRollGame(Choice, textChannel);
        }else {
            EmbedCreate.createEmbed("Что я тебе зарандомлю, ты даже нечего не написал!!!💢",textChannel);
        }
    }
}
