package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;

public class UnBanCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message, VoiceChannel voiceChannel) {
        if (arguments.length == 2) {
            String id = arguments[1];
            guild.unban(id).queue();
            EmbedCreate.createEmbed("✅Я разбанил его: " + id, textChannel);
        } else {
            EmbedCreate.createEmbed("🤦‍Эхх, ну смотри !unban <ЧелID>", textChannel);
        }
    }
}

