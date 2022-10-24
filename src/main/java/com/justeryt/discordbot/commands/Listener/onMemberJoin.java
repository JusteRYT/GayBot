package com.justeryt.discordbot.commands.Listener;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class onMemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Member member = event.getMember();
        TextChannel textChannel = event.getJDA().getTextChannelById(529237596602105867L);
        assert textChannel != null;
        if(!member.getUser().isBot()) {
            EmbedCreate.createEmbedOnMemberJoin("🎉🎉🎉Встречайте нового пользователя!!!🎉🎉🎉", "Пользователь:" + member.getUser().getName(),
                    member.getUser().getAvatarUrl(),getRoles(member.getRoles()), textChannel);
        } else {
            EmbedCreate.createEmbedOnMemberJoin("🎉🎉🎉Встречайте нового Бота>!!!🎉🎉🎉", "Ботяра:" + member.getUser().getName(),
                    member.getUser().getAvatarUrl(),getRoles(member.getRoles()), textChannel);
        }
    }
    private String getRoles(List rolesList) {
        String roles = "";
        if (!rolesList.isEmpty()) {
            Role tempRole = (Role) rolesList.get(0);
            for (int i = 0; i < rolesList.size(); i++) {
                tempRole = (Role) rolesList.get(i);
                roles = tempRole.getName();
            }

        } else {
            roles = "No roles";
        }
        return roles;
    }
}
