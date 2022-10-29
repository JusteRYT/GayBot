package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.Utils.EmbedCreate;
import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.entities.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserInfoCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, MessageChannel textChannel, Message message, AudioChannel voiceChannel) {
        if (arguments.length == 2) {
                Member target = message.getMentionedMembers().get(0);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if (target != null) {
                    EmbedCreate.createEmbedUserInfo("Чел - " + target.getUser().getName(), target.getUser().getAvatarUrl(),
                            (target.getTimeJoined().format(formatter)), (target.getTimeCreated().format(formatter)),
                            checkForBot(target), getRoles(target.getRoles()), target.getOnlineStatus(),
                            textChannel);
                }
        } else {
            EmbedCreate.createEmbed("🤡!info <Чел>", textChannel);
        }
    }

    private String checkForBot(Member member) {
        if (member.getUser().isBot()) {
            return "💥Ботяра ебаная";
        } else {
            return "☺Пчел";
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
