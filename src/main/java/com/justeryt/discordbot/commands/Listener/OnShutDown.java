package com.justeryt.discordbot.commands.Listener;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnShutDown extends ListenerAdapter {
    @Override
    public void onShutdown(@NotNull ShutdownEvent event) {
        TextChannel textChannel = event.getJDA().getTextChannelById(529237596602105867L);
        EmbedCreate.createEmbed("📛Я выключился",textChannel);
    }
}
