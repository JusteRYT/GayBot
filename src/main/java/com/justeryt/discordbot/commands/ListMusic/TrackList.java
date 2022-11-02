package com.justeryt.discordbot.commands.ListMusic;

import com.justeryt.discordbot.Main;

import java.util.ArrayList;
import java.util.Collections;

public class TrackList {
    public static ArrayList<String> getGachi() {
        ArrayList<String> list = Main.getList();
        list.add("https://www.youtube.com/playlist?list=PLG_SPmHF0hBfgHU60KwF-2Y4lDX4FD1vu"); //Коллекция Крепкой Мужской на 10+ часов гачи.
        list.add("https://www.youtube.com/playlist?list=PLipgyCmPvpgOI02msFfwEjRR6aYgEoqyK"); //Gachi золотой пантеон
        list.add("https://www.youtube.com/playlist?list=PLrK-5Wx4NWMqikBMEa11mQ-7CQCAXe2Eo"); //Гачи/gachi
        return list;
    }

    public static ArrayList<String> getPhonk() {
        ArrayList<String> list = Main.getList();
        list.add("https://www.youtube.com/playlist?list=PLXDn2ODuVYuXl5Yoh7Htcqs3WXA_w_Cen"); //Phonk
        list.add("https://www.youtube.com/playlist?list=PLVHr-EkQ_tTPef8vm-ZrANoNGbz6ol8yh"); //Best Phonk playlist
        list.add("https://www.youtube.com/playlist?list=PL_ouFlD0mri3DG47HrrRkTByFYINJuHkE"); //AGGRESSIVE PHONK
        return list;
    }
    public static String getMyPlaylist(){
        ArrayList<String> list = Main.getList();
        list.add("https://www.youtube.com/playlist?list=PLUyFEXTXhpEcG2LR6Axh-wChKKVAhrRXk"); //Ghostemane and more
        return list.get(0);
    }

    public static String getGachiRadio() {
        return "https://www.youtube.com/watch?v=J5M0ZWKVhC0";
    }

    public static String getGachiLink(){
        ArrayList<String> list = Main.getList();
        list.add("https://www.youtube.com/playlist?list=PLG_SPmHF0hBfgHU60KwF-2Y4lDX4FD1vu"); //Коллекция Крепкой Мужской на 10+ часов гачи.
        list.add("https://www.youtube.com/playlist?list=PLipgyCmPvpgOI02msFfwEjRR6aYgEoqyK"); //Gachi золотой пантеон
        list.add("https://www.youtube.com/playlist?list=PLrK-5Wx4NWMqikBMEa11mQ-7CQCAXe2Eo"); //Гачи/gachi
        Collections.shuffle(list);
        return list.get(0);
    }
    public static String getPhonkLink(){
        ArrayList<String> list = Main.getList();
        list.add("https://www.youtube.com/playlist?list=PLXDn2ODuVYuXl5Yoh7Htcqs3WXA_w_Cen"); //Phonk
        list.add("https://www.youtube.com/playlist?list=PLVHr-EkQ_tTPef8vm-ZrANoNGbz6ol8yh"); //Best Phonk playlist
        list.add("https://www.youtube.com/playlist?list=PL_ouFlD0mri3DG47HrrRkTByFYINJuHkE"); //AGGRESSIVE PHONK
        Collections.shuffle(list);
        return list.get(0);
    }
}
