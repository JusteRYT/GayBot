package com.justeryt.discordbot.commands.commands;

import com.justeryt.discordbot.commands.types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserInfoCommand implements ServerCommand {
    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(arguments.length == 2) {
            Member target = message.getMentionedMembers().get(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            if(target != null) {
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setColor(Color.YELLOW);
                embedBuilder.setTitle("Чел - " + target.getUser().getName());
                embedBuilder.setThumbnail(target.getUser().getAvatarUrl());
                embedBuilder.addField("Когда присоединился", (target.getTimeJoined().format(formatter)), true);
                embedBuilder.addField("Когда создал акк", (target.getTimeCreated().format(formatter)), true);
                embedBuilder.addField("Проверка на человечность", String.valueOf(checkForBot(target)), true);
                embedBuilder.addField("Роль", getRoles(target.getRoles()), true);
                textChannel.sendMessage(embedBuilder.build()).queue();
            }
        }
    }

    private String checkForBot(Member member) {
        if(member.getUser().isBot()) {
            String check = "Ботяра ебаная";
            return check;
        }else {
            String check = "Человек, но если женщина то нет";
            return check;
        }
    }

    private String getRoles(List rolesList){
        String roles = "";
        if (!rolesList.isEmpty()) {
            Role tempRole = (Role) rolesList.get(0);
            for (int i = 0; i < rolesList.size(); i ++){
                tempRole = (Role) rolesList.get(i);
                roles = tempRole.getName();
            }

        } else {
            roles = "No roles";
        }
        return roles;
    }
}
