package com.justeryt.discordbot.commands.Listener;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class onReadyBot extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        TextChannel textChannel = event.getJDA().getTextChannelById(529237596602105867L);
        EmbedCreate.createEmbed("Я включился!", textChannel);
    }
}
