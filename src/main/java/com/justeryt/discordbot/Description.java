package com.justeryt.discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

import java.util.TimerTask;

public class Description extends TimerTask {

    private int count = 0;
    private final JDA jda = Main.getJda();
    private final String[] messages = {"Я ваш гей Бот", "Меня создал гей-разработчик(пидр ещё тот)", "И при этом все это на java", "Он меня держит в плену помогите", "Если не знаешь команды пиши !help"};

    @Override
    public void run() {
        if (jda != null) {
            jda.getPresence().setActivity(Activity.watching(messages[count]));
            count = (count + 1) % messages.length;
        }
    }
}
