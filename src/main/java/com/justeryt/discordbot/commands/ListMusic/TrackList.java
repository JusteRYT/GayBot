package com.justeryt.discordbot.commands.ListMusic;

import com.justeryt.discordbot.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TrackList {
    public static String getGachi() {
        ArrayList<String> list = Main.getList();
        list.add("https://www.youtube.com/playlist?list=PLG_SPmHF0hBfgHU60KwF-2Y4lDX4FD1vu");
        list.add("https://www.youtube.com/playlist?list=PLipgyCmPvpgOI02msFfwEjRR6aYgEoqyK");
        list.add("https://www.youtube.com/playlist?list=PLrK-5Wx4NWMqikBMEa11mQ-7CQCAXe2Eo");
        Collections.shuffle(list);
        return list.get(0);
    }

    public static String getPhonk() {
        ArrayList<String> list = Main.getList();
        list.add("https://www.youtube.com/playlist?list=PLXDn2ODuVYuXl5Yoh7Htcqs3WXA_w_Cen");
        list.add("https://www.youtube.com/playlist?list=PLVHr-EkQ_tTPef8vm-ZrANoNGbz6ol8yh");
        list.add("https://www.youtube.com/playlist?list=PL_ouFlD0mri3DG47HrrRkTByFYINJuHkE");
        Collections.shuffle(list);
        return list.get(0);
    }

    public static String getGachiRadio() {
        String radio = "https://www.youtube.com/watch?v=J5M0ZWKVhC0";
        return radio;
    }
}
