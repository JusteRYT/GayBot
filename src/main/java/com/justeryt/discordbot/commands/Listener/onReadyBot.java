package com.justeryt.discordbot.commands.Listener;

import com.justeryt.discordbot.Main;
import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class onReadyBot extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        List<Guild> guild = Main.getGuild();
        for (Guild value : guild) {
            MessageChannel textChannel = value.getDefaultChannel();
            if (textChannel != null) {
                EmbedCreate.createEmbed("Я включился!", textChannel);
            }

        }
    }
}
