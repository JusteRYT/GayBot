package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.music.TrackScheduler;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.util.ArrayList;

public class HistoryCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 1) {
            ArrayList<String> name = TrackScheduler.getTitle();
            StringBuilder stringBuilder = Main.getStringBuilder();
            if (name != null) {
                int k = 1;
                for (int i = name.size() - 1; i > -1; i--, k++) {
                    stringBuilder.append(String.format("Трек %d: %s\n", k, name.get(i)));
                }
                EmbedCreate.createHistoryEmbed(stringBuilder.toString(), textChannel);
            } else {
                EmbedCreate.createEmbed("Лист пустой!", textChannel);
            }
        }
    }
}
